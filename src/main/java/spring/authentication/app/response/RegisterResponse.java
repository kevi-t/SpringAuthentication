package spring.authentication.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private int status;
    private String message;
    //TODO: implement how to display data to the client
    private String data;
    private  String token;
}
