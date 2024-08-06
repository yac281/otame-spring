package com.crow.stame.model;

import com.crow.stame.client.dto.attributesdto.PosterImage;
import com.crow.stame.client.dto.attributesdto.Titles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeModel {

    @JsonProperty("id")
    private String id;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("posterImage")
    private PosterImage posterImage;

    @JsonProperty("titles")
    private Titles titles;

    @JsonProperty("showType")
    private String showType;

    @JsonProperty("description")
    private String description;
}
