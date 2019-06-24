package com.devonfw.keywi.general.common.impl.security;

import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.devonfw.module.security.common.base.accesscontrol.AccessControlGrantedAuthority;

/**
 * Implementation of {@link org.springframework.security.core.Authentication} for this application.
 *
 * @since 1.0.0
 */
public class ApplicationAuthentication extends UsernamePasswordAuthenticationToken {

  private static final long serialVersionUID = 1L;

  private final String login;

  private final Set<AccessControlGrantedAuthority> authorities;

  /**
   * The constructor.
   *
   * @param login the login of the authenticated user (also called username or {@link #getPrincipal() principal}).
   * @param authorities the {@link #getAuthoritiesSet() authorities set}.
   */
  public ApplicationAuthentication(String login, Set<AccessControlGrantedAuthority> authorities) {

    super(login, "**********", authorities);
    this.login = login;
    this.authorities = authorities;
  }

  @Override
  public String getPrincipal() {

    return this.login;
  }

  /**
   * @return the {@link Set} of {@link AccessControlGrantedAuthority access-control authorities}.
   * @see #getAuthorities()
   */
  public Set<AccessControlGrantedAuthority> getAuthoritiesSet() {

    return this.authorities;
  }

  /**
   * @return the {@link ApplicationAuthentication} of the user currently logged-in or {@code null} if not authenticated.
   */
  public static ApplicationAuthentication get() {

    SecurityContext context = SecurityContextHolder.getContext();
    if (context == null) {
      return null;
    }
    Authentication authentication = context.getAuthentication();
    if (authentication instanceof ApplicationAuthentication) {
      return (ApplicationAuthentication) authentication;
    }
    return null;
  }

}
