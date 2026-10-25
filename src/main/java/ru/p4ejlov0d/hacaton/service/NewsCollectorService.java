package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.dto.api.NewsProducerResponse;

public interface NewsCollectorService {
    NewsProducerResponse fetchNews();

    void fetchAndSaveNews();
}
