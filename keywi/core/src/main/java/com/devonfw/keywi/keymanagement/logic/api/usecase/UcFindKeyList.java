package com.devonfw.keywi.keymanagement.logic.api.usecase;

import java.util.List;

import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * {@link com.devonfw.keywi.general.logic.base.AbstractUc Use-case} to search and retrieve {@link KeyList}s.
 *
 * @since 1.0.0
 */
public interface UcFindKeyList {

  /**
   * @param id the {@link IdRef} of the requested {@link KeyList}.
   * @return the {@link KeyListEto} with the given {@code id} or {@code null} if not found.
   */
  KeyListEto findKeyList(IdRef<KeyList> id);

  /**
   * @return the {@link List} of all {@link KeyListEto}s.
   */
  List<KeyListEto> findKeyListEtos();

}
