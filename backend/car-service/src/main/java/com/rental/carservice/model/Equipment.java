package com.rental.carservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name= "equipment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"groups"})
public class Equipment  {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int maxPerOrder;
    @Column
    private boolean isFixed;
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToMany(mappedBy = "equipments")
    private Set<Group> groups;
}
