package ru.p4ejlov0d.hacaton.exception;

public class CompanyNotSelectedException extends RuntimeException {
    public CompanyNotSelectedException() {
        super("Company not selected");
    }
}
