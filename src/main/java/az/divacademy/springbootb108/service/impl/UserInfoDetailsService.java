package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.model.User;
import az.divacademy.springbootb108.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoDetailsService implements UserDetailsService {
  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional<User> userByEmail = repository.findByEmail(username);
    return userByEmail.orElseThrow(()->new UsernameNotFoundException(username));
  }
}
