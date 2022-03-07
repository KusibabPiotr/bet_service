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
@Table(name = "TEAMS")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dbId;
    private Integer teamId;
    private String name;
    private String logo;
}
