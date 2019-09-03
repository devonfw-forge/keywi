package com.devonfw.keywi.keymanagement.logic.base.usecase;

import java.util.Objects;

import com.devonfw.keywi.general.logic.base.AbstractUc;
import com.devonfw.keywi.keymanagement.common.api.KeyObject;
import com.devonfw.keywi.keymanagement.common.api.exception.KeyModificationException;
import com.devonfw.keywi.keymanagement.dataaccess.api.KeyObjectEntity;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyObjectEto;

/**
 * Abstract use case for {@link KeyObject}s.
 */
public class AbstractKeyObjectUc extends AbstractUc {

  /**
   * Verifies that the {@link com.devonfw.keywi.keymanagement.common.api.KeyObject#getKey() business key} of both given
   * {@link com.devonfw.keywi.keymanagement.common.api.KeyObject}s are equal.
   *
   * @param keyObjectToSave the {@link KeyObjectEto} to save.
   * @param keyObjectFromDb the {@link KeyObjectEntity} loaded from the Database that should be modified.
   */
  protected void verifyKeyNotModified(KeyObjectEto keyObjectToSave, KeyObjectEntity keyObjectFromDb) {

    String keyToSave = keyObjectToSave.getKey();
    if (!Objects.equals(keyToSave, keyObjectFromDb.getKey())) {
      throw new KeyModificationException(keyObjectFromDb, keyToSave);
    }
  }

}
