package com.rental.carservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private BigDecimal rentalRate;
    @Column
    private short prodYear;
    @Column
    private short seats;
    @Column
    private short doors;
    @Column
    private String plateNumber;
    @Column
    private OffsetDateTime dateCreated;
    @Column
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Report> reports;
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Photo> photos;
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private User company;
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    private FuelType fuelType;
    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "car_utility",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "utility_id")
    )
    private Set<Utility> utilities;
    @ManyToMany
    @JoinTable(
            name = "car_insurance",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "insurance_id")
    )
    private Set<Insurance> insurances;
}
