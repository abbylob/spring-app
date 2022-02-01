package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST_ABIGAIL_LOCATIONS")
public class LocationEntity {
    @Id
    private Integer locationId;
    private String streetAddress;
    private String postalCode;
    private String city;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn( name = "COUNTRY_ID")
    private CountryEntity countryEntity;

}
