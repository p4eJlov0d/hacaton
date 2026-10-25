package ru.p4ejlov0d.hacaton.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.p4ejlov0d.hacaton.configuration.GnewsProperties;
import ru.p4ejlov0d.hacaton.dto.api.GnewsResponse;
import ru.p4ejlov0d.hacaton.entity.News;
import ru.p4ejlov0d.hacaton.repository.NewsRepository;
import ru.p4ejlov0d.hacaton.service.NewsCollectorService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GnewsCollector implements NewsCollectorService {
    private final GnewsProperties gnewsProperties;
    private final NewsRepository repository;

    @Override
    public GnewsResponse fetchNews() {
        RestTemplate restTemplate = new RestTemplate();
        String url = gnewsProperties.getGnewsApiUrl()
                + "?apikey="
                + gnewsProperties.getGnewsApiKey()
                + "&"
                + gnewsProperties.getGnewsUriVariables();

        log.info("Fetching news from GnewsApi URL: {}", url);
        return restTemplate.getForObject(url, GnewsResponse.class);
    }

    @Override
    @Scheduled(fixedDelayString = "${app.gnews.gnews-poll-interval-ms}")
    @Transactional
    public void fetchAndSaveNews() {
        GnewsResponse response = fetchNews();
        List<News> newsToSave = new ArrayList<>();

        if (response == null || response.getArticles() == null) {
            log.warn("Failed to fetch news. Gnews response is null or empty");
            return;
        }

        response.getArticles().forEach(article -> {
            if (article.isDamaged()) {
                log.warn("Damaged article found in Gnews response: {}", article);
                return;
            }

            if (repository.existsByNewsApiProducerAndExternalId(response.API_PRODUCER, article.id())) {
                log.info("Duplicate article found in Gnews response: {}", article);
                return;
            }

            News news = new News();
            news.setTitle(article.title());
            news.setTags(new String[]{"Ключевая ставка", "Экономика"}); // TODO
            news.setSummary(article.description()); // TODO поменять на article.content(), если будет переход на платную подписку
            news.setExternalId(article.id());
            news.setNewsApiProducer(response.API_PRODUCER);
            news.setPublishedAt(article.publishedAt());
            news.setImageUrl(article.image());
            news.setSource(article.url());

            newsToSave.add(news);
        });

        repository.saveAll(newsToSave);

        log.info("Saved {} articles from Gnews response", newsToSave.size());
    }
}
