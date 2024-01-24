package ro.itschool.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.itschool.entity.Country;
import ro.itschool.exception.FieldNotFoundException;
import ro.itschool.repository.CountryRepository;

import java.util.List;
import java.util.Map;
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

  public void save(final Country country) {
    countryRepository.save(country);
  }

  public void updatePut(final Country country) {
    countryRepository.save(country);
  }

  public void updatePatch(
          final Integer existingId, final Map<String, Object> countryMap) {
    var countryOptional = countryRepository.findById(existingId);
    if (countryOptional.isEmpty()) {
      throw new RuntimeException("Country NOT Found");
    }
    Country country = countryOptional.get();
    for (Map.Entry<String, Object> entry : countryMap.entrySet()) {
      switch (entry.getKey()) {
        case "name":
          country.setName((String) entry.getValue());
          break;
        case "currency":
          country.setCurrency((String) entry.getValue());
          break;
        case "capital":
          country.setCapital((String) entry.getValue());
          break;
        default:
          throw new FieldNotFoundException("Field " + entry.getKey() + " not recognized");
      }
    }
    countryRepository.save(country);
  }
}
