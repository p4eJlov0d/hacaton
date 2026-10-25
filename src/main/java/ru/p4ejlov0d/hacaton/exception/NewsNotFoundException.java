package ru.p4ejlov0d.hacaton.exception;

import java.util.UUID;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(UUID id) {
        super("News with id " + id + " not found");
    }
}
