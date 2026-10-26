package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.model.SessionUser;

public interface AuthService {
    SessionUser login(String name);

    SessionUser getAuthenticatedUser();

    Company getCurrentCompany();
}
