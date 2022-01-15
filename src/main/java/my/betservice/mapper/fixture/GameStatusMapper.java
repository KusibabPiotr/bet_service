package my.betservice.mapper.fixture;

import my.betservice.domain.fixture.GameStatus;
import my.betservice.dto.fixture.GameStatusDto;

public class GameStatusMapper {

    public static GameStatus mapToGameStatus(final GameStatusDto dto) {
        return GameStatus.builder()
                .id(dto.getId())
                .fullStatus(dto.getFullStatus())
                .shortStatus(dto.getShortStatus())
                .elapsed(dto.getElapsed())
                .build();
    }

    public static GameStatusDto mapToGameStatusDto(final GameStatus gameStatus) {
        return GameStatusDto.builder()
                .id(gameStatus.getId())
                .fullStatus(gameStatus.getFullStatus())
                .shortStatus(gameStatus.getShortStatus())
                .elapsed(gameStatus.getElapsed())
                .build();
    }
}
