package ru.p4ejlov0d.hacaton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.p4ejlov0d.hacaton.dto.request.SelectCompanyRequest;
import ru.p4ejlov0d.hacaton.service.UserService;

// контроллер, предоставляющий эндпоинты для тестирования
// удалить, когда сервис будет интегрироваться в интернет-банк
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/company/select")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void selectCompany(@RequestBody SelectCompanyRequest request) {
        userService.selectCompany(request.companyName());
    }
}
