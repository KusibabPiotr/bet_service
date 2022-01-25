package my.betservice.registration.service;

import lombok.RequiredArgsConstructor;
import my.betservice.exception.EmailAlreadyExistsInDatabase;
import my.betservice.exception.EmailNotValidException;
import my.betservice.exception.PasswordNotMatchException;
import my.betservice.registration.dto.RegistrationRequestDto;
import my.betservice.registration.mapper.AppUserMapper;
import my.betservice.registration.validator.EmailValidator;
import my.betservice.registration.validator.PasswordValidator;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequestDto request)
            throws EmailNotValidException, PasswordNotMatchException,
            EmailAlreadyExistsInDatabase {
        if (!emailValidator.test(request.getLogin())) {
            throw new EmailNotValidException();
        }
        if (!passwordValidator.test(request.getPassword(), request.getRepeatPassword())) {
            throw new PasswordNotMatchException();
        }
        return appUserService.signUpUser(AppUserMapper.mapToAppUser(request));
    }
}
