package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.itschool.entity.Country;
import ro.itschool.service.CountryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {

  private final CountryService countryService;

  //  @GetMapping(value = "/all")
  @RequestMapping(method = RequestMethod.GET, value = "/all")
  public List<Country> getCountries() {
    return countryService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Optional<Country> getById(@PathVariable Integer id) {
    return countryService.findById(id);
  }

  //http://localhost:8080/country/name?countryName=Germany
  @GetMapping(value = "/name")
  public Optional<Country> getByName(@RequestParam String countryName) {
    return countryService.findByName(countryName);
  }

  //http://localhost:8080/country/all-paged?page=0&size=10&sort=name,desc
  @GetMapping(value = "/all-paged")
  public Page<Country> getCountries(Pageable pageable) {
    return countryService.findAllCountries(pageable);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteById(@PathVariable Integer id) {
    countryService.deleteById(id);
  }

  @DeleteMapping(value = "/all")
  public void deleteAll() {
    countryService.deleteAll();
  }
}
