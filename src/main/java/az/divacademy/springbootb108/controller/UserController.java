package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.dto.JwtAuthenticationResponse;
import az.divacademy.springbootb108.request.SignUpRequest;
import az.divacademy.springbootb108.service.AuthenticationService;
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

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody SignUpRequest request) {
    return ResponseEntity.ok(authenticationService.signup(request));
  }

}
