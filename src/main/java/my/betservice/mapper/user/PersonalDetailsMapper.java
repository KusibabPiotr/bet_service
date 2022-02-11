package my.betservice.mapper.user;

import my.betservice.domain.user.PersonalDetails;
import my.betservice.dto.user.PersonalDetailsDto;

public class PersonalDetailsMapper {
    public static PersonalDetails mapToPersonalDetails(final PersonalDetailsDto dto) {
        return PersonalDetails.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .mobileNumber(dto.getMobileNumber())
                .email(dto.getEmail())
                .build();
    }

    public static PersonalDetailsDto mapToPersonalDetailsDto(final PersonalDetails personalDetails) {
        return PersonalDetailsDto.builder()
                .id(personalDetails.getId())
                .firstName(personalDetails.getFirstName())
                .lastName(personalDetails.getLastName())
                .mobileNumber(personalDetails.getMobileNumber())
                .email(personalDetails.getEmail())
                .build();
    }
}
