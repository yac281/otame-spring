package com.crow.stame.client.dto.attributesdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Titles {
    @JsonProperty("en")
    private String en;

    @JsonProperty("en_jp")
    private String enJp;

    @JsonProperty("ja_jp")
    private String jaJp;
}
