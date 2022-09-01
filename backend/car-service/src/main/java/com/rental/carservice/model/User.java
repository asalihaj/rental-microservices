package com.rental.carservice.model;

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
@Table(name= "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "user")
    private Set<Car> cars;
    @OneToMany(mappedBy = "user")
    private Set<Report> reports;
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;
}
