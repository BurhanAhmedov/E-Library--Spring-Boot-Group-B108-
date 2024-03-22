package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.model.User;
import az.divacademy.springbootb108.repository.UserRepository;
import az.divacademy.springbootb108.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserRepository repository;
  private final PasswordEncoder encoder;

  @Override
  public User register(User user) {
    user.setPassword(encoder.encode(user.getPassword()));
   return repository.save(user);
  }
}
