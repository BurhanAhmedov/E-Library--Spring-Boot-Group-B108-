package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.model.User;
import az.divacademy.springbootb108.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user){
    return ResponseEntity.ok(userService.register(user));
  }

}
