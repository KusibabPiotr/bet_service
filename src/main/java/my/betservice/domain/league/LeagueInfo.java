package my.betservice.domain.league;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueInfo that = (LeagueInfo) o;

        if (!Objects.equals(id, that.id)) return false;
        return leagueId.equals(that.leagueId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + leagueId.hashCode();
        return result;
    }
}
