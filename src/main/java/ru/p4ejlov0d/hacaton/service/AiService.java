package ru.p4ejlov0d.hacaton.service;

import ru.p4ejlov0d.hacaton.entity.Message;

public interface AiService {
    Message ask(String prompt);
}
