package com.crow.stame.client.dto;


import com.crow.stame.client.dto.attributesdto.PosterImage;
import com.crow.stame.client.dto.attributesdto.Titles;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeContentAttributes {
    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("posterImage")
    private PosterImage coverImage;

    @JsonProperty("titles")
    private Titles titles;

    @JsonProperty("showType")
    private String showType;

    @JsonProperty("description")
    private String description;
}