package ro.itschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.entity.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

  Optional<Country> findByName(String countryName);
}
