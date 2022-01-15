package my.betservice.domain.fixture;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "HOME_AWAY")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Team home;
    @OneToOne(cascade = CascadeType.ALL)
    private Team away;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teams teams = (Teams) o;

        return id.equals(teams.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
