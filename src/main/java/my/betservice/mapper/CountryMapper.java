package my.betservice.mapper;

import my.betservice.domain.Country;
import my.betservice.dto.CountryDto;

public class CountryMapper {

    public static Country mapToCountry(final CountryDto dto) {
        return Country.builder()
                .id(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .flag(dto.getFlag())
                .build();
    }

    public static CountryDto mapToCountryDto(final Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .code(country.getCode())
                .flag(country.getFlag())
                .build();
    }
}
