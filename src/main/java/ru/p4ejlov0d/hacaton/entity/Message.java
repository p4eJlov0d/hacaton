package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import ru.p4ejlov0d.hacaton.model.SenderType;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "messages",
        indexes = @Index(
                name = "idx_message_company_sequence",
                columnList = "syntheticU, sequenceNumber"
        ),
        uniqueConstraints = @UniqueConstraint(
                name = "uk_company_sequence",
                columnNames = {"syntheticU", "sequenceNumber"}
))
@Data
@NoArgsConstructor
public class Message {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID messageId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "syntheticU", referencedColumnName = "syntheticU")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private SenderType sender;

    @Column(nullable = false, updatable = false, columnDefinition = "TEXT")
    private String content;

    @Column(updatable = false, nullable = false)
    private long sequenceNumber;

    @Column(nullable = false, updatable = false)
    private Date createdAt;
}
