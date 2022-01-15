package my.betservice.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "FIXTURES")
public class Fixture {
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

        Fixture fixture = (Fixture) o;

        return id.equals(fixture.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
