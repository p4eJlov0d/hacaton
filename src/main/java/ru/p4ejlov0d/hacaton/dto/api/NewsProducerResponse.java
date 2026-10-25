package ru.p4ejlov0d.hacaton.dto.api;

import ru.p4ejlov0d.hacaton.entity.NewsApiProducer;

public abstract class NewsProducerResponse {
    public final NewsApiProducer API_PRODUCER;

    protected NewsProducerResponse(NewsApiProducer apiProducer) {
        this.API_PRODUCER = apiProducer;
    }
}
