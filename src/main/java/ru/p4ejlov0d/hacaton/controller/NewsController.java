package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.p4ejlov0d.hacaton.dto.response.NewsResponse;
import ru.p4ejlov0d.hacaton.model.Priority;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NewsController {
    @GetMapping("/news")
    public ResponseEntity<List<NewsResponse>> getNews() {
        return ResponseEntity.ok(List.of(new NewsResponse("title1", "shortDescription 1", UUID.randomUUID(), Priority.HIGH, new Date()), new NewsResponse("title2", "shortDescription 2", UUID.randomUUID(), Priority.MEDIUM, new Date()), new NewsResponse("title3", "shortDeswcription3", UUID.randomUUID(), Priority.LOW, new Date())));
    }
}
