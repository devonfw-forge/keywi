package com.devonfw.keywi.general.common.api.security;

import javax.inject.Named;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlGroup;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

  public static final String APP_ID = "keywi";

  private static final String PREFIX = APP_ID + ".";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyItem */
  public static final String PERMISSION_FIND_KEY_ITEM = PREFIX + "FindKeyItem";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem#saveKeyItem(com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto)
   */
  public static final String PERMISSION_SAVE_KEY_ITEM = PREFIX + "SaveKeyItem";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem#deleteKeyItem(long) */
  public static final String PERMISSION_DELETE_KEY_ITEM = PREFIX + "DeleteKeyItem";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyList */
  public static final String PERMISSION_FIND_KEY_LIST = PREFIX + "FindKeyList";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList#saveKeyList(com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto)
   */
  public static final String PERMISSION_SAVE_KEY_LIST = PREFIX + "SaveKeyList";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList#deleteKeyList(long) */
  public static final String PERMISSION_DELETE_KEY_LIST = PREFIX + "DeleteKeyList";

  public static final String GROUP_READ_MASTER_DATA = PREFIX + "ReadMasterData";

  public static final String GROUP_ADMIN = PREFIX + "Admin";

  /**
   * The constructor.
   */
  public ApplicationAccessControlConfig() {

    super();
    AccessControlGroup readMasterData =
        group(GROUP_READ_MASTER_DATA, PERMISSION_FIND_KEY_LIST, PERMISSION_FIND_KEY_ITEM);
    group(GROUP_ADMIN, readMasterData, PERMISSION_SAVE_KEY_ITEM, PERMISSION_SAVE_KEY_LIST, PERMISSION_DELETE_KEY_ITEM,
        PERMISSION_DELETE_KEY_LIST);
  }

}