package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String capital;

  @Column(nullable = false)
  private String currency;

  public Country(final String name, final String capital, final String currency) {
    this.name = name;
    this.capital = capital;
    this.currency = currency;
  }
}
