package my.betservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonalDetailsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
}

