package my.betservice.mapper.user;

import my.betservice.domain.user.Customer;
import my.betservice.dto.user.CustomerDto;
import my.betservice.mapper.bet.BetCardMapper;

public class CustomerMapper {
    public static Customer mapToCustomer(final CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .moneyOnAccount(dto.getMoneyOnAccount())
                .personalDetails(PersonalDetailsMapper.mapToPersonalDetails(dto.getPersonalDetails()))
                .betCarts(BetCardMapper.mapToBetCardList(dto.getBetCards()))
                .build();
    }

    public static CustomerDto mapToCustomerDto(final Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .moneyOnAccount(customer.getMoneyOnAccount())
                .personalDetails(PersonalDetailsMapper.mapToPersonalDetailsDto(customer.getPersonalDetails()))
                .betCards(BetCardMapper.mapToBetCardDtoList(customer.getBetCarts()))
                .build();
    }
}
