package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.p4ejlov0d.hacaton.dto.response.PersonalizedNewsData;
import ru.p4ejlov0d.hacaton.service.NewsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<List<PersonalizedNewsData>> getNews() {
        return ResponseEntity.ok(newsService.getPrioritizedNews());
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<?> getUniqueNews(@PathVariable UUID id) {
        return ResponseEntity.ok("new news with id " + id);
    }
}
