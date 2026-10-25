package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.dto.response.PersonalizedNewsData;

import java.util.List;

public interface NewsService {
    List<PersonalizedNewsData> getPrioritizedNews();
}
