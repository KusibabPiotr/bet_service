package my.betservice.service;

import lombok.RequiredArgsConstructor;
import my.betservice.LeagueInfoRepository;
import my.betservice.domain.league.LeagueInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LeagueService {
    private final LeagueInfoRepository leagueInfoRepository;

    public Optional<LeagueInfo> getLeagueInfo(final Long id) {
        return leagueInfoRepository.findById(id);
    }

    public List<LeagueInfo> getAvailableLeaguesInfo() {
        return leagueInfoRepository.findAll();
    }

    public LeagueInfo saveNewLeagueInfo(final LeagueInfo leagueInfo) {
        return leagueInfoRepository.save(leagueInfo);
    }
}
