package my.betservice.registration.service;

import lombok.RequiredArgsConstructor;
import my.betservice.exception.TokenNotFoundException;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.domain.ConfirmationToken;
import my.betservice.registration.repository.ConfirmationTokenRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private static final Integer EXPIRATION_TIME_MINUTES = 15;

    public void saveConfirmationToken(final ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(final String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Transactional
    public void setConfirmedAt(final String token) throws TokenNotFoundException {
        ConfirmationToken confirmationToken = getToken(token)
                .orElseThrow(TokenNotFoundException::new);
        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(confirmationToken);
    }

    public ConfirmationToken createConfirmationToken(final AppUser appUser) {
        String token = UUID.randomUUID().toString();

        return ConfirmationToken.builder()
                .token(token)
                .created(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(EXPIRATION_TIME_MINUTES))
                .appUser(appUser)
                .build();
    }
}
