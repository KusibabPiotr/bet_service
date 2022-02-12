package my.betservice.domain.fixture;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "TEAMS")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbId;
    private Integer teamId;
    private String name;
    private String logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!Objects.equals(dbId, team.dbId)) return false;
        return teamId.equals(team.teamId);
    }

    @Override
    public int hashCode() {
        int result = dbId != null ? dbId.hashCode() : 0;
        result = 31 * result + teamId.hashCode();
        return result;
    }
}
