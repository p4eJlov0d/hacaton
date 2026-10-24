package ru.p4ejlov0d.hacaton.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.p4ejlov0d.hacaton.entity.OKFSName;

@Converter
public class OKFSNameConverter implements AttributeConverter<OKFSName, String> {

    @Override
    public String convertToDatabaseColumn(OKFSName attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public OKFSName convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        for (OKFSName value : OKFSName.values())
            if (value.getValue().equals(dbData)) return value;

        throw new IllegalArgumentException("Unknown okfs name: " + dbData);
    }
}
