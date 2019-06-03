package com.devonfw.keywi.keymanagement.common.api;

import com.devonfw.keywi.general.common.api.ApplicationEntity;

/**
 * Interface for item of
 */
public interface KeyObject extends ApplicationEntity {

  /** Property name for {@link #getKey()}. */
  String PROPERTY_KEY = "key";

  /** Column name for {@link #getKey()}. */
  String COLUMN_KEY = "business_key";

  /** Property name for {@link #getName()}. */
  String PROPERTY_NAME = "name";

  /** Column name for {@link #getName()}. */
  String COLUMN_NAME = "name";

  /** Property name for {@link #getComment()}. */
  String PROPERTY_COMMENT = "comment";

  /** Column name for {@link #getComment()}. */
  String COLUMN_COMMENT = "comment";

  /**
   * @return keyId
   */
  String getKey();

  /**
   * @param key setter for key attribute
   */
  void setKey(String key);

  /**
   * @return nameId
   */
  String getName();

  /**
   * @param name setter for name attribute
   */
  void setName(String name);

  /**
   * @return descriptionId
   */
  String getComment();

  /**
   * @param description setter for description attribute
   */
  void setComment(String description);

  /**
   * @return {@code true} if this item is disabled (deprecated) and may not be selected anymore. It can still be loaded
   *         and displayed but it should not be available anymore for selection and should be considered as invalid when
   *         saving data. Regular items are called active and will return {@code false} here.
   */
  boolean isDisabled();

  /**
   * @param disabled new value of {@link #isDisabled()}.
   */
  void setDisabled(boolean disabled);

}
