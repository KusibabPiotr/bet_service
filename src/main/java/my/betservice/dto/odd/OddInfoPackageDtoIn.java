package my.betservice.dto.odd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OddInfoPackageDtoIn {
    @JsonProperty("response")
    private OddInfoDtoIn[] oddInfoDtoIns = new OddInfoDtoIn[1];
}
