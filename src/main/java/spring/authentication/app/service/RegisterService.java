package spring.authentication.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.authentication.app.jwt.JwtService;
import spring.authentication.app.model.Role;
import spring.authentication.app.model.User;
import spring.authentication.app.repository.UserRepository;
import spring.authentication.app.request.RegisterRequest;
import spring.authentication.app.response.RegisterResponse;

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
