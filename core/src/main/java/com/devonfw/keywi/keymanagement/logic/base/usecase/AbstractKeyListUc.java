package com.devonfw.keywi.keymanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.keywi.keymanagement.dataaccess.api.repo.KeyListRepository;

/**
 * Abstract use case for {@link com.devonfw.keywi.keymanagement.common.api.KeyList}s providing database access.
 */
public class AbstractKeyListUc extends AbstractKeyObjectUc {

  @Inject
  private KeyListRepository keyListRepository;

  /**
   * @return the {@link KeyListRepository} instance.
   */
  public KeyListRepository getKeyListRepository() {

    return this.keyListRepository;
  }

}
