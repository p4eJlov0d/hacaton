package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class AIGenerationSteps {
    private final String traceId;
    private final List<Step> steps;

    @RequiredArgsConstructor
    @Data
    public static class Step {
        private final String stepOrder;
        private final String action;
        private final boolean completed;
        private final String resultSummary;
        private final List<String> sourceIds;
    }
}
