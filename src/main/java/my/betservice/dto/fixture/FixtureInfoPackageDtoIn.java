package my.betservice.dto.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureInfoPackageDtoIn {
    @JsonProperty("response")
    private List<FixtureInfoDtoIn> fixtureInfoDtoIn = new ArrayList<>();
}
