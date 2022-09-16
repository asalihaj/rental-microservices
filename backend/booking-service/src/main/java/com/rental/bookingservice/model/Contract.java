package com.rental.bookingservice.model;

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
@Table(name= "contract")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private OffsetDateTime rentalDate;
    @Column(nullable = false)
    private OffsetDateTime returnDate;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @Column(nullable = false)
    private OffsetDateTime dateCreated;
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @OneToMany(mappedBy = "contract")
    private Set<Insurance> insurances;

    @OneToOne(mappedBy = "contract")
    private Flight flight;
    @OneToOne(mappedBy = "contract")
    private ContractCoupon contractCoupon;
}
