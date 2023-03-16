package spring.authentication.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.authentication.app.request.AuthenticationRequest;
import spring.authentication.app.response.AuthenticationResponse;
import spring.authentication.app.response.RegisterResponse;
import spring.authentication.app.service.AuthenticationService;
import spring.authentication.app.request.RegisterRequest;
import spring.authentication.app.service.RegisterService;

@RestController
@RequestMapping("/spring/auth/app")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service; // injecting the class
    private final RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(registerService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
