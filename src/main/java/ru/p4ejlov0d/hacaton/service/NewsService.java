package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.dto.response.OpenNewsResponse;
import ru.p4ejlov0d.hacaton.dto.response.PersonalizedNewsData;

import java.util.List;
import java.util.UUID;

public interface NewsService {
    List<PersonalizedNewsData> getPrioritizedNews();

    OpenNewsResponse getUniqueNewsById(UUID id);
}
