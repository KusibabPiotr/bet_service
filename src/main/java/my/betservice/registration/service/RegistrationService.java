package my.betservice.registration.service;

import lombok.RequiredArgsConstructor;
import my.betservice.email.EmailBuilder;
import my.betservice.email.EmailService;
import my.betservice.exception.*;
import my.betservice.registration.domain.ConfirmationToken;
import my.betservice.registration.dto.RegistrationRequestDto;
import my.betservice.registration.mapper.AppUserMapper;
import my.betservice.registration.validator.EmailValidator;
import my.betservice.registration.validator.PasswordEqualityValidator;
import my.betservice.registration.validator.PasswordFormatValidator;
import my.betservice.registration.validator.TokenValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    public static final String EMAIL_WITH_LINK_JUST_SEND = "Email with confirmation request just send";
    public static final String EMAIL_SUCCESSFULLY_CONFIRMED = "Email successfully confirmed!";
    private final EmailValidator emailValidator;
    private final PasswordEqualityValidator passwordEqualityValidator;
    private final PasswordFormatValidator passwordFormatValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;
    private final TokenValidator tokenValidator;
    @Value("${confirm_registration_link}")
    private String linkWithoutToken;

    public String register(RegistrationRequestDto request)
            throws EmailNotValidException, PasswordNotMatchException,
            EmailAlreadyExistsInDatabaseException {
        emailValidator.validate(request.getEmail());
        passwordFormatValidator.validate(request.getPassword());
        passwordEqualityValidator.validate(request.getPassword(), request.getRepeatPassword());

        String link = linkWithoutToken + appUserService.signUpUser(AppUserMapper.mapToAppUser(request));
        emailService.send(
                request.getEmail(),
                EmailBuilder.buildEmail("Stranger", link));

        return EMAIL_WITH_LINK_JUST_SEND;
    }

    @Transactional
    public String confirmToken(final String token)
            throws TokenNotFoundException, EmaiAlreadyConfirmedException,
            TokenExpiredException {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(TokenNotFoundException::new);
        tokenValidator.validateIfAlreadyConfirmed(confirmationToken.getConfirmedAt());
        tokenValidator.validateConfirmationTime(confirmationToken.getExpiresAt());

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getUsername());
        return EMAIL_SUCCESSFULLY_CONFIRMED;
    }
}
