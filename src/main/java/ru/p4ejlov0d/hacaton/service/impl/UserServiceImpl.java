package ru.p4ejlov0d.hacaton.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.p4ejlov0d.hacaton.dto.request.SelectCompanyRequest;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.exception.UnknownCompanyException;
import ru.p4ejlov0d.hacaton.model.SessionUser;
import ru.p4ejlov0d.hacaton.service.AuthService;
import ru.p4ejlov0d.hacaton.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthService authService;

    @Override
    public void selectCompany(SelectCompanyRequest request) {
        SessionUser user = authService.getAuthenticatedUser();
        List<Company> companies = user.getCompanies();
        String companyId = request.companyName();

        if (companies.stream().anyMatch(company -> company.getSyntheticU().equals(companyId))) {
            companies.forEach(company -> {
                if (company.getSyntheticU().equals(companyId)) user.setCurrentCompany(company);
            });
        } else throw new UnknownCompanyException(companyId);
    }
}