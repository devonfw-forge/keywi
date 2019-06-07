package com.devonfw.keywi.keymanagement.logic.impl.usecase;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyListEntity;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyList;
import com.devonfw.keywi.keymanagement.logic.base.usecase.AbstractKeyListUc;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for searching, filtering and getting KeyLists
 */
@Named
@Validated
@Transactional
public class UcFindKeyListImpl extends AbstractKeyListUc implements UcFindKeyList {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindKeyListImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST)
  public KeyListEto findKeyList(IdRef<KeyList> id) {

    LOG.debug("Get KeyList with id {} from database.", id);
    if (id == null) {
      return null;
    }
    Optional<KeyListEntity> foundEntity = getKeyListRepository().findById(id.getId());
    if (foundEntity.isPresent()) {
      return getBeanMapper().map(foundEntity.get(), KeyListEto.class);
    } else {
      return null;
    }
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST)
  public KeyListEto findKeyListByKey(String key) {

    LOG.debug("Get KeyList with key {} from database.", key);
    if (key == null) {
      return null;
    }
    KeyListEntity keyListEntity = getKeyListRepository().findByKey(key);
    if (keyListEntity == null) {
      return null;
    } else {
      return getBeanMapper().map(keyListEntity, KeyListEto.class);
    }
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST)
  public List<KeyListEto> findKeyListEtos() {

    List<KeyListEntity> keyListEntities = getKeyListRepository().findAll();
    KeyListEntity keyListEntity1 = new KeyListEntity();
    keyListEntity1.setName("Country");
    keyListEntity1.setId(1L);
    keyListEntity1.setKey("Country");
    keyListEntity1.setComment("Dummy country list");
    keyListEntity1.setModificationCounter(1);
    keyListEntity1.setCacheable(true);
    keyListEntity1.setOrdering(KeyItemProperty.KEY);
    keyListEntity1.setValueRequired(true);

    KeyListEntity keyListEntity2 = new KeyListEntity();
    keyListEntity2.setName("Currency");
    keyListEntity2.setId(2L);
    keyListEntity2.setKey("Currency");
    keyListEntity2.setComment("Dummy currency list");
    keyListEntity2.setModificationCounter(1);
    keyListEntity2.setCacheable(true);
    keyListEntity2.setOrdering(KeyItemProperty.KEY);
    keyListEntity2.setValueRequired(true);

    keyListEntities.add(keyListEntity1);
    keyListEntities.add(keyListEntity2);
    return getBeanMapper().mapList(keyListEntities, KeyListEto.class);
  }

}
