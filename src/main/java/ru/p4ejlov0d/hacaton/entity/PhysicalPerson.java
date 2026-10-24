package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "physicalPersons")
@Data
@NoArgsConstructor
public class PhysicalPerson {
    @Id
    private String syntheticF;

    @Column(nullable = true)
    private String cityName;

    @Column(nullable = true)
    private String rcName;

    @ManyToMany
    @JoinTable(
            name = "personsCompanies", uniqueConstraints = @UniqueConstraint(columnNames = {"syntheticF", "syntheticU"}),
            joinColumns = @JoinColumn(name = "syntheticF", referencedColumnName = "syntheticF"),
            inverseJoinColumns = @JoinColumn(name = "syntheticU", referencedColumnName = "syntheticU")
    )
    private List<Company> companies;
}
