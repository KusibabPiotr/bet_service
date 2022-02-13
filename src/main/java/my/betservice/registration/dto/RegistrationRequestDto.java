package my.betservice.registration.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {

    private String email;
    private String password;
    private String repeatPassword;
}
