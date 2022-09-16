package com.rental.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String notes;
    @Column(nullable = false)
    private Character gender;
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "client")
    private Set<Contract> contracts;
    @OneToMany(mappedBy = "client")
    private Set<UserClient> userClients;
}
