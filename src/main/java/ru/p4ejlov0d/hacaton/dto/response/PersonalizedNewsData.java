package ru.p4ejlov0d.hacaton.dto.response;

import ru.p4ejlov0d.hacaton.model.Priority;

import java.util.Date;
import java.util.UUID;

public record PersonalizedNewsData(UUID id,
                                   Priority priority,
                                   String title,
                                   String imageUrl,
                                   String summary,
                                   String source,
                                   boolean read,
                                   Date publishedAt
) {
}
