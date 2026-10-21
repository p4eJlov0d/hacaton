package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.p4ejlov0d.hacaton.dto.request.AuthRequest;
import ru.p4ejlov0d.hacaton.dto.response.AuthSuccessResponse;

// контроллер, предоставляющий эндпоинты для тестирования
// удалить, когда сервис будет интегрироваться в интернет-банк
@RestController
@RequiredArgsConstructor
@Slf4j
@Scope("session")
public class AuthenticationController {
    @PostMapping("/login")
    public AuthSuccessResponse login(@RequestBody AuthRequest authRequest) {
        log.info("Login Request: {}", authRequest);
        AuthSuccessResponse response = new AuthSuccessResponse("name", "surname", "role", "companyName");
        log.info("Login Response: {}", response);
        return response;
    }
}
