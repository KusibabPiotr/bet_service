package my.betservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SeasonDto {
    private int year;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate start;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate end;
    private boolean current;
    private CoverageDto coverage;
}
