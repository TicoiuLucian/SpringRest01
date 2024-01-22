package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Country;
import ro.itschool.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

  private final CountryRepository countryRepository;

  public Page<Country> findAllCountries(Pageable pageable) {
    return countryRepository.findAll(pageable);
  }

  public List<Country> findAll() {
    return countryRepository.findAll();
  }

  public Optional<Country> findById(final Integer id) {
    return countryRepository.findById(id);
  }

  public Optional<Country> findByName(final String countryName) {
    return countryRepository.findByName(countryName);
  }

  public void deleteById(final Integer id) {
    countryRepository.deleteById(id);
  }

  public void deleteAll() {
    countryRepository.deleteAll();
  }
}
