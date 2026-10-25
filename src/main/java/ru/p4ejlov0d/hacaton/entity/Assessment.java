package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "assessments")
@Data
@NoArgsConstructor
public class Assessment {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID assessmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "syntheticU", referencedColumnName = "syntheticU")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "newsId", referencedColumnName = "newsId")
    private News news;

    @Column(nullable = false)
    private int relevance;

    @Column(nullable = false)
    private int impact;

    @Column(nullable = false)
    private int urgency;

    @Column(nullable = false)
    private int confidence;

    @Column(nullable = false)
    private int novelty;

    @Column(nullable = false)
    private int opportunity;

    @Column(nullable = false)
    private int risk;

    @Column(nullable = false)
    private String reasoningSummary;

    @Column(nullable = false)
    private Date analyzedAt;
}
