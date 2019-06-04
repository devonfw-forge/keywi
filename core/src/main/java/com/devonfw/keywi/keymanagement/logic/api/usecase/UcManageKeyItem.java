package com.devonfw.keywi.keymanagement.logic.api.usecase;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Interface of UcManageKeyItem to centralize documentation and signatures of methods.
 */
public interface UcManageKeyItem {

  /**
   * @param id the {@link IdRef} of the {@link KeyItem} to delete.
   * @return boolean {@code true} if the keyItem has been deleted, {@code false} otherwise
   */
  boolean deleteKeyItem(IdRef<KeyItem> id);

  /**
   * Saves a keyItem and store it in the database.
   *
   * @param keyItem the {@link KeyItemEto} to create.
   * @return the new {@link KeyItemEto} that has been saved with ID and version.
   */
  KeyItemEto saveKeyItem(KeyItemEto keyItem);

}
