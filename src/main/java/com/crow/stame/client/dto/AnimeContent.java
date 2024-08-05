package com.crow.stame.client.dto;


import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;

@Setter
@Getter
public class AnimeContent {
    private String id;
    private List<AnimeContentAttributes> attributes;

    @Override
    public String toString() {
        return "id: " + id + "\n";
    }
}