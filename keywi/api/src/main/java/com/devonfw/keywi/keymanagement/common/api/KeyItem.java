package com.devonfw.keywi.keymanagement.common.api;

import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Interface for an item of an {@link #getKeyListId() owning} {@link KeyList}.
 */
public interface KeyItem extends KeyObject {

  /** Property name for {@link #getValue()}. */
  String PROPERTY_VALUE = "value";

  /** Column name for {@link #getValue()}. */
  String COLUMN_VALUE = "value";

  /**
   * @return the optional value of this item. May be {@code null}.
   * @see KeyList#isValueRequired()
   * @see KeyList#getValuePattern()
   */
  String getValue();

  /**
   * @param value new value of {@link #getValue()}.
   */
  void setValue(String value);

  /**
   * @return the {@link IdRef} pointing to the {@link KeyList} owning this item.
   */
  IdRef<KeyList> getKeyListId();

  /**
   * @param keyListId new value of {@link #getKeyListId()}.
   */
  void setKeyListId(IdRef<KeyList> keyListId);

}
