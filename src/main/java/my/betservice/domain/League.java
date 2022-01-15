package my.betservice.domain;

import lombok.*;
import my.betservice.dto.LeagueType;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "LEAGUES")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int leagueId;
    private String name;
    private LeagueType type;
    private String logo;
}
