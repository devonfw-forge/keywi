package com.devonfw.keywi.general.common.api.exception;

import net.sf.mmm.util.exception.api.NlsRuntimeException;
import net.sf.mmm.util.nls.api.NlsMessage;

import com.devonfw.keywi.general.common.api.NlsBundleApplicationRoot;

/**
 * Abstract base class for business exceptions of this application.
 */
public abstract class ApplicationBusinessException extends NlsRuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   *
   * @param cause is the {@link #getCause() cause} of this exception. May be {@code null}.
   * @param message the {@link #getNlsMessage() message} describing the problem briefly.
   * @see #createBundle()
   */
  public ApplicationBusinessException(Throwable cause, NlsMessage message) {

    super(cause, message);
  }

  /**
   * @return the {@link NlsBundleApplicationRoot} to create the actual {@link NlsMessage}.
   */
  protected static NlsBundleApplicationRoot createBundle() {

    return createBundle(NlsBundleApplicationRoot.class);
  }

  @Override
  public boolean isForUser() {

    return true;
  }

}
