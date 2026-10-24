package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.dto.request.AuthRequest;
import ru.p4ejlov0d.hacaton.model.SessionUser;

public interface AuthService {
    SessionUser login(AuthRequest request);

    SessionUser getAuthenticatedUser();
}
