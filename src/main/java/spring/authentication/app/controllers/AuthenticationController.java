package spring.authentication.app.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.authentication.app.requests.AuthenticationRequest;
import spring.authentication.app.responses.AuthenticationResponse;
import spring.authentication.app.services.AuthenticationService;

@RestController
@RequestMapping("/spring/auth/app")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AuthenticationController {

    private final AuthenticationService service; // injecting the class

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>authenticate(@Valid @RequestBody AuthenticationRequest request){
        try{
            return ResponseEntity.ok(service.authenticate(request));
        }
        catch (Exception exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

}
