package com.rental.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name= "contract_coupon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractCoupon {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @OneToOne
    @JoinColumn(name = "contract_id", unique = true, nullable = false)
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupon coupon;
}
