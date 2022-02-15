package my.betservice.registration.mapper;

import my.betservice.registration.AppUserRole;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.dto.RegistrationRequestDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppUserMapperTestSuite {
    @Test
    void shouldMapRegRequestDtoToAppUser() {
        //given
        var registrationRequestDto =
                RegistrationRequestDto.builder()
                .email("kruk@kruk.pl")
                .password("password")
                .repeatPassword("password")
                .build();
        //when
        AppUser appUser = AppUserMapper.mapToAppUser(registrationRequestDto);
        //then
        assertThat(appUser.getPassword()).isEqualTo("password");
        assertThat(appUser.getUsername()).isEqualTo("kruk@kruk.pl");
        assertThat(appUser.getAppUserRole()).isEqualTo(AppUserRole.USER);
        assertThat(appUser.isEnabled()).isFalse();
    }

}