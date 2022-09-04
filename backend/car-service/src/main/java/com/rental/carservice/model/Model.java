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
@Table(name= "model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
public class Model {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String name;
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private Set<Car> cars;
}
