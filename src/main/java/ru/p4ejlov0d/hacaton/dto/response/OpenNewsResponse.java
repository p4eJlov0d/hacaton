package ru.p4ejlov0d.hacaton.dto.response;

import ru.p4ejlov0d.hacaton.dto.AiNotes;
import ru.p4ejlov0d.hacaton.dto.AiGenerationSteps;
import ru.p4ejlov0d.hacaton.model.Priority;

import java.util.Date;
import java.util.UUID;

public record OpenNewsResponse(UUID id,
                               Priority priority,
                               String title,
                               Date publishedAt,
                               String imageUrl,
                               String description,
                               AiNotes aiNotes,
                               String[] sources,
                               AiGenerationSteps steps
) {
}