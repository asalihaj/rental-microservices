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
@Table(name= "report_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportCategory {
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

    @OneToMany(mappedBy = "reportCategory")
    private Set<Report> reports;
}
