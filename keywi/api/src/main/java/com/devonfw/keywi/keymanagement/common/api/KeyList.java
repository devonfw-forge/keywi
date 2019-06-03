package com.devonfw.keywi.keymanagement.common.api;

import java.util.regex.Pattern;

import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;

/**
 * Interface for a list of {@link KeyItem}s.
 */
public interface KeyList extends KeyObject {

  /**
   * @return {@code true} if the {@link KeyItem#getKeyListId() containing} {@link KeyItem}s shall be cached by clients,
   *         {@code false} otherwise. A {@link KeyList} with up to {@code 100} {@link KeyItem}s should always be cached
   *         while lists with more than {@code 10.000} {@link KeyItem}s should never be cached.
   */
  boolean isCacheable();

  /**
   * @param cacheable new value of {@link #isCacheable()}. Changing will have complex implications and should be
   *        considered with care.
   */
  void setCacheable(boolean cacheable);

  /**
   * @return the {@link KeyItemProperty property} to sort the {@link KeyItem}s by default. Defaults to
   *         {@link KeyItemProperty#NAME} and may not be {@code null}.
   */
  KeyItemProperty getOrdering();

  /**
   * @param ordering new value of {@link #getOrdering()}. May not be {@code null}.
   */
  void setOrdering(KeyItemProperty ordering);

  /**
   * @return {@code true} if the {@link KeyItem#getValue() value} of the {@link KeyItem#getKeyListId() owned}
   *         {@link KeyItem}s is required and may not be {@code null} or {@link String#isEmpty() empty}, {@code false}
   *         otherwise (if it is optional and may be {@code null}).
   * @see #getValuePattern()
   */
  boolean isValueRequired();

  /**
   * @param valueRequired new value of {@link #isValueRequired()}. Please note that changing this value to {@code true}
   *        can make existing {@link KeyItem}s in database invalid.
   */
  void setValueRequired(boolean valueRequired);

  /**
   * @return the optional regular expression {@link Pattern} the {@link KeyItem#getValue() values} of
   *         {@link KeyItem#getKeyListId() owned} {@link KeyItem}s have to match if they are not empty. May be
   *         {@code null} if any value is considered valid.
   * @see #isValueRequired()
   */
  Pattern getValuePattern();

  /**
   * @param valuePattern new value of {@link #getValuePattern()}. Please note that changing this value can make existing
   *        {@link KeyItem}s in database invalid.
   */
  void setValuePattern(Pattern valuePattern);

  /**
   * @return the identifier of the additional permission required to manage this {@link KeyList} and its
   *         {@link KeyItem}s. Then to save or even delete a {@link KeyItem} {@link KeyItem#getKeyListId() owned} by
   *         this {@link KeyList} will additionally require that the user has the specified permission. Please note that
   *         reading {@link KeyItem}s is not affected by this permission. May be {@code null} to only require standard
   *         permissions.
   */
  String getPermission();

  /**
   * @param permission new value of {@link #getPermission()}.
   */
  void setPermission(String permission);

}
