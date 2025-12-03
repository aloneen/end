package kz.seisen.end.services;



import kz.seisen.end.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    CountryDto create(CountryDto dto);
    CountryDto update(Long id, CountryDto dto);
    boolean delete(Long id);
}
