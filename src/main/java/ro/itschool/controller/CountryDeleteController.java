package ro.itschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryDeleteController {

  private final CountryService countryService;

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Integer id) {
    countryService.deleteById(id);
  }

  @DeleteMapping("/all")
  public void deleteAll() {
    countryService.deleteAll();
  }
}
