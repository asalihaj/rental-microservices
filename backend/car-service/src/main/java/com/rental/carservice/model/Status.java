package com.rental.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
public class Status {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private short number;

    @OneToMany(mappedBy = "status")
    private Set<Car> cars;
}
