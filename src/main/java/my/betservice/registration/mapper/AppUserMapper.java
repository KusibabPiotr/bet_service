package my.betservice.registration.mapper;

import my.betservice.registration.AppUserRole;
import my.betservice.registration.domain.AppUser;
import my.betservice.registration.dto.RegistrationRequestDto;

public class AppUserMapper {

    public static AppUser mapToAppUser(final RegistrationRequestDto dto) {
        return AppUser.builder()
                .username(dto.getLogin())
                .password(dto.getPassword())
                .appUserRole(AppUserRole.USER)
                .enabled(false)
                .build();
    }
}
