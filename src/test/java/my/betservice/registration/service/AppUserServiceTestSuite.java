package my.betservice.registration.service;

import my.betservice.exception.EmailAlreadyExistsInDatabaseException;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.domain.ConfirmationToken;
import my.betservice.registration.repository.AppUserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTestSuite {
    @InjectMocks
    private AppUserService appUserService;
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private ConfirmationTokenService confirmationTokenService;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Nested
    class TestLoadUserByUsername {
        @Test
        public void shouldReturnAppUserWithCorrectUsername() {
            //given
            String email = "mysz@op.pl";
            AppUser appUser = AppUser.builder()
                    .username(email)
                    .build();
            when(appUserRepository.findByUsername(email)).thenReturn(Optional.ofNullable(appUser));
            //when
            UserDetails userDetails = appUserService.loadUserByUsername(email);
            //then
            assertThat(userDetails.getUsername()).isEqualTo(appUser.getUsername());
        }

        @Test
        public void shouldThrowException() {
            //given
            String email = "mysz@op.pl";
            when(appUserRepository.findByUsername(email)).thenThrow(new UsernameNotFoundException("There is no user with given email in database!"));
            //when
            assertThatThrownBy(() -> appUserService.loadUserByUsername(email))
                    .isInstanceOf(UsernameNotFoundException.class)
                    .hasMessage("There is no user with given email in database!");
        }
    }

    @Nested
    class TestEnableAppUser {
        @Test
        public void shouldEnableAppUser() {
            //given
            String email = "mysz@op.pl";
            AppUser appUser = AppUser.builder()
                    .username(email)
                    .enabled(false)
                    .build();
            when(appUserRepository.findByUsername(email)).thenReturn(Optional.ofNullable(appUser));
            //when
            appUserService.enableAppUser(email);
            Boolean enabled = appUser.getEnabled();
            //then
            assertThat(enabled).isTrue();
        }

        @Test
        public void shouldThrowException() {
            //given
            String email = "mysz@op.pl";
            when(appUserRepository.findByUsername(email)).thenThrow(new UsernameNotFoundException("There is no user with given email in database!"));
            //when
            assertThatThrownBy(() -> appUserService.loadUserByUsername(email))
                    .isInstanceOf(UsernameNotFoundException.class)
                    .hasMessage("There is no user with given email in database!");
        }
    }

    @Nested
    class TestSignUpUser {
        @Test
        public void shouldSignUpUser() {
            //given
            String email = "mysz@op.pl";
            String password = "password";
            AppUser appUser = AppUser.builder()
                    .username(email)
                    .password(password)
                    .enabled(false)
                    .build();
            ConfirmationToken token = ConfirmationToken.builder()
                    .token("token")
                    .created(LocalDateTime.now())
                    .expiresAt(LocalDateTime.now().plusMinutes(15))
                    .appUser(appUser)
                    .build();
            when(appUserRepository.findByUsername(email)).thenReturn(Optional.empty());
            when(bCryptPasswordEncoder.encode(password)).thenReturn(password);
            when(appUserRepository.save(appUser)).thenReturn(appUser);
            when(confirmationTokenService.createConfirmationToken(appUser)).thenReturn(token);
            //when
            String createdToken = appUserService.signUpUser(appUser);
            //then
            assertThat(createdToken).isEqualTo("token");
        }

        @Test
        public void shouldThrowException() {
            //given
            String email = "mysz@op.pl";
            String password = "password";
            AppUser appUser = AppUser.builder()
                    .username(email)
                    .password(password)
                    .enabled(false)
                    .build();
            when(appUserRepository.findByUsername(email)).thenReturn(Optional.ofNullable(appUser));
            //when
            assertThatThrownBy(() -> appUserService.signUpUser(appUser))
                    .isInstanceOf(EmailAlreadyExistsInDatabaseException.class);
        }
    }
}