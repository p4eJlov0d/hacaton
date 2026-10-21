package ru.p4ejlov0d.hacaton.dto.response;

import ru.p4ejlov0d.hacaton.model.Priority;

import java.util.Date;
import java.util.UUID;

public record NewsResponse(String title, String shortDescription, UUID id, Priority priority, Date date) {
}
