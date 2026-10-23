package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Description {
    private final String alphaAnalyticsPart;
    private final String newsFactPart;
    private final String aiPart;
}
