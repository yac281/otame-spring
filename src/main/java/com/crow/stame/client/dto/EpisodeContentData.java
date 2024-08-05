package com.crow.stame.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeContentData {
    // Getter e Setter
    @JsonProperty("data")
    private List<EpisodeContent> data;

}