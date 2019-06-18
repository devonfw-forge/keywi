package com.devonfw.keywi.general.common.impl.security;

import java.security.Principal;

/**
 * The user
 *
 * @since 1.0.0
 */
public class ApplicationUser implements Principal {

  private final String login;

  /**
   * The constructor.
   * 
   * @param login
   */
  public ApplicationUser(String login) {

    super();
    this.login = login;
  }

  @Override
  public String getName() {

    return this.login;
  }

  @Override
  public String toString() {

    return this.login;
  }

}
