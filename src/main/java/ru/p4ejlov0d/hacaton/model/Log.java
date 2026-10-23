package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class Log {
    private final String id;
    private final String traceId;
    private final Date timestamp;
    private final String description;
    private final String sourceLink;
    private final String resultSummary;
    private final long durationMs;
}
