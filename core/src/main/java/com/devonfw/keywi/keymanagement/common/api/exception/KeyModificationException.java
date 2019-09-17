package com.devonfw.keywi.keymanagement.common.api.exception;

import com.devonfw.keywi.general.common.api.exception.ApplicationBusinessException;
import com.devonfw.keywi.keymanagement.common.api.KeyObject;

/**
 * Thrown if the user tried to modify the business key of an existing entity.
 */
public class KeyModificationException extends ApplicationBusinessException {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   *
   * @param entity the {@link String} describing the entity that could not be modified. Should at least contain the
   *        original business key.
   * @param key the new business key the user tried to save.
   */
  public KeyModificationException(KeyObject entity, String key) {

    this(entity, key, null);
  }

  /**
   * The constructor.
   *
   * @param entity the {@link String} describing the entity that could not be modified. Should at least contain the
   *        original business key.
   * @param key the new business key the user tried to save.
   * @param cause is the {@link #getCause() cause} of this exception. May be {@code null}.
   */
  public KeyModificationException(KeyObject entity, String key, Throwable cause) {

    super(cause, createBundle().errorKeyImmutable(toString(entity), key));
  }

  private static String toString(KeyObject entity) {

    StringBuilder sb = new StringBuilder(entity.getClass().getSimpleName());
    sb.append("[id=");
    sb.append(entity.getId());
    sb.append(",key=");
    sb.append(entity.getKey());
    sb.append(']');
    return sb.toString();
  }

}
