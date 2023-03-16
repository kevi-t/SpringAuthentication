package spring.authentication.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import spring.authentication.app.jwt.JwtService;
import spring.authentication.app.model.User;
import spring.authentication.app.repository.UserRepository;
import spring.authentication.app.request.AuthenticationRequest;
import spring.authentication.app.response.AuthenticationResponse;

@Service
@Slf4j
@RequiredArgsConstructor        //Creates a constructor for the class AuthenticationService
public class AuthenticationService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = repository.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        if (authentication==null){
            return AuthenticationResponse.builder().message("Username or password is incorrect").build();
        }
        else if (user==null){
            return AuthenticationResponse.builder().message("User doesn't exist please register").build();
        }
        else{
            return AuthenticationResponse.builder().message("Login Successful").token(jwtToken).build();
        }
    }

}