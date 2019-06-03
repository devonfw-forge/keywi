package com.devonfw.keywi.keymanagement.logic.api.usecase;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Interface of UcManageKeyList to centralize documentation and signatures of methods.
 */
public interface UcManageKeyList {

  /**
   * @param id the {@link IdRef} of the {@link KeyItem} to delete.
   * @return boolean {@code true} if the keyList has been deleted, {@code false} otherwise
   */
  boolean deleteKeyList(IdRef<KeyList> id);

  /**
   * Saves a keyList and store it in the database.
   *
   * @param keyList the {@link KeyListEto} to create.
   * @return the new {@link KeyListEto} that has been saved with ID and version.
   */
  KeyListEto saveKeyList(KeyListEto keyList);

}
