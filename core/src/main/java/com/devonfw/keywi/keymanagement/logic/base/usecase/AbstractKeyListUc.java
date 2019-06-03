package com.devonfw.keywi.keymanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.keywi.general.logic.base.AbstractUc;
import com.devonfw.keywi.keymanagement.dataaccess.api.repo.KeyListRepository;

/**
 * Abstract use case for KeyLists, which provides access to the commonly necessary data access objects.
 */
public class AbstractKeyListUc extends AbstractUc {

  /** @see #getKeyListRepository() */
  @Inject
  private KeyListRepository keyListRepository;

  /**
   * Returns the field 'keyListRepository'.
   * 
   * @return the {@link KeyListRepository} instance.
   */
  public KeyListRepository getKeyListRepository() {

    return this.keyListRepository;
  }

}
