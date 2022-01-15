package my.betservice.domain.league;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "SEASONS")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate start;
    private LocalDate end;
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    private Coverage coverage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Season season = (Season) o;

        return id.equals(season.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
