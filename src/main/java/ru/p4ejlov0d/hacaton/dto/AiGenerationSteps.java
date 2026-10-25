package ru.p4ejlov0d.hacaton.dto;

import java.util.List;

public record AiGenerationSteps(String traceId, List<Step> steps) {
    public record Step(int stepOrder,
                       String action,
                       boolean completed,
                       String resultSummary,
                       List<String> sourceIds
    ) {
    }
}
