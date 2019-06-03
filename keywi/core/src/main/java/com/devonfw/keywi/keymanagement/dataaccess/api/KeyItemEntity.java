package com.devonfw.keywi.keymanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.keywi.keymanagement.common.api.KeyItem;
import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.module.basic.common.api.reference.IdRef;
import com.devonfw.module.jpa.dataaccess.api.JpaHelper;

/**
 * {@link MappedSuperclass} as base class for {@link KeyListEntity} and {@link KeyItemEntity}.
 */
@Entity
@Table(name = "KeyItem")
public class KeyItemEntity extends KeyObjectEntity implements KeyItem {

  private static final long serialVersionUID = 1L;

  private String value;

  private KeyListEntity keyList;

  @Override
  public String getValue() {

    return this.value;
  }

  @Override
  public void setValue(String value) {

    this.value = value;
  }

  /**
   * @return the {@link KeyListEntity} owning this item.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "keyList")
  public KeyListEntity getKeyList() {

    return this.keyList;
  }

  /**
   * @param keyList new value of {@link #getKeyList()}.
   */
  public void setKeyList(KeyListEntity keyList) {

    this.keyList = keyList;
  }

  @Override
  @Transient
  public IdRef<KeyList> getKeyListId() {

    return IdRef.of(this.keyList);
  }

  @Override
  public void setKeyListId(IdRef<KeyList> keyListId) {

    this.keyList = JpaHelper.asEntity(keyListId, KeyListEntity.class);
  }

}
