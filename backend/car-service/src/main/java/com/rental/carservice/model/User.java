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
@Table(name= "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
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

    @OneToMany(mappedBy = "company")
    private Set<Car> cars;
    @OneToMany(mappedBy = "company")
    private Set<Equipment> equipments;
    @OneToMany(mappedBy = "company")
    private Set<Insurance> insurances;
    @OneToMany(mappedBy = "company")
    private Set<Group> groups;
    @OneToMany(mappedBy = "company")
    private Set<Season> seasons;
    @OneToMany(mappedBy = "company")
    private Set<Period> periods;
    @OneToMany(mappedBy = "user")
    private Set<Report> reports;
    @OneToMany(mappedBy = "client")
    private Set<Review> reviews;


    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;
}
