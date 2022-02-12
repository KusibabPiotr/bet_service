package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.exception.LeagueNotFoundException;
import my.betservice.repository.LeagueInfoRepository;
import my.betservice.domain.league.LeagueInfo;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LeagueService {
    private final LeagueInfoRepository leagueInfoRepository;

    public LeagueInfo getLeagueInfoById(final Long id) {
        return leagueInfoRepository.findById(id)
                .orElseThrow(LeagueNotFoundException::new);
    }

    public List<LeagueInfo> getAvailableLeaguesInfo() {
        return leagueInfoRepository.findAll();
    }

    public LeagueInfo saveNewLeagueInfo(final LeagueInfo leagueInfo) {
        return leagueInfoRepository.save(leagueInfo);
    }
}
