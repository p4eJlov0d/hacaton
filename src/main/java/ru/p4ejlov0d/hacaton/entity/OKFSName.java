package ru.p4ejlov0d.hacaton.entity;

import lombok.Getter;

@Getter
public enum OKFSName {
    OTHER_MIXED_RUSSIAN_OWNERSHIP("ИНАЯ СМЕШАННАЯ РОССИЙСКАЯ СОБСТВЕННОСТЬ"),
    MUNICIPAL_OWNERSHIP("МУНИЦИПАЛЬНАЯ СОБСТВЕННОСТЬ"),
    MIXED_FOREIGN_OWNERSHIP("СМЕШАННАЯ ИНОСТРАННАЯ СОБСТВЕННОСТЬ"),
    MIXED_RUSSIAN_OWNERSHIP_REGIONS_SHARED("СМЕШАННАЯ РОССИЙСКАЯ СОБСТВЕННОСТЬ С ДОЛЕЙ СОБСТВЕННОСТИ СУБЪЕКТОВ РОССИЙСКОЙ ФЕДЕРАЦИИ"),
    MIXED_RUSSIAN_OWNERSHIP_FEDERAL_SHARED("СМЕШАННАЯ РОССИЙСКАЯ СОБСТВЕННОСТЬ С ДОЛЕЙ ФЕДЕРАЛЬНОЙ СОБСТВЕННОСТИ"),
    FOREIGN_CITIZEN_OWNERSHIP("СОБСТВЕННОСТЬ ИНОСТРАННЫХ ГРАЖДАН И ЛИЦ БЕЗ ГРАЖДАНСТВА"),
    FOREIGN_COMPANY_OWNERSHIP("СОБСТВЕННОСТЬ ИНОСТРАННЫХ ЮРИДИЧЕСКИХ ЛИЦ"),
    PUBLIC_ASSOCIATION_OWNERSHIP("СОБСТВЕННОСТЬ ОБЩЕСТВЕННЫХ ОБЪЕДИНЕНИЙ"),
    RUSSIAN_REGION_OWNERSHIP("СОБСТВЕННОСТЬ СУБЪЕКТОВ РОССИЙСКОЙ ФЕДЕРАЦИИ"),
    MIXED_PRIVATE_FOREIGN_OWNERSHIP("СОВМЕСТНАЯ ЧАСТНАЯ И ИНОСТРАННАЯ СОБСТВЕННОСТЬ"),
    FEDERAL_OWNERSHIP("ФЕДЕРАЛЬНАЯ СОБСТВЕННОСТЬ"),
    PRIVATE_OWNERSHIP("ЧАСТНАЯ СОБСТВЕННОСТЬ");

    private final String value;

    OKFSName(String value) {
        this.value = value;
    }
}
