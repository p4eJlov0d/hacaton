package ru.p4ejlov0d.hacaton.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.p4ejlov0d.hacaton.dto.request.AuthRequest;
import ru.p4ejlov0d.hacaton.entity.ClientType;
import ru.p4ejlov0d.hacaton.entity.PhysicalPerson;
import ru.p4ejlov0d.hacaton.exception.BadCredentialsException;
import ru.p4ejlov0d.hacaton.model.SessionUser;
import ru.p4ejlov0d.hacaton.repository.PhysicalPersonRepository;
import ru.p4ejlov0d.hacaton.service.AuthService;

@Service
@RequiredArgsConstructor
@SessionScope
public class AuthServiceImpl implements AuthService {
    private SessionUser sessionUser;
    private final PhysicalPersonRepository physicalPersonRepository;

    @Override
    public SessionUser login(AuthRequest request) {
        if (sessionUser != null) return sessionUser;

        PhysicalPerson person = physicalPersonRepository.findById(request.name()).orElseThrow(
                () -> new BadCredentialsException("Invalid username, given: " + request.name())
        );

        sessionUser = new SessionUser();
        sessionUser.setName(person.getSyntheticF());
        sessionUser.setCompanies(person.getCompanies().stream()
                .filter(company -> company.getClType().equals(ClientType.CLIENT))
                .toList()
        );

        return sessionUser;
    }

    @Override
    public SessionUser getAuthenticatedUser() {
        return sessionUser;
    }
}
