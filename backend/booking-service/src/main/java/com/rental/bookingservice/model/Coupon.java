package com.rental.bookingservice.model;

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
@Table(name= "coupon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private OffsetDateTime startDate;
    @Column(nullable = false)
    private OffsetDateTime endDate;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private int changeValue;
    @Column(nullable = false)
    private boolean isFixed;
    @Column(nullable = false)
    private OffsetDateTime dateCreated;
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private CouponType type;
    @OneToMany(mappedBy = "coupon")
    private Set<ContractCoupon> contractCoupons;
}
