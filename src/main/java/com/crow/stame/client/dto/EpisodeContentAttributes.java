package com.crow.stame.client.dto;

import com.crow.stame.client.dto.attributesdto.PosterImage;
import com.crow.stame.client.dto.attributesdto.Titles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeContentAttributes {
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