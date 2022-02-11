package my.betservice.registration.dto;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class RegistrationRequestDto {

    @Email(message = "Provide right email format!")
    @NotBlank(message = "Email is mandatory!")
    private String email;
    @NotBlank(message = "Password is mandatory!")
    private String password;
    @NotBlank(message = "Repeat your password")
    private String repeatPassword;
}
