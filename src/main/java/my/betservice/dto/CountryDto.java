package my.betservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDto {
    private Long id;
    private String name;
    private String code;
    private String flag;
}
