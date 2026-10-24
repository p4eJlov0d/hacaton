package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.p4ejlov0d.hacaton.entity.converter.OKFSNameConverter;
import ru.p4ejlov0d.hacaton.entity.converter.OrganizationTypeConverter;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {
    @Id
    private String syntheticU;

    @Column(nullable = false)
    @Convert(converter = OrganizationTypeConverter.class)
    private OrganizationType orgType;

    @Column(nullable = false)
    @Convert(converter = OKFSNameConverter.class)
    private OKFSName okfsName;

    @Column(nullable = false)
    private String companyAgeYearsGradation;

    @Column(nullable = true)
    private String ecoMarkLabel;

    @Column(nullable = false)
    private String mainOkvedCode;

    @Column(nullable = false, columnDefinition = "text")
    private String mainOkvedName;

    @Column(nullable = false)
    private boolean negativeMark;

    @Column(nullable = false)
    private String amountWorkersFnsGradation;

    @Column(nullable = true)
    private String amountWorkersSparkGradation;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientType clType;

    @Column(nullable = false)
    private boolean clProductRkoMark;

    @Column(nullable = false)
    private boolean clProductGarMark;

    @Column(nullable = false)
    private boolean clProductLoaMark;

    @Column(nullable = false)
    private boolean clProductLeaMark;

    @Column(nullable = false)
    private boolean clProductDepMark;

    @Column(nullable = false)
    private boolean clProductZppMark;

    @Column(nullable = false)
    private boolean ftsFlag;

    @Column(nullable = true)
    private String ftsCountryName; // может быть несколько стран (АБХАЗИЯ, ТАДЖИКИСТАН)

    @Column(nullable = false)
    private boolean factoringMark;

    @Column(nullable = false)
    private long revenueCompany;

    @Column(nullable = false)
    private String groupId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String region;

    @ManyToMany(mappedBy = "companies")
    private List<PhysicalPerson> physicalPersons;

    @OneToMany(mappedBy = "beneficiary")
    private List<Payment> incomingPayments;

    @OneToMany(mappedBy = "payer")
    private List<Payment> outgoingPayments;
}