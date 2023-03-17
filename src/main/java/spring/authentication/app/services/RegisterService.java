package spring.authentication.app.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.authentication.app.jwt.JwtService;
import spring.authentication.app.models.Role;
import spring.authentication.app.models.User;
import spring.authentication.app.repositories.UserRepository;
import spring.authentication.app.requests.RegisterRequest;
import spring.authentication.app.responses.RegisterResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public RegisterResponse register(RegisterRequest request) {

        String email=request.getEmail();
        if(repository.findByEmail(email)==null){
            var user = User.builder().firstName(request.getFirstname()).secondName(request.getLastname()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return RegisterResponse.builder().token(jwtToken).message("User Registered Successfully").status(0).build();
        }
        else{
            return  RegisterResponse.builder().message("User Already Registered, Please Login").status(0).build();
        }
    }
}
