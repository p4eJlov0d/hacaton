package ru.p4ejlov0d.hacaton.dto.response;

import ru.p4ejlov0d.hacaton.model.SenderType;

import java.util.Date;
import java.util.UUID;

public record ChatMessageResponse(UUID messageId,
                                  String messageContent,
                                  SenderType sender,
                                  Date createdAt
) {
}
