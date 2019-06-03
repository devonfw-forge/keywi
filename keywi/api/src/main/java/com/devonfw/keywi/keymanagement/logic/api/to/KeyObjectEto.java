package com.devonfw.keywi.keymanagement.logic.api.to;

import java.util.Objects;

import com.devonfw.keywi.keymanagement.common.api.KeyObject;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * {@link AbstractEto ETO} for {@link KeyObject}.
 */
public abstract class KeyObjectEto extends AbstractEto implements KeyObject {

  private static final long serialVersionUID = 1L;

  private String key;

  private String name;

  private String comment;

  private boolean disabled;

  @Override
  public String getKey() {

    return this.key;
  }

  @Override
  public void setKey(String key) {

    this.key = key;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getComment() {

    return this.comment;
  }

  @Override
  public void setComment(String comment) {

    this.comment = comment;
  }

  @Override
  public boolean isDisabled() {

    return this.disabled;
  }

  @Override
  public void setDisabled(boolean disabled) {

    this.disabled = disabled;
  }

  @Override
  public int hashCode() {

    return Objects.hash(this.key, this.name, this.comment, this.disabled);
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
    KeyObjectEto other = (KeyObjectEto) obj;
    if (this.disabled != other.disabled) {
      return false;
    } else if (!Objects.equals(this.key, other.key)) {
      return false;
    } else if (!Objects.equals(this.name, other.name)) {
      return false;
    } else if (!Objects.equals(this.comment, other.comment)) {
      return false;
    }
    return true;
  }

}
