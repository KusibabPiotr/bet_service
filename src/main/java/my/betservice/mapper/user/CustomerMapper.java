package my.betservice.mapper.user;

import my.betservice.domain.user.Customer;
import my.betservice.domain.user.PersonalDetails;
import my.betservice.dto.user.CustomerDto;
import my.betservice.mapper.bet.BetCardMapper;
import java.util.ArrayList;

public class CustomerMapper {
    public static Customer mapToCustomer(final CustomerDto dto) {
        return Customer.builder()
                .id(dto.getId())
                .moneyOnAccount(null)
                .personalDetails(PersonalDetailsMapper.mapToPersonalDetails(dto.getPersonalDetails()))
                .betCarts(new ArrayList<>())
                .build();
    }

    public static CustomerDto mapToCustomerDto(final Customer customer) {
        if (customer.getPersonalDetails()==null){
            customer.setPersonalDetails(new PersonalDetails());
        }
        return CustomerDto.builder()
                .id(customer.getId())
                .moneyOnAccount(customer.getMoneyOnAccount())
                .personalDetails(PersonalDetailsMapper.mapToPersonalDetailsDto(customer.getPersonalDetails()))
                .betCards(BetCardMapper.mapToBetCardDtoList(customer.getBetCarts()))
                .build();
    }
}
