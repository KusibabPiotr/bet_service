package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.user.CustomerDto;
import my.betservice.facade.CustomerFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerFacade customerFacade;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerFacade.createCustomer(customerDto);
    }

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PutMapping(value = "/{id}")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto, @RequestParam Long id) {
        return customerFacade.updateCustomerPersonalDetails(customerDto, id);
    }
}
