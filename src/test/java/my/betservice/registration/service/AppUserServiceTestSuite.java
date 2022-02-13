package my.betservice.registration.service;

import my.betservice.registration.domain.AppUser;
import my.betservice.registration.repository.AppUserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
            assertThatThrownBy(() -> appUserRepository.findByUsername(email))
                    .isInstanceOf(UsernameNotFoundException.class)
                    .hasMessage("There is no user with given email in database!");
        }
    }
}