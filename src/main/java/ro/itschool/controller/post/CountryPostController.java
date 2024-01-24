package ro.itschool.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.entity.Country;
import ro.itschool.service.CountryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryPostController implements ICountryPostController {

  private final CountryService countryService;

  public void createCountry(@RequestBody Country country) {
    countryService.save(country);
  }
}
