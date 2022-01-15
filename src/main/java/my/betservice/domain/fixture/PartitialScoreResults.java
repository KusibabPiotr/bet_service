package my.betservice.domain.fixture;

import lombok.*;
import my.betservice.dto.fixture.GoalsResultDto;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "FIXTURES")
public class PartitialScoreResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult halftime;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult fulltime;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult extratime;
    @OneToOne(cascade = CascadeType.ALL)
    private GoalsResult penalty;
}
