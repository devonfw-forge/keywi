package com.devonfw.keywi.keymanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.keywi.general.logic.base.AbstractUc;
import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyItemSearchCriteriaTo;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * {@link AbstractUc Use-case} to search and retrieve {@link KeyItem}s.
 *
 * @since 1.0.0
 */
public interface UcFindKeyItem {

  /**
   * @param id the {@link IdRef} of the requested {@link KeyItem}.
   * @return The {@link KeyItemEto} with id 'id'
   */
  KeyItemEto findKeyItem(IdRef<KeyItem> id);

  /**
   * <b>ATTENTION:</b><br>
   * Calling this method may be very expensive. Only use it for {@link KeyList#isCacheable() cachable} {@link KeyList}s.
   * Whenever possible prefer using {@link #findKeyItemEtos(KeyItemSearchCriteriaTo)} instead.
   *
   * @param id the {@link IdRef} of the {@link KeyItem#getKeyListId() owning} {@link KeyList}.
   * @return the {@link List} of ALL {@link KeyItemEto}s.
   */
  List<KeyItemEto> findKeyItemEtosForList(IdRef<KeyList> id);

  /**
   * @param criteria the {@link KeyItemSearchCriteriaTo} specifying the search query.
   * @return the {@link Page} with the matching {@link KeyItemEto}s.
   */
  Page<KeyItemEto> findKeyItemEtos(KeyItemSearchCriteriaTo criteria);

}
