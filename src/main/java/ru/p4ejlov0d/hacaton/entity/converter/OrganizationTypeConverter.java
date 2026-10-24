package ru.p4ejlov0d.hacaton.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.p4ejlov0d.hacaton.entity.OrganizationType;

@Converter
public class OrganizationTypeConverter implements AttributeConverter<OrganizationType, String> {
    @Override
    public String convertToDatabaseColumn(OrganizationType attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public OrganizationType convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        for (OrganizationType value : OrganizationType.values())
            if (value.getValue().equals(dbData)) return value;

        throw new IllegalArgumentException("Unknown organization type: " + dbData);
    }
}
