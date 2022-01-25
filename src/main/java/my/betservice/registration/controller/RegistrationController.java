package my.betservice.registration.controller;

import lombok.RequiredArgsConstructor;
import my.betservice.exception.EmailAlreadyExistsInDatabase;
import my.betservice.exception.EmailNotValidException;
import my.betservice.exception.PasswordNotMatchException;
import my.betservice.registration.dto.RegistrationRequestDto;
import my.betservice.registration.service.RegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequestDto request)
            throws EmailNotValidException, PasswordNotMatchException,
            EmailAlreadyExistsInDatabase {
        return registrationService.register(request);
    }
}
