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
@Table(name= "period")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"groups"})
public class Period {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private short startDay;
    @Column
    private short endDay;
    @Column(nullable = false)
    private int changeValue;
    @Column(nullable = false)
    private boolean isFixed;
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToMany(mappedBy = "periods")
    private Set<Group> groups;
}
