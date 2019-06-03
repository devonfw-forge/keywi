package com.devonfw.keywi.keymanagement.dataaccess.api.datatype;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.common.api.KeyObject;

/**
 * Enum with the properties of a {@link KeyItem}.
 * 
 * @see KeyList#getOrdering()
 *
 * @since 1.0.0
 */
public enum KeyItemProperty {

  /** {@link KeyItemProperty} for {@link KeyObject#getName()}. */
  NAME(KeyObject.PROPERTY_NAME, KeyObject.COLUMN_NAME),

  /** {@link KeyItemProperty} for {@link KeyObject#getKey()}. */
  KEY(KeyObject.PROPERTY_KEY, KeyObject.COLUMN_KEY),

  /** {@link KeyItemProperty} for {@link KeyObject#getComment()}. */
  COMMENT(KeyObject.PROPERTY_COMMENT, KeyObject.COLUMN_COMMENT),

  /** {@link KeyItemProperty} for {@link KeyItem#getName()}. */
  VALUE(KeyItem.PROPERTY_VALUE, KeyItem.COLUMN_VALUE);

  private final String columnName;

  private final String propertyName;

  private KeyItemProperty(String fieldName, String columnName) {

    this.propertyName = fieldName;
    this.columnName = columnName;
  }

  /**
   * @return the Java property name (e.g. "key" for "getKey()").
   */
  public String getPropertyName() {

    return this.propertyName;
  }

  /**
   * @return the {@link javax.persistence.Column#name() column name} in the database.
   */
  public String getColumnName() {

    return this.columnName;
  }

}
