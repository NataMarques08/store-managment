package com.nata.store_management_customers_and_products.service;

import com.nata.store_management_customers_and_products.dto.UserDtos.AuthenticationRequest;
import com.nata.store_management_customers_and_products.dto.UserDtos.AuthenticationResponse;
import com.nata.store_management_customers_and_products.dto.UserDtos.RegisterRequest;
import com.nata.store_management_customers_and_products.model.User;
import com.nata.store_management_customers_and_products.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        var user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String jwt = jwtService.generateToken((UserDetails) user);
        return new AuthenticationResponse(jwt);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new User(
                request.username(),
                passwordEncoder.encode(request.password()),
                request.role() // ou role dinâmica se quiser
        );

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

}
