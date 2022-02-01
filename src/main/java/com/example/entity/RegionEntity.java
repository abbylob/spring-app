package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.Mapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST_ABIGAIL_REGIONS")
public class RegionEntity {
    @Id
    private Integer regionId;
    private String regionName;
    @OneToMany(mappedBy = "regionEntity")
    private List<CountryEntity> countryEntity;

}
