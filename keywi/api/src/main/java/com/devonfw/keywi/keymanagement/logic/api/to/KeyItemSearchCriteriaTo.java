package com.devonfw.keywi.keymanagement.logic.api.to;

import com.devonfw.keywi.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;
import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.criteria.common.api.query.StringSearchCriteria;

/**
 * {@link AbstractSearchCriteriaTo Search criteria} to find {@link KeyItemEto}s.
 *
 * @since 1.0.0
 */
public class KeyItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private IdRef<KeyList> keyListId;

  private boolean activeOnly;

  private KeyItemProperty ordering;

  private StringSearchCriteria name;

  /**
   * @return keyListId the {@link IdRef} pointing to the {@link KeyList}
   *         {@link com.devonfw.keywi.keymanagement.common.api.KeyItem#getKeyListId() owning} this item. Shall not be
   *         {@code null}.
   */
  public IdRef<KeyList> getKeyListId() {

    return this.keyListId;
  }

  /**
   * @param keyListId new value of {@link #getKeyListId()}.
   */
  public void setKeyListId(IdRef<KeyList> keyListId) {

    this.keyListId = keyListId;
  }

  /**
   * @return activeOnly
   */
  public boolean isActiveOnly() {

    return this.activeOnly;
  }

  /**
   * @param activeOnly new value of {@link #isActiveOnly()}.
   */
  public void setActiveOnly(boolean activeOnly) {

    this.activeOnly = activeOnly;
  }

  /**
   * @return ordering the explicit {@link KeyList#getOrdering() ordering} or {@code null} to use
   *         {@link KeyList#getOrdering() default}.
   */
  public KeyItemProperty getOrdering() {

    return this.ordering;
  }

  /**
   * @param ordering new value of {@link #getOrdering()}.
   */
  public void setOrdering(KeyItemProperty ordering) {

    this.ordering = ordering;
  }

  /**
   * @return name {@link StringSearchCriteria} for {@link KeyItemEto#getName() name}.
   */
  public StringSearchCriteria getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName()}.
   */
  public void setName(StringSearchCriteria name) {

    this.name = name;
  }

}
