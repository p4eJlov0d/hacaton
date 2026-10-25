package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.p4ejlov0d.hacaton.dto.request.AuthRequest;
import ru.p4ejlov0d.hacaton.dto.response.AuthSuccessResponse;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.model.SessionUser;
import ru.p4ejlov0d.hacaton.service.AuthService;

// контроллер, предоставляющий эндпоинты для тестирования
// удалить, когда сервис будет интегрироваться в интернет-банк
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthSuccessResponse login(@RequestBody AuthRequest authRequest) {
        SessionUser user = authService.login(authRequest);
        return new AuthSuccessResponse(user.getName(), user.getCompanies().stream()
                .map(Company::getSyntheticU)
                .toList()
        );
    }
}
