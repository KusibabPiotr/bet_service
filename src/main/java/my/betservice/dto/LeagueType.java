package my.betservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum LeagueType {
    LEAGUE("League"),
    CUP("Cup");

    private final String description;
}
