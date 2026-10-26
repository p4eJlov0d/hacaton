package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.metadata.RateLimit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.p4ejlov0d.hacaton.dto.response.ChatHistoryResponse;
import ru.p4ejlov0d.hacaton.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class AIChatController {
    private final ChatClient chatClient;
    private final MessageService messageService;

    @GetMapping("/history")
    public ResponseEntity<List<ChatHistoryResponse>> getChatHistory() {
        return ResponseEntity.ok(messageService.getMessages().stream()
                .map(message -> new ChatHistoryResponse(message.getMessageId(), message.getContent(), message.getSender(), message.getCreatedAt()))
                .toList()
        );
    }

    @PostMapping("/ask")
    public ResponseEntity<?> askAI(@RequestParam String ask) {
        var prompt = chatClient.prompt();
        var call = prompt.user(ask).call();
        System.out.println(call.chatResponse().getMetadata());
        RateLimit rateLimit = call.chatResponse().getMetadata().getRateLimit();
        System.out.println(rateLimit);
        System.out.println(call.chatResponse());
        System.out.println(call);
        return ResponseEntity.ok(call.content());
    }
}
