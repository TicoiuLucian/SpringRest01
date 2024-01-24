package ro.itschool.controller.patch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.exception.FieldNotFoundException;
import ro.itschool.service.CountryService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryPatchController {

  private final CountryService countryService;

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateCountry(
          @PathVariable("id") Integer existingId,
          @RequestBody Map<String, Object> updates) throws FieldNotFoundException {
    countryService.updatePatch(existingId, updates);
    return ResponseEntity.ok().build();
  }
}
