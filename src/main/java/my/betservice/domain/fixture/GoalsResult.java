package my.betservice.domain.fixture;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@Table(name = "GOALS_RESULTS")
public class GoalsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer home;
    private Integer away;
}
