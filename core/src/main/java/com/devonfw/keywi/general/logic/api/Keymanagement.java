package com.devonfw.keywi.general.logic.api;

import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyItem;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcFindKeyList;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyItem;
import com.devonfw.keywi.keymanagement.logic.api.usecase.UcManageKeyList;

/**
 * Interface for Keymanagement component.
 */
public interface Keymanagement extends UcFindKeyItem, UcManageKeyItem, UcFindKeyList, UcManageKeyList {

}
