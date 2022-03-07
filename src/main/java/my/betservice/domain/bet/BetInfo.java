package my.betservice.domain.bet;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
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
    private BetCart betCart;
}
