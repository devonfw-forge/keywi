package com.devonfw.keywi.keymanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.devonfw.keywi.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.keywi.keymanagement.common.api.KeyObject;

/**
 * {@link ApplicationPersistenceEntity} for {@link KeyObject}.
 *
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class KeyObjectEntity extends ApplicationPersistenceEntity implements KeyObject {

  private static final long serialVersionUID = 1L;

  private String key;

  private String name;

  private String comment;

  private boolean disabled;

  @Column(name = COLUMN_KEY)
  @Override
  public String getKey() {

    return this.key;
  }

  @Override
  public void setKey(String key) {

    this.key = key;
  }

  @Column(name = "name")
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

}
