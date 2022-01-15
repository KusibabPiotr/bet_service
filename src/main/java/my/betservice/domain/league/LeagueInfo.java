package my.betservice.domain.league;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    @JoinColumn(name = "LEAGUE_ID")
    private League league;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Country country;
    @Builder.Default
    @OneToMany(
            targetEntity = Season.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Season> seasons = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueInfo that = (LeagueInfo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
