package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.p4ejlov0d.hacaton.dto.AiGenerationSteps;
import ru.p4ejlov0d.hacaton.dto.AiNotes;
import ru.p4ejlov0d.hacaton.dto.request.AskAIRequest;
import ru.p4ejlov0d.hacaton.dto.response.ChatHistoryResponse;
import ru.p4ejlov0d.hacaton.model.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@Slf4j
@RequiredArgsConstructor
public class AIChatController {
    /*@GetMapping("/history")
    public ResponseEntity<List<ChatHistoryResponse>> getChatHistory() {
        return ResponseEntity.ok(List.of(new ChatHistoryResponse("че там по ключевой ставке?", SenderType.USER, null), new ChatHistoryResponse("message", SenderType.AI, new AIAnswer(new AiNotes("рост инфляции", "повышение процента ключевой ставки", "все плохо"), new Source("001", "https://scam-news.com"), new AiGenerationSteps("001", List.of(new AiGenerationSteps.Step("1", "чтение аналитики альфа банка", true, "ну прочитал я аналитику", List.of("https://alphaanalytics.com"))))))));
    }*/

    /*@PostMapping("/ask")
    public ResponseEntity<AIAnswer> askAI(@RequestBody AskAIRequest ask) {
        log.info("ask AI {}", ask);
        return ResponseEntity.ok(new AIAnswer(new AiNotes("рост инфляции", "повышение процента ключевой ставки", "все плохо"), new Source("001", "https://scam-news.com"), new AiGenerationSteps("001", List.of(new AiGenerationSteps.Step("1", "чтение аналитики альфа банка", true, "ну прочитал я аналитику", List.of("https://alphaanalytics.com"))))));
    }*/
}
