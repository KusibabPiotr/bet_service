package my.betservice.domain.bet;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "BETS")
public class BetInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Integer fixtureId;
    private String value;
    private String odd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BET_CARD_ID")
    private BetCard betCard;
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BetInfo betInfo = (BetInfo) o;

        return id != null ? id.equals(betInfo.id) : betInfo.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
