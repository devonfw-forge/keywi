package com.devonfw.keywi.keymanagement.logic.impl.usecase;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyItemEntity;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyItem;
import com.devonfw.keywi.keymanagement.logic.base.usecase.AbstractKeyItemUc;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for searching, filtering and getting KeyItems
 */
@Named
@Validated
@Transactional
public class UcFindKeyItemImpl extends AbstractKeyItemUc implements UcFindKeyItem {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindKeyItemImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_ITEM)
  public KeyItemEto findKeyItem(IdRef<KeyItem> id) {

    LOG.debug("Get KeyItem with id {} from database.", id);
    if (id == null) {
      return null;
    }
    Optional<KeyItemEntity> foundEntity = getKeyItemRepository().findById(id.getId());
    if (foundEntity.isPresent()) {
      return getBeanMapper().map(foundEntity.get(), KeyItemEto.class);
    } else {
      return null;
    }
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST)
  public List<KeyItemEto> findKeyItemEtosForList(IdRef<KeyList> id) {

    List<KeyItemEntity> items = getKeyItemRepository().findAllForList(id.getId());
    KeyItemEntity item1 = new KeyItemEntity();
    item1.setKey("key1");
    item1.setValue("value1");
    item1.setComment("comment");
    item1.setDisabled(false);
    item1.setName("name1");
    items.add(item1);
    return getBeanMapper().mapList(items, KeyItemEto.class);
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST)
  public List<KeyItemEto> findKeyItemEtosForListByKey(String key) {

    List<KeyItemEntity> items = getKeyItemRepository().findAllForListByKey(key);
    return getBeanMapper().mapList(items, KeyItemEto.class);
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_ITEM)
  public Page<KeyItemEto> findKeyItemEtos(KeyItemSearchCriteriaTo criteria) {

    Page<KeyItemEntity> items = getKeyItemRepository().find(criteria);
    return mapPaginatedEntityList(items, KeyItemEto.class);
  }

}
