package my.betservice.domain.bet;

import lombok.*;
import my.betservice.domain.user.Customer;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@Table(name = "BET_CARTS")
public class BetCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(
            mappedBy = "betCart",
            targetEntity = BetInfo.class,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private List<BetInfo> betList = new ArrayList<>();
    private BigDecimal oddsValue;
    private BigDecimal betCost;
    private BigDecimal toWin;
    private LocalDateTime betConfirmedTime;
    private LocalDateTime lastMatchToPlay;
    private boolean finished;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private Boolean finalWin;
}
