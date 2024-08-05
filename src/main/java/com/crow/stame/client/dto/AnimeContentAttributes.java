package com.crow.stame.client.dto;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

@Setter
@Getter
public class AnimeContentAttributes {
    private String slug;
    private Array titles;
    private String description;
    private Array posterImage;

    @Override
    public String toString() {
        return "slug" + slug + "\n";
    }
}