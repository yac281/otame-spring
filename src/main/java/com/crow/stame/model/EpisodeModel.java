package com.crow.stame.model;

import com.crow.stame.client.dto.attributesdto.PosterImage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("canonicalTitle")
    private String canonicalTitle;

    @JsonProperty("airdate")
    private String airdate;

    @JsonProperty("season")
    private String season;

    @JsonProperty("number")
    private String number;

    @JsonProperty("description")
    private String description;

    @JsonProperty("thumbnail")
    private PosterImage posterImage;
}
