package com.crow.stame.client.dto;


import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeContent {
    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private AnimeContentAttributes attributes;
}