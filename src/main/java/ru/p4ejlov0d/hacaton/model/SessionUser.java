package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.entity.News;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class SessionUser {
    private String name;

    private List<Company> companies;

    private Company currentCompany;

    // прочитанные новости
    private List<String> newsRead = new ArrayList<>();

    public boolean isRead(News news) {
        return newsRead.contains(news.getNewsId().toString());
    }
}
