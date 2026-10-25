package ru.p4ejlov0d.hacaton.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "news", uniqueConstraints = @UniqueConstraint(
        columnNames = {"newsApiProducer", "externalId"}
))
@Data
@NoArgsConstructor
public class News {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    private UUID newsId;

    @Column(nullable = false, columnDefinition = "text")
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String summary;

    @Column(length = 2048)
    private String imageUrl;

    @Column(nullable = false, length = 2048)
    private String source;

    @Column(nullable = false)
    private String[] tags;

    @Column(nullable = false)
    private Date publishedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NewsApiProducer newsApiProducer;

    @Column(nullable = false)
    private String externalId;
}
