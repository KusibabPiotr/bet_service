package my.betservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.betservice.domain.bet.BetCard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private BigDecimal moneyOnAccount;
    private List<BetCard> betCards = new ArrayList<>();
}
