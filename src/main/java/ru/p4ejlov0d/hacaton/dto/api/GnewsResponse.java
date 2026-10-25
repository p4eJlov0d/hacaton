package ru.p4ejlov0d.hacaton.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.p4ejlov0d.hacaton.entity.NewsApiProducer;

import java.util.Date;
import java.util.List;

public class GnewsResponse extends NewsProducerResponse {
    @Getter
    private final List<Article> articles;

    public GnewsResponse(List<Article> articles) {
        super(NewsApiProducer.GNEWS);

        this.articles = articles;
    }

    public record Article(
            @JsonProperty(required = true)
            String id,
            @JsonProperty(required = true)
            String title,
            @JsonProperty(required = true)
            String description,
            @JsonProperty(required = true)
            String content,
            @JsonProperty(required = true)
            String url,
            String image,
            @JsonProperty(required = true)
            Date publishedAt
    ) {
        public boolean isDamaged() {
            return id == null
                    || id.isBlank()
                    || title == null
                    || title.isBlank()
                    || description == null
                    || description.isBlank()
                    || content == null
                    || content.isBlank()
                    || url == null
                    || url.isBlank()
                    || publishedAt == null;
        }
    }
}
