package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AIAnswer {
    private final Description description;
    private final Source source;
    private final AIGenerationSteps steps;
}
