package com.devonfw.keywi.general.common.impl.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.devonfw.keywi.general.common.api.security.ApplicationAccessControlConfig;
import com.devonfw.module.security.common.api.accesscontrol.AccessControl;
import com.devonfw.module.security.common.base.accesscontrol.AccessControlGrantedAuthority;

/**
 * Implementation of {@link AuthenticationProvider} for this app.
 */
@Named
public class ApplicationAuthenticationProvider implements AuthenticationProvider {

  private static final Logger LOG = LoggerFactory.getLogger(ApplicationAuthenticationProvider.class);

  @Inject
  private ApplicationAccessControlConfig accessControlConfig;

  @Override
  public ApplicationAuthentication authenticate(Authentication authentication) throws AuthenticationException {

    if (authentication instanceof ApplicationAuthentication) {
      return (ApplicationAuthentication) authentication;
    }
    String login = authentication.getPrincipal().toString();
    String password = (String) authentication.getCredentials();
    return authenticate(login, password);
  }

  private ApplicationAuthentication authenticate(String login, String password) {

    String username = trimRequired(login, "login");
    String pwd = trimRequired(password, "password");
    // TODO: just a dummy login for the moment...
    if (!pwd.equals(username)) {
      throw new BadCredentialsException("Wrong password!");
    }
    Set<AccessControlGrantedAuthority> authorities = new HashSet<>();
    Collection<String> accessControlIds = getRoles(username);
    Set<AccessControl> accessControlSet = new HashSet<>();
    for (String id : accessControlIds) {
      boolean success = this.accessControlConfig.collectAccessControls(id, accessControlSet);
      if (!success) {
        LOG.warn("Undefined access control {}.", id);
      }
    }
    for (AccessControl accessControl : accessControlSet) {
      authorities.add(new AccessControlGrantedAuthority(accessControl));
    }
    return new ApplicationAuthentication(username, authorities);
  }

  private String capitalize(String username) {

    return Character.toUpperCase(username.charAt(0)) + username.substring(1);
  }

  private Collection<String> getRoles(String username) {

    Collection<String> roles = new ArrayList<>();
    // TODO for a reasonable application you need to retrieve the roles of the user from a central IAM system
    String groupId = ApplicationAccessControlConfig.PREFIX + capitalize(username);
    roles.add(groupId);
    return roles;
  }

  private String trimRequired(String string, String property) {

    String value = string;
    if (value == null) {
      value = "";
    } else {
      value = value.trim();
    }
    if (value.isEmpty()) {
      throw new BadCredentialsException(property + " has to be filled!");
    }
    return value;
  }

  @Override
  public boolean supports(Class<?> authentication) {

    return ApplicationAuthentication.class.isAssignableFrom(authentication)
        || authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

}
