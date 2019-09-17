package com.devonfw.keywi.general.common.api;

import javax.inject.Named;

import net.sf.mmm.util.nls.api.NlsBundle;
import net.sf.mmm.util.nls.api.NlsBundleMessage;
import net.sf.mmm.util.nls.api.NlsMessage;

/**
 * This is the {@link NlsBundle} for this application.
 */
public interface NlsBundleApplicationRoot extends NlsBundle {

  /**
   * @return error message if the user tried to modify the business key.
   * @see com.devonfw.keywi.keymanagement.common.api.KeyObject#getKey()
   *
   * @param entity the {@link String} describing the entity that could not be modified.
   * @param key the new business key the user tried to change to.
   */
  @NlsBundleMessage("You can not change the business key of entity {entity} to {key}! If you really need to change the business key, create a new entity and delete the old one.")
  NlsMessage errorKeyImmutable(@Named("entity") String entity, @Named("key") String key);

}
