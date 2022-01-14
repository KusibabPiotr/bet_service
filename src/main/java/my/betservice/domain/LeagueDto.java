package my.betservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LeagueDto {
    private int id;
    private String name;
    private LeagueType type;
    private String logo;
}
