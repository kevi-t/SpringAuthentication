package spring.authentication.app.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty(message = "This field 'firstName' should not be empty")
    private String firstname;
    @NotEmpty(message = "This field 'lastName' should not be empty")
    private String lastname;
    @NotEmpty(message = "This field 'email' should not be empty")
    private String email;
    @NotEmpty(message = "This field 'password' should not be empty")
    private String password;
}