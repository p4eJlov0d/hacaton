package ru.p4ejlov0d.hacaton.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.entity.Message;
import ru.p4ejlov0d.hacaton.repository.MessageRepository;
import ru.p4ejlov0d.hacaton.service.AuthService;
import ru.p4ejlov0d.hacaton.service.MessageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final AuthService authService;
    private final MessageRepository messageRepository;

    @Override
    public List<Message> getMessages() {
        Company currentCompany = authService.getCurrentCompany();

        return messageRepository.findAllByCompanyOrderBySequenceNumberAsc(currentCompany);
    }
}
