package com.devonfw.keywi.keymanagement.logic.impl;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.keywi.SpringBootApp;
import com.devonfw.keywi.general.common.base.test.TestUtil;
import com.devonfw.module.test.common.base.ComponentTest;

/**
 * Abstract base class for {@link ComponentTest} testing this {@link SpringBootApp}.
 */
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.MOCK)
public abstract class ApplicationComponentTest extends ComponentTest {

  @Override
  protected void doTearDown() {

    super.doTearDown();
    TestUtil.logout();
  }

}
