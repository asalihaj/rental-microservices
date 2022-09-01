package com.rental.carservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name= "photo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private boolean isMain;
    //Not sure about file data type, might be changed later
    @Column
    private String file;
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
