package ru.p4ejlov0d.hacaton.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AskAiRequest(@JsonProperty(required = true) String prompt) {
}
