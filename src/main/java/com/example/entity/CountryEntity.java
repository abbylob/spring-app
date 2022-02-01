package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST_ABIGAIL_COUNTRIES")
public class CountryEntity {
    @Id
    private String countryId;
    private String countryName;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn( name = "REGION_ID")
    private RegionEntity regionEntity;

    @OneToMany(mappedBy = "countryEntity")
    private List<LocationEntity> locationEntity;

}