package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.JwtAuthenticationResponse;
import az.divacademy.springbootb108.request.SignUpRequest;
import az.divacademy.springbootb108.request.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
