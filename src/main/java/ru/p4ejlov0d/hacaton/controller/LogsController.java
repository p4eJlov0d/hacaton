package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.p4ejlov0d.hacaton.model.Log;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LogsController {
    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getLogs() {
        return ResponseEntity.ok(List.of(new Log("1", "001", new Date(), "Поиск новостей по теме события", "httpd://alpha.com", "Найдено 5 документов", 240L)));
    }
}
