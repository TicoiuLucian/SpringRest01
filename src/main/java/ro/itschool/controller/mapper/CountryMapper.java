package ro.itschool.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.itschool.controller.model.CountryDto;
import ro.itschool.entity.Country;

@Mapper
public interface CountryMapper {

  CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

  Country CountryDtoToCountryEntity(CountryDto countryDto);

  CountryDto CountryEntityToCountryDto(Country country);
}
