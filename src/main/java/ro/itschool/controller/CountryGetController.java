package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Country;
import ro.itschool.service.CountryService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryGetController {

  private final CountryService countryService;

  @GetMapping("/all")
  public ResponseEntity<?> getCountries() {
    var countries = countryService.findAll();
    if (countries.isEmpty()) {
      return new ResponseEntity<>(
              "No countries available",
              HttpStatus.GONE);
    }
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Optional<Country> getById(@PathVariable Integer id) {
    return countryService.findById(id);
  }

  //http://localhost:8080/country/name?countryName=Germany
  @GetMapping("/name")
  public Optional<Country> getByName(@RequestParam String countryName) {
    return countryService.findByName(countryName);
  }

  //http://localhost:8080/country/all-paged?page=0&size=10&sort=name,desc
  @GetMapping("/all-paged")
  public Page<Country> getCountries(Pageable pageable) {
    return countryService.findAllCountries(pageable);
  }
}
