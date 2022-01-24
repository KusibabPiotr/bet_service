package my.betservice.domain.bet;

import lombok.*;
import my.betservice.domain.user.AppUser;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @OneToMany(
            mappedBy = "betCard",
            targetEntity = BetInfo.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<BetInfo> betList = new ArrayList<>();
    private BigDecimal oddsValue;
    private BigDecimal betCost;
    private BigDecimal toWin;
    private LocalDateTime betConfirmedTime;
    private LocalDateTime lastMatchToPlay;
    private boolean finished;
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser appUser;
    private Boolean finalWin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BetCard betCard = (BetCard) o;

        return id != null ? id.equals(betCard.id) : betCard.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
