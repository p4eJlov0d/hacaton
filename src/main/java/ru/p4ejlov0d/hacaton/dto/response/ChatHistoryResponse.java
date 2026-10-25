package ru.p4ejlov0d.hacaton.dto.response;

import ru.p4ejlov0d.hacaton.model.SenderType;

public record ChatHistoryResponse(String messageContent, SenderType sender /*AIAnswer aiAnswer*/) {
}
