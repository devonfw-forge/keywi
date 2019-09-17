package com.devonfw.keywi.general.common.api.security;

import javax.inject.Named;

import com.devonfw.module.security.common.api.accesscontrol.AccessControlGroup;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlConfig;

/**
 * Example of {@link AccessControlConfig} that used for testing.
 */
@Named
public class ApplicationAccessControlConfig extends AccessControlConfig {

  /** The ID of this app. */
  public static final String APP_ID = "keywi";

  /** The prefix used by permissions and groups of this app. */
  public static final String PREFIX = APP_ID + ".";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyItem */
  public static final String PERMISSION_FIND_KEY_ITEM = PREFIX + "FindKeyItem";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem#saveKeyItem(com.devonfw.keywi.keymanagement.logic.api.to.KeyItemEto)
   */
  public static final String PERMISSION_SAVE_KEY_ITEM = PREFIX + "SaveKeyItem";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem#deleteKeyItem(com.devonfw.module.basic.common.api.reference.IdRef)
   */
  public static final String PERMISSION_DELETE_KEY_ITEM = PREFIX + "DeleteKeyItem";

  /** @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyList */
  public static final String PERMISSION_FIND_KEY_LIST = PREFIX + "FindKeyList";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList#saveKeyList(com.devonfw.keywi.keymanagement.logic.api.to.KeyListEto)
   */
  public static final String PERMISSION_SAVE_KEY_LIST = PREFIX + "SaveKeyList";

  /**
   * @see com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList#deleteKeyList(com.devonfw.module.basic.common.api.reference.IdRef)
   */
  public static final String PERMISSION_DELETE_KEY_LIST = PREFIX + "DeleteKeyList";

  /** Group for overall read-access in the app. */
  public static final String GROUP_READ_MASTER_DATA = PREFIX + "ReadMasterData";

  /** Group for manager of key lists entries. */
  public static final String GROUP_MANAGER = PREFIX + "Manager";

  /** Group for administration permission in the app. */
  public static final String GROUP_ADMIN = PREFIX + "Admin";

  /**
   * The constructor.
   */
  public ApplicationAccessControlConfig() {

    super();
    AccessControlGroup readMasterData = group(GROUP_READ_MASTER_DATA, PERMISSION_FIND_KEY_LIST,
        PERMISSION_FIND_KEY_ITEM);
    AccessControlGroup manager = group(GROUP_MANAGER, readMasterData, PERMISSION_SAVE_KEY_ITEM);
    group(GROUP_ADMIN, manager, PERMISSION_SAVE_KEY_LIST, PERMISSION_DELETE_KEY_ITEM, PERMISSION_DELETE_KEY_LIST);
  }

}