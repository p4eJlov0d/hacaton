package ru.p4ejlov0d.hacaton.dto.response;

import java.util.List;

public record AuthSuccessResponse(String name, List<String> companyNames) {
}
