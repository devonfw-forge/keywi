package com.devonfw.keywi.keymanagement.logic.impl.usecase;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyListEntity;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList;
import com.devonfw.keywi.keymanagement.logic.base.usecase.AbstractKeyListUc;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Use case implementation for modifying and deleting KeyLists
 */
@Named
@Validated
@Transactional
public class UcManageKeyListImpl extends AbstractKeyListUc implements UcManageKeyList {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageKeyListImpl.class);

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_DELETE_KEY_LIST)
  public boolean deleteKeyList(IdRef<KeyList> id) {

    if (id == null) {
      return false;
    }
    getKeyListRepository().deleteById(id.getId());
    LOG.debug("The keyList with id '{}' has been deleted.", id);
    return true;
  }

  @Override
  @RolesAllowed(ApplicationAccessControlConfig.PERMISSION_SAVE_KEY_LIST)
  public KeyListEto saveKeyList(KeyListEto keyList) {

    Objects.requireNonNull(keyList, "keyList");

    KeyListEntity keyListEntity = getBeanMapper().map(keyList, KeyListEntity.class);

    // initialize, validate keyListEntity here if necessary
    KeyListEntity resultEntity = getKeyListRepository().save(keyListEntity);
    LOG.debug("KeyList with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, KeyListEto.class);
  }
}
