package my.betservice.domain.user;

import lombok.*;
import my.betservice.domain.bet.BetCart;
import my.betservice.registration.domain.AppUser;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONAL_DETAILS_ID")
    private PersonalDetails personalDetails;
    private BigDecimal moneyOnAccount;
    @OneToMany(
            targetEntity = BetCart.class,
            cascade = CascadeType.ALL,
            mappedBy = "customer")
    private List<BetCart> betCarts = new ArrayList<>();
    @OneToOne(mappedBy = "customer")
    private AppUser appUser;
}
