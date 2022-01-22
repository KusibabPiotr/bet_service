package my.betservice.domain.bet;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "BET_CARDS")
public class BetCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany(
            targetEntity = BetInfo.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BetInfo> betList;
    private BigDecimal oddsValue;
    private BigDecimal betCost;
    private BigDecimal toWin;
    private LocalDateTime betConfirmedTime;
    private LocalDateTime lastMatchToPlay;
    private boolean finished;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BetCard betCard = (BetCard) o;

        if (id != null ? !id.equals(betCard.id) : betCard.id != null) return false;
        return userId.equals(betCard.userId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + userId.hashCode();
        return result;
    }
}
