package my.betservice.registration.repository;

import my.betservice.registration.AppUserRole;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.domain.ConfirmationToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConfirmationTokenRepositoryTestSuite {
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    @Transactional
    public void findConfirmationTokenByToken() {
        //given
        String email = "marian@kowal.com";
        AppUser appUser = AppUser.builder()
                .appUserRole(AppUserRole.USER)
                .password("password")
                .username(email)
                .enabled(false)
                .build();
        AppUser saved = appUserRepository.save(appUser);
        String tokenName = "token";
        ConfirmationToken token = ConfirmationToken.builder()
                .appUser(appUser)
                .token(tokenName)
                .created(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .build();
        ConfirmationToken savedToken = confirmationTokenRepository.save(token);
        //when
        Optional<ConfirmationToken> tokenFromDb = confirmationTokenRepository.findByToken(tokenName);
        //then
        assertThat(tokenFromDb).isPresent();
        //cleanUp
        try {
            confirmationTokenRepository.deleteById(savedToken.getId());
            appUserRepository.deleteById(saved.getId());
        } catch (IllegalArgumentException e) {

        }
    }
}