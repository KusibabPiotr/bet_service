package my.betservice.dto.odd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import my.betservice.dto.fixture.FixtureDtoIn;
import my.betservice.dto.league.LeagueDtoIn;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddInfoDtoIn {
    private LeagueDtoIn league;
    private FixtureDtoIn fixture;
    private BookmakerDtoIn[] bookmakers = new BookmakerDtoIn[1];
}
