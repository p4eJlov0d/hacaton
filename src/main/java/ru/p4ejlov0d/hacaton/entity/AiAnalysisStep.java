package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.util.UUID;

@Entity
@Table(name = "aiAnalysisSteps")
@Data
@NoArgsConstructor
public class AiAnalysisStep {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID stepId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "analysisId", referencedColumnName = "analysisId")
    private AiAnalysis aiAnalysis;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private String resultSummary;

    @Column(nullable = false)
    private String[] sources;
}
