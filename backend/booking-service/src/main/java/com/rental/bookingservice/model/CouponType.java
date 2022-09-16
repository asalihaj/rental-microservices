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
@Table(name= "coupon_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponType {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String couponableType;
    @Column(nullable = false)
    private UUID couponableId;
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "type")
    private Set<Coupon> coupons;
}
