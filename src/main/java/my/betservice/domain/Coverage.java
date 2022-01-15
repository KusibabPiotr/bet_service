package my.betservice.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "COVERAGES")
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
    @JoinColumn(name = "COVERAGE_ID")
    private Fixture fixtures;
    private boolean standings;
    private boolean players;
    private boolean topScores;
    private boolean topAssists;
    private boolean topCards;
    private boolean injuries;
    private boolean predictions;
    private boolean odds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coverage coverage = (Coverage) o;

        return id.equals(coverage.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
