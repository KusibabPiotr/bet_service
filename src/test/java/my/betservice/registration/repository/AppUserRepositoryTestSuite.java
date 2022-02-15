package my.betservice.registration.repository;

import my.betservice.registration.AppUserRole;
import my.betservice.registration.domain.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppUserRepositoryTestSuite {
    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void shouldReturnAdminUsernameAlreadySavedInDb() {
        //given
        String email = "marian@kowal.com";
        AppUser user = AppUser.builder()
                .appUserRole(AppUserRole.USER)
                .password("password")
                .username(email)
                .enabled(false)
                .build();
        AppUser saved = appUserRepository.save(user);
        //when
        Optional<AppUser> appUserFromDb = appUserRepository.findByUsername(email);
        //then
        assertThat(appUserFromDb).isPresent();
        //cleanUp
        try {
            appUserRepository.deleteById(saved.getId());
        } catch (IllegalArgumentException e) {

        }
    }
}