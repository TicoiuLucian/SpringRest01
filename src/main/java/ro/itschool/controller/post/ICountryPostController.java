package ro.itschool.controller.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ro.itschool.controller.model.CountryDto;
import ro.itschool.entity.Country;

public interface ICountryPostController {

  String EXAMPLE = """
          {
          \"name\": \"Romania\",
          \"capital\": \"Bucuresti\",
          \"currency\": \"RON \"
          }
                    """;

  @Operation(summary = "Save a new country in DB")
  @ApiResponses(value = {@ApiResponse(responseCode = "200",
          description = "Successfully saved"),
          @ApiResponse(responseCode = "400", description = "Bad Request - Invalid input")})
  @PostMapping
  void createCountry(
          @Parameter(description = "Country to be saved")
          @io.swagger.v3.oas.annotations.parameters.RequestBody(
                  content = @Content(examples = {
                          @ExampleObject(name = "one", value = EXAMPLE)}
                  )) @RequestBody CountryDto countryDto);
}