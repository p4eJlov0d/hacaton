package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.util.UUID;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID paymentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "beneficiaryId", referencedColumnName = "syntheticU")
    private Company beneficiary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payerId", referencedColumnName = "syntheticU")
    private Company payer;

    @Column(nullable = false)
    private long payAmt;

    @Column(nullable = false)
    private int payCnt;
}
