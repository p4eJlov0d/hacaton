package ru.p4ejlov0d.hacaton.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AiConfiguration {
    private final ChatClient.Builder builder;

    @Bean
    public ChatClient chatClient() {
        return builder.build();
    }
}
