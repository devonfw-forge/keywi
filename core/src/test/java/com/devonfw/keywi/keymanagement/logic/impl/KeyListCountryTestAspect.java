package com.devonfw.keywi.keymanagement.logic.impl;

import org.assertj.core.api.Assertions;

import com.devonfw.keywi.keymanagement.common.api.KeyList;
import com.devonfw.keywi.keymanagement.dataaccess.api.datatype.KeyItemProperty;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.module.basic.common.api.reference.IdRef;

/**
 * Test aspect for {@link KeyList} with the countries of the world.
 */
public class KeyListCountryTestAspect extends Assertions {

  /** {@link KeyList#getId() ID} of {@link KeyList} with the countries of the world. */
  public static final IdRef<KeyList> ID_COUNTRY = IdRef.of(1L);

  /** {@link KeyList#getKey() Key} of {@link KeyList} with the countries of the world. */
  public static final String KEY_COUNTRY = "country";

  /**
   * @param keyList the {@link KeyListEto} for {@link #KEY_COUNTRY} to verify.
   */
  public static void verifyCountry(KeyList keyList) {

    assertThat(keyList.getId()).isEqualTo(ID_COUNTRY.getId());
    assertThat(keyList.getKey()).isEqualTo(KEY_COUNTRY);
    assertThat(keyList.getName()).isEqualTo("Country");
    assertThat(keyList.getComment()).isEqualTo("Countries of the world");
    assertThat(keyList.getOrdering()).isEqualTo(KeyItemProperty.NAME);
    assertThat(keyList.isValueRequired()).isTrue();
    assertThat(keyList.getValuePattern().pattern()).isEqualTo("[A-Z]{3}");
    assertThat(keyList.isCacheable()).isTrue();
    assertThat(keyList.isDisabled()).isFalse();
  }

}
