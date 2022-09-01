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
@Table(name= "grouping")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private OffsetDateTime lastUpdated;

    @OneToMany(mappedBy = "group")
    private Set<Car> cars;
    @ManyToMany
    @JoinTable(
            name = "equipment_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private Set<Equipment> equipments;
    @ManyToMany
    @JoinTable(
            name = "group_season",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    private Set<Season> seasons;
    @ManyToMany
    @JoinTable(
            name = "group_period",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "period_id")
    )
    private Set<Period> periods;
}
