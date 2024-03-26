package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.dto.JwtAuthenticationResponse;
import az.divacademy.springbootb108.model.Role;
import az.divacademy.springbootb108.model.User;
import az.divacademy.springbootb108.repository.UserRepository;
import az.divacademy.springbootb108.request.SignUpRequest;
import az.divacademy.springbootb108.request.SigninRequest;
import az.divacademy.springbootb108.service.AuthenticationService;
import az.divacademy.springbootb108.service.JwtService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService    jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().name(request.getFirstName()).surname(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Collections.singleton(Role.User)).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));


        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
