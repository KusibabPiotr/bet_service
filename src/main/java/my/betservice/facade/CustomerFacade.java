package my.betservice.facade;

import lombok.RequiredArgsConstructor;
import my.betservice.domain.user.Customer;
import my.betservice.domain.user.PersonalDetails;
import my.betservice.dto.user.CustomerDto;
import my.betservice.dto.user.PersonalDetailsDto;
import my.betservice.mapper.user.CustomerMapper;
import my.betservice.mapper.user.PersonalDetailsMapper;
import my.betservice.service.CustomerService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerFacade {
    private final CustomerService customerService;

    public CustomerDto createCustomer(final CustomerDto dto) {
        Customer customer = CustomerMapper.mapToCustomer(dto);
        return CustomerMapper.mapToCustomerDto(customerService.createCustomer(customer));
    }

    public CustomerDto updateCustomerPersonalDetails(final PersonalDetailsDto details) {
        PersonalDetails personalDetails = PersonalDetailsMapper.mapToPersonalDetails(details);
        return CustomerMapper.mapToCustomerDto(customerService.updateCustomerPersonalDetails(personalDetails));
    }
}
