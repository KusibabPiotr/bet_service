package my.betservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.betservice.dto.bet.BetCardDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {
    private Long id;
    private BigDecimal moneyOnAccount;
    private PersonalDetailsDto personalDetails;
    private List<BetCardDto> betCards = new ArrayList<>();
}
