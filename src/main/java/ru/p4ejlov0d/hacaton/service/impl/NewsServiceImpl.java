package ru.p4ejlov0d.hacaton.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.p4ejlov0d.hacaton.dto.AiGenerationSteps;
import ru.p4ejlov0d.hacaton.dto.AiNotes;
import ru.p4ejlov0d.hacaton.dto.response.OpenNewsResponse;
import ru.p4ejlov0d.hacaton.dto.response.PersonalizedNewsData;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.entity.News;
import ru.p4ejlov0d.hacaton.exception.CompanyNotSelectedException;
import ru.p4ejlov0d.hacaton.exception.NewsNotFoundException;
import ru.p4ejlov0d.hacaton.model.Priority;
import ru.p4ejlov0d.hacaton.model.SessionUser;
import ru.p4ejlov0d.hacaton.repository.NewsRepository;
import ru.p4ejlov0d.hacaton.service.AuthService;
import ru.p4ejlov0d.hacaton.service.NewsService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final AuthService authService;
    private final NewsRepository newsRepository;

    @Override
    public List<PersonalizedNewsData> getPrioritizedNews() {
        SessionUser user = authService.getAuthenticatedUser();
        Company currentCompany = user.getCurrentCompany();

        if (currentCompany == null) throw new CompanyNotSelectedException();

        // TODO персонализация по виду деятельности компании, ранжирование по приоритету
        List<News> news = newsRepository.findAll();

        return news.stream()
                .map(n -> new PersonalizedNewsData(n.getNewsId(), Priority.HIGH, n.getTitle(), n.getImageUrl(), n.getSummary(), n.getSource(), user.isRead(n), n.getPublishedAt()))
                .toList();
    }

    @Override
    public OpenNewsResponse getUniqueNewsById(UUID id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new NewsNotFoundException(id));

        // TODO должны подгружаться все размышления нейронки, ранжирование по приоритету, подгрузка фулл описания новости

        return new OpenNewsResponse(news.getNewsId(),
                Priority.HIGH,
                news.getTitle(),
                news.getPublishedAt(),
                news.getImageUrl(),
                news.getSummary(),
                new AiNotes("alpha", "news", "ai"),
                new String[]{news.getSource(), "alpha analitics.ru"},
                new AiGenerationSteps("001", List.of(new AiGenerationSteps.Step(1, "Чтение новости", true, "Прочтение новости", List.of(news.getSource()))))
        );
    }
}
