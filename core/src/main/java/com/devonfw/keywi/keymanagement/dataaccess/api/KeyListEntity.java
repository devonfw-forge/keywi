package com.devonfw.keywi.keymanagement.dataaccess.api;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;

/**
 * {@link com.devonfw.keywi.general.dataaccess.api.ApplicationPersistenceEntity} for {@link KeyList}.
 *
 * @since 1.0.0
 */
@Entity
@Table(name = "KeyList")
public class KeyListEntity extends KeyObjectEntity implements KeyList {

  private static final long serialVersionUID = 1L;

  private KeyItemProperty ordering;

  private boolean valueRequired;

  private Pattern valuePattern;

  private String permission;

  private boolean cacheable;

  /**
   * The constructor.
   */
  public KeyListEntity() {

    super();
    this.ordering = KeyItemProperty.NAME;
  }

  @Column(nullable = false)
  @Override
  public KeyItemProperty getOrdering() {

    return this.ordering;
  }

  @Override
  public void setOrdering(KeyItemProperty ordering) {

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

}
