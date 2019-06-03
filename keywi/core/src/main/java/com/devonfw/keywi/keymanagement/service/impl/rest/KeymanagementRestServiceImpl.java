package com.devonfw.keywi.keymanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.keywi.general.logic.api.Keymanagement;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.service.api.rest.KeymanagementRestService;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Keymanagement}.
 */
@Named("KeymanagementRestService")
public class KeymanagementRestServiceImpl implements KeymanagementRestService {

  @Inject
  private Keymanagement keymanagement;

  @Override
  public KeyItemEto findKeyItem(long id) {

    return this.keymanagement.findKeyItem(IdRef.of(id));
  }

  @Override
  public List<KeyListEto> findKeyListEtos() {

    return this.keymanagement.findKeyListEtos();
  }

  @Override
  public List<KeyItemEto> findKeyItemEtosForList(long id) {

    return this.keymanagement.findKeyItemEtosForList(IdRef.of(id));
  }

  @Override
  public Page<KeyItemEto> findKeyItemEtos(KeyItemSearchCriteriaTo criteria) {

    return this.keymanagement.findKeyItemEtos(criteria);
  }

  @Override
  public KeyItemEto saveKeyItem(KeyItemEto keyitem) {

    return this.keymanagement.saveKeyItem(keyitem);
  }

  @Override
  public void deleteKeyItem(long id) {

    this.keymanagement.deleteKeyItem(IdRef.of(id));
  }

  @Override
  public KeyListEto findKeyList(long id) {

    return this.keymanagement.findKeyList(IdRef.of(id));
  }

  @Override
  public KeyListEto saveKeyList(KeyListEto keylist) {

    return this.keymanagement.saveKeyList(keylist);
  }

  @Override
  public void deleteKeyList(long id) {

    this.keymanagement.deleteKeyList(IdRef.of(id));
  }

}
