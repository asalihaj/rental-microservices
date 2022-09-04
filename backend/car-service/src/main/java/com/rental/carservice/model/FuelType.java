package com.rental.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "fuel_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
public class FuelType  {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String name;
    @Column
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "fuelType")
    private Set<Car> cars;
}
