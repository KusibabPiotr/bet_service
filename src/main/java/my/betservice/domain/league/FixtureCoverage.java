package my.betservice.domain.league;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "FIXTURES_COVERAGE")
public class FixtureCoverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean events;
    private boolean lineUps;
    private boolean statisticsFixtures;
    private boolean statisticsPlayers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixtureCoverage fixtureCoverage = (FixtureCoverage) o;

        return id.equals(fixtureCoverage.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
