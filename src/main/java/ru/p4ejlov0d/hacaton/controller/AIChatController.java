package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.p4ejlov0d.hacaton.dto.request.AskAiRequest;
import ru.p4ejlov0d.hacaton.dto.response.ChatMessageResponse;
import ru.p4ejlov0d.hacaton.entity.Message;
import ru.p4ejlov0d.hacaton.service.AiService;
import ru.p4ejlov0d.hacaton.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class AIChatController {
    private final MessageService messageService;
    private final AiService aiService;

    @GetMapping("/history")
    public ResponseEntity<List<ChatMessageResponse>> getChatHistory() {
        return ResponseEntity.ok(messageService.getMessages().stream()
                .map(message -> new ChatMessageResponse(message.getMessageId(), message.getContent(), message.getSender(), message.getCreatedAt()))
                .toList()
        );
    }

    @PostMapping("/ask")
    public ResponseEntity<ChatMessageResponse> askAI(@RequestBody AskAiRequest request) {
        Message answer = aiService.ask(request.prompt());

        return ResponseEntity.ok(new ChatMessageResponse(answer.getMessageId(), answer.getContent(), answer.getSender(), answer.getCreatedAt()));
    }
}
