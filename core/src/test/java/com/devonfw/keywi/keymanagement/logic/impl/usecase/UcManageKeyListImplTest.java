package com.devonfw.keywi.keymanagement.logic.impl.usecase;

import javax.inject.Inject;

import org.junit.Test;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.keywi.general.common.base.test.TestUtil;
import com.devonfw.keywi.general.logic.api.Keymanagement;
import com.devonfw.keywi.keymanagement.KeyListCountryTestAspect;
import com.devonfw.keywi.keymanagement.common.api.exception.KeyModificationException;
import com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto;
import com.devonfw.keywi.keymanagement.logic.impl.ApplicationComponentTest;

/**
 * Test of {@link UcManageKeyListImpl}.
 */
public class UcManageKeyListImplTest extends ApplicationComponentTest {

  @Inject
  private Keymanagement keymanagement;

  /**
   * Test that {@link UcManageKeyListImpl#saveKeyList(KeyListEto)} fails if key was modified.
   */
  @Test
  public void testSaveFailsWhenKeyChanged() {

    TestUtil.login("admin", ApplicationAccessControlConfig.PERMISSION_FIND_KEY_LIST,
        ApplicationAccessControlConfig.PERMISSION_SAVE_KEY_LIST);
    KeyListEto keyList = this.keymanagement.findKeyListByKey(KeyListCountryTestAspect.KEY_COUNTRY);
    KeyListCountryTestAspect.verifyCountry(keyList);
    keyList.setKey("modifiedKey");
    try {
      this.keymanagement.saveKeyList(keyList);
      failBecauseExceptionWasNotThrown(KeyModificationException.class);
    } catch (KeyModificationException e) {
      assertThat(e.getMessage()).isEqualTo(
          "You can not change the business key of entity KeyListEntity[id=1,key=country] to modifiedKey! If you really need to change the business key, create a new entity and delete the old one.");
    }
  }

}
