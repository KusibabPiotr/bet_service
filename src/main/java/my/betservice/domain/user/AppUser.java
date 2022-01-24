package my.betservice.domain.user;

import lombok.*;
import my.betservice.domain.bet.BetCard;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "APP_USERS")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "appUser",
                cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;
    private BigDecimal moneyOnAccount;
    @OneToMany(
            targetEntity = BetCard.class,
            cascade = CascadeType.ALL,
            mappedBy = "appUser")
    private List<BetCard> betCards = new ArrayList<>();
}
