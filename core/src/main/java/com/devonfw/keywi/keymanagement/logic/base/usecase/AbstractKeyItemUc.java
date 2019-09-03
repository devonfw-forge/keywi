package com.devonfw.keywi.keymanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.keywi.keymanagement.dataaccess.api.repo.KeyItemRepository;

/**
 * Abstract use case for {@link com.devonfw.keywi.keymanagement.common.api.KeyItem}s providing database access.
 */
public class AbstractKeyItemUc extends AbstractKeyObjectUc {

  @Inject
  private KeyItemRepository keyItemRepository;

  /**
   * @return the {@link KeyItemRepository} instance.
   */
  public KeyItemRepository getKeyItemRepository() {

    return this.keyItemRepository;
  }

}
