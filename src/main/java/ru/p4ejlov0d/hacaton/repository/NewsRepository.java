package ru.p4ejlov0d.hacaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.p4ejlov0d.hacaton.entity.News;
import ru.p4ejlov0d.hacaton.entity.NewsApiProducer;

import java.util.UUID;

@Repository
public interface NewsRepository extends JpaRepository<News, UUID> {
    boolean existsByNewsApiProducerAndExternalId(NewsApiProducer newsApiProducer, String externalId);
}
