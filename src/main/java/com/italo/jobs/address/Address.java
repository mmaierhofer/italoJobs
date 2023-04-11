package com.italo.jobs.address;

import com.italo.jobs.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "country")
    private Country country;
    @Column(name = "city")
    private String city;
    @Column(name = "street_and_number")
    private String streetAndNumber;
    @Column(name = "additional_info")
    private String additionalInfo;
}
