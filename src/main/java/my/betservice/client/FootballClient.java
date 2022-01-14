package my.betservice.client;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.LeagueInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FootballClient {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${football.api.key}")
    private String apiKey;
    @Value("${football.api.endpoint}")
    private String apiEndpoint;
    @Value("${football.api.host}")
    private String apiHost;

//    public LeagueInfoDto getLeagueInfo() {
//
//        restTemplate.getForObject(
//                apiEndpoint,
//
//        )
//    }
}
