package ru.p4ejlov0d.hacaton.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Source {
    private final String sourceId;
    private final String sourceLink;
}
