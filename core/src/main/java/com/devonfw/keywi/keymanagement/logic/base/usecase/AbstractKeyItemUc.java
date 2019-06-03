package com.devonfw.keywi.keymanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.keywi.general.logic.base.AbstractUc;
import com.devonfw.keywi.keymanagement.dataaccess.api.repo.KeyItemRepository;

/**
 * Abstract use case for KeyItems, which provides access to the commonly necessary data access objects.
 */
public class AbstractKeyItemUc extends AbstractUc {

  /** @see #getKeyItemRepository() */
  @Inject
  private KeyItemRepository keyItemRepository;

  /**
   * Returns the field 'keyItemRepository'.
   * 
   * @return the {@link KeyItemRepository} instance.
   */
  public KeyItemRepository getKeyItemRepository() {

    return this.keyItemRepository;
  }

}
