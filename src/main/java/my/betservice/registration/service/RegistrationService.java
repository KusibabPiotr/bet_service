package my.betservice.registration.service;

import lombok.RequiredArgsConstructor;
import my.betservice.email.EmailBuilder;
import my.betservice.email.EmailService;
import my.betservice.exception.*;
import my.betservice.registration.domain.ConfirmationToken;
import my.betservice.registration.dto.RegistrationRequestDto;
import my.betservice.registration.mapper.AppUserMapper;
import my.betservice.registration.validator.EmailValidator;
import my.betservice.registration.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;
    @Value("${confirm_registration_link}")
    private String linkWithoutToken;

    public String register(RegistrationRequestDto request)
            throws EmailNotValidException, PasswordNotMatchException,
            EmailAlreadyExistsInDatabase {
        if (!emailValidator.test(request.getLogin())) {
            throw new EmailNotValidException();
        }
        if (!passwordValidator.test(request.getPassword(), request.getRepeatPassword())) {
            throw new PasswordNotMatchException();
        }

        String link = linkWithoutToken + appUserService.signUpUser(AppUserMapper.mapToAppUser(request));
        emailService.send(
                request.getLogin(),
                EmailBuilder.buildEmail("Stranger", link));

        return "Email with confirmation request just send";
    }

    @Transactional
    public String confirmToken(final String token)
            throws TokenNotFoundException, EmaiAlreadyConfirmedException,
            TokenExpiredException {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(TokenNotFoundException::new);

        if (confirmationToken.getConfirmedAt() != null) {
            throw new EmaiAlreadyConfirmedException();
        }

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException();
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getUsername());

        return "Email successfully confirmed!";
    }
}
