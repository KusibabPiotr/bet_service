package my.betservice.domain.fixture;

import lombok.*;

import javax.persistence.*;

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
    private Boolean winner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return dbId.equals(team.dbId);
    }

    @Override
    public int hashCode() {
        return dbId.hashCode();
    }
}
