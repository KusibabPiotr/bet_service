package my.betservice.domain.league;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@Table(name = "LEAGUES_INFO")
public class LeagueInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer leagueId;
    private String leagueName;
    private String leagueLogo;
    private String countryName;
    private String countryFlag;
}
