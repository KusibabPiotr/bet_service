package my.betservice.controller.user;

import lombok.RequiredArgsConstructor;
import my.betservice.dto.user.CustomerDto;
import my.betservice.facade.CustomerFacade;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
