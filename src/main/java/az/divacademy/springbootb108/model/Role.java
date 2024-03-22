package az.divacademy.springbootb108.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  Admin,User
  ;



  @Override
  public String getAuthority() {
    return this.name();
  }
}
