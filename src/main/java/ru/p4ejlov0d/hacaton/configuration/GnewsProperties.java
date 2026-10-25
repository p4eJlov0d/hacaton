package ru.p4ejlov0d.hacaton.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.gnews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GnewsProperties {

    private String gnewsApiKey;

    private String gnewsApiUrl;

    private String gnewsUriVariables;
}
