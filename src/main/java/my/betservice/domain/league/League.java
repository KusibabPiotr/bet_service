package my.betservice.domain.league;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "LEAGUES")
@Data
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long dbId;
    private int leagueId;
    private String name;
    private String type;
    private String logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        League league = (League) o;

        return dbId.equals(league.dbId);
    }

    @Override
    public int hashCode() {
        return dbId.hashCode();
    }
}
