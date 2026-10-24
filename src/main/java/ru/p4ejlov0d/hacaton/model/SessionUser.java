package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.p4ejlov0d.hacaton.entity.Company;

import java.util.List;

@NoArgsConstructor
@Data
public class SessionUser {
    private String name;

    private List<Company> companies;
}
