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
@Table(name= "period")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Period {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String name;
    @Column
    private OffsetDateTime startDate;
    @Column
    private OffsetDateTime endDate;
    @Column
    private int changeValue;
    @Column
    private boolean isFixed;
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToMany(mappedBy = "periods")
    private Set<Group> groups;
}
