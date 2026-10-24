package ru.p4ejlov0d.hacaton.entity;

import lombok.Getter;

@Getter
public enum OrganizationType {
    COMMERCIAL_ORGANIZATION("КОММ_ОРГ"),
    NON_COMMERCIAL_ORGANIZATION("НЕКОММ_ОРГ");

    private final String value;

    OrganizationType(final String value) {
        this.value = value;
    }
}
