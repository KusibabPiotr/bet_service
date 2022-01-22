package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.bet.BetInfo;
import my.betservice.dto.bet.BetInfoDto;
import my.betservice.mapper.bet.BetInfoMapper;
import my.betservice.service.BetService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BetFacade {
    private final BetService betService;

    public BetInfoDto addBetToBetList(final BetInfoDto betInfoDto) {
        BetInfo betInfo = BetInfoMapper.mapToBetInfo(betInfoDto);
        return BetInfoMapper.mapToBetInfoDto(betService.addBetToBetList(betInfo));
    }

    public void deleteBetFromBetList(final Long id) {
        betService.deleteBetFromBetList(id);
    }

}
