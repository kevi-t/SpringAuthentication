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
import spring.authentication.app.requests.RegisterRequest;
import spring.authentication.app.responses.RegisterResponse;
import spring.authentication.app.services.RegisterService;

@RestController
@RequestMapping("/spring/auth/app")
@RequiredArgsConstructor
@Validated
@Slf4j
public class RegisterController {

    private final RegisterService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){

        try{
            return ResponseEntity.ok(service.register(request));
        }
        catch (Exception exception){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
