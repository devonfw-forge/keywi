package com.devonfw.keywi.keymanagement.logic.api.to;

import java.util.Objects;
import java.util.regex.Pattern;

import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;

/**
 * {@link com.devonfw.module.basic.common.api.to.AbstractEto ETO} for {@link KeyList}.
 */
public class KeyListEto extends KeyObjectEto implements KeyList {

  private static final long serialVersionUID = 1L;

  private KeyItemProperty ordering;

  private boolean valueRequired;

  private Pattern valuePattern;

  private String permission;

  private boolean cacheable;

  /**
   * The constructor.
   */
  public KeyListEto() {

    super();
    this.ordering = KeyItemProperty.NAME;
  }

  @Override
  public KeyItemProperty getOrdering() {

    return this.ordering;
  }

  @Override
  public void setOrdering(KeyItemProperty ordering) {

    Objects.requireNonNull(ordering, "ordering");
    this.ordering = ordering;
  }

  @Override
  public boolean isValueRequired() {

    return this.valueRequired;
  }

  @Override
  public void setValueRequired(boolean valueRequired) {

    this.valueRequired = valueRequired;
  }

  @Override
  public Pattern getValuePattern() {

    return this.valuePattern;
  }

  @Override
  public void setValuePattern(Pattern valuePattern) {

    this.valuePattern = valuePattern;
  }

  @Override
  public String getPermission() {

    return this.permission;
  }

  @Override
  public void setPermission(String permission) {

    this.permission = permission;
  }

  @Override
  public boolean isCacheable() {

    return this.cacheable;
  }

  @Override
  public void setCacheable(boolean cacheable) {

    this.cacheable = cacheable;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), this.valuePattern, this.valueRequired, this.permission, this.cacheable);
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    KeyListEto other = (KeyListEto) obj;
    if (this.valueRequired != other.valueRequired) {
      return false;
    } else if (this.cacheable != other.cacheable) {
      return false;
    } else if (!Objects.equals(this.valuePattern, other.valuePattern)) {
      return false;
    } else if (!Objects.equals(this.permission, other.permission)) {
      return false;
    }
    return true;
  }
}
