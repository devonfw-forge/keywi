package com.devonfw.keywi.keymanagement.logic.api.to;

import java.util.Objects;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * {@link com.devonfw.module.basic.common.api.to.AbstractEto ETO} for {@link KeyItem}.
 */
public class KeyItemEto extends KeyObjectEto implements KeyItem {

  private static final long serialVersionUID = 1L;

  private String value;

  private IdRef<KeyList> keyListId;

  @Override
  public String getValue() {

    return this.value;
  }

  @Override
  public void setValue(String value) {

    this.value = value;
  }

  @Override
  public IdRef<KeyList> getKeyListId() {

    return this.keyListId;
  }

  @Override
  public void setKeyListId(IdRef<KeyList> keyListId) {

    this.keyListId = keyListId;
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), this.keyListId, this.value);
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
    KeyItemEto other = (KeyItemEto) obj;
    if (!Objects.equals(this.keyListId, other.keyListId)) {
      return false;
    } else if (!Objects.equals(this.value, other.value)) {
      return false;
    }
    return true;
  }

}
