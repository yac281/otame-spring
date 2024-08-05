package com.crow.stame.client.dto.attributesdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosterImage {
    @JsonProperty("tiny")
    private String tiny;

    @JsonProperty("large")
    private String large;

    @JsonProperty("small")
    private String small;

    @JsonProperty("medium")
    private String medium;

    @JsonProperty("original")
    private String original;
}
