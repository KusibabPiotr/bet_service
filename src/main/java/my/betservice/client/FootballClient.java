package my.betservice.client;

import lombok.extern.slf4j.Slf4j;
import my.betservice.dto.league.LeagueInfoDto;
import my.betservice.dto.league.LeagueInfoPackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class FootballClient {

    private static final String HOST_NAME = "x-rapidapi-host";
    private static final String KEY_NAME = "x-rapidapi-key";
    @Autowired
    private RestTemplate restTemplate;
    @Value("${football.api.key}")
    private String apiKeyValue;
    @Value("${football.api.endpoint}")
    private String apiEndpointValue;
    @Value("${football.api.host}")
    private String apiHostValue;

    public LeagueInfoDto getLeagueInfo(final Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(HOST_NAME,apiHostValue);
        headers.set(KEY_NAME,apiKeyValue);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<LeagueInfoPackageDto> response = restTemplate.exchange(
                apiEndpointValue + "leagues?id=" + id,
                HttpMethod.GET,
                request,
                LeagueInfoPackageDto.class
        );
        log.info(response.getBody().getLeagueInfoDto()[0].toString());
        log.info(response.getBody().getLeagueInfoDto()[0].getSeasons().get(0).toString());
        return Optional.ofNullable(Objects.requireNonNull(response.getBody())
                .getLeagueInfoDto()[0]).orElseGet(LeagueInfoDto::new);
    }


}
