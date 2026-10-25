package ru.p4ejlov0d.hacaton.exception;

public class UnknownCompanyException extends RuntimeException {
    public UnknownCompanyException(String companyId) {
        super("Unknown company with id: " + companyId);
    }
}
