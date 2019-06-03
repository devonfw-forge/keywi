package com.devonfw.keywi.keymanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.keywi.general.logic.api.Keymanagement;
import com.devonfw.keywi.general.logic.base.AbstractComponentFacade;
import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyItem;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyList;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Implementation of component interface of keymanagement
 */
@Named
public class KeymanagementImpl extends AbstractComponentFacade implements Keymanagement {

  @Inject
  private UcFindKeyItem ucFindKeyItem;

  @Inject
  private UcManageKeyItem ucManageKeyItem;

  @Inject
  private UcFindKeyList ucFindKeyList;

  @Inject
  private UcManageKeyList ucManageKeyList;

  @Override
  public List<KeyItemEto> findKeyItemEtosForList(IdRef<KeyList> id) {

    return this.ucFindKeyItem.findKeyItemEtosForList(id);
  }

  @Override
  public Page<KeyItemEto> findKeyItemEtos(KeyItemSearchCriteriaTo criteria) {

    return this.ucFindKeyItem.findKeyItemEtos(criteria);
  }

  @Override
  public KeyItemEto findKeyItem(IdRef<KeyItem> id) {

    return this.ucFindKeyItem.findKeyItem(id);
  }

  @Override
  public KeyItemEto saveKeyItem(KeyItemEto keyitem) {

    return this.ucManageKeyItem.saveKeyItem(keyitem);
  }

  @Override
  public boolean deleteKeyItem(IdRef<KeyItem> id) {

    return this.ucManageKeyItem.deleteKeyItem(id);
  }

  @Override
  public KeyListEto findKeyList(IdRef<KeyList> id) {

    return this.ucFindKeyList.findKeyList(id);
  }

  @Override
  public List<KeyListEto> findKeyListEtos() {

    return this.ucFindKeyList.findKeyListEtos();
  }

  @Override
  public KeyListEto saveKeyList(KeyListEto keylist) {

    return this.ucManageKeyList.saveKeyList(keylist);
  }

  @Override
  public boolean deleteKeyList(IdRef<KeyList> id) {

    return this.ucManageKeyList.deleteKeyList(id);
  }

}
