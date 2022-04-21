package my.betservice.registration.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {
    @Email(regexp = "^(.+)@(\\S+)$",message = "You have to provide right email format!")
    @NotNull
    private String email;
    @Length(min = 6, message = "Your password should contains at least 6 signs!")
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;
}
