package my.betservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum LeagueType {
    LEAGUE("League"),
    CUP("Cup");

    private String description;
}
