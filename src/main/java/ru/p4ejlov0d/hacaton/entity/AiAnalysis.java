package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.util.UUID;

@Entity
@Table(name = "aiAnalyses")
@Data
@NoArgsConstructor
public class AiAnalysis {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID analysisId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "assessmentId", referencedColumnName = "assessmentId")
    private Assessment assessment;

    @Column(nullable = false)
    private long analysisTimeMs;

    @Column(nullable = false)
    private int tokenUsage;
}
