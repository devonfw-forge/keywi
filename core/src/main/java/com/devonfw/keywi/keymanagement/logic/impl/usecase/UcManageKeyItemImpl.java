package com.devonfw.keywi.keymanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyItemEntity;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem;
import com.devonfw.keywi.keymanagement.logic.base.usecase.AbstractKeyItemUc;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for modifying and deleting KeyItems
 */
@Named
@Validated
@Transactional
public class UcManageKeyItemImpl extends AbstractKeyItemUc implements UcManageKeyItem {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageKeyItemImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_KEY_ITEM)
  public boolean deleteKeyItem(IdRef<KeyItem> id) {

    if (id == null) {
      return false;
    }
    getKeyItemRepository().deleteById(id.getId());
    LOG.debug("The keyItem with id '{}' has been deleted.", id);
    return true;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_KEY_ITEM)
  public KeyItemEto saveKeyItem(KeyItemEto keyItem) {

    Objects.requireNonNull(keyItem, "keyItem");

    KeyItemEntity keyItemEntity = getBeanMapper().map(keyItem, KeyItemEntity.class);
    Long id = keyItem.getId();
    if (id != null) {
      KeyItemEntity keyItemFromDb = getKeyItemRepository().find(id);
      verifyKeyNotModified(keyItem, keyItemFromDb);
    }

    // initialize, validate keyItemEntity here if necessary
    KeyItemEntity resultEntity = getKeyItemRepository().save(keyItemEntity);
    LOG.debug("KeyItem with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, KeyItemEto.class);
  }
}
