package com.crow.stame.client.service;


import com.crow.stame.client.KitsuHttpClient;
import com.crow.stame.client.dto.AnimeContent;
import com.crow.stame.client.dto.AnimeContentAttributes;
import com.crow.stame.client.dto.AnimeContentData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KitsuService implements KitsuHttpClient {
    private final WebClient webClient;

    public List<AnimeContentAttributes> getAllAnimeContent(){
        AnimeContentData animeContentData = this.webClient.get().uri("/edge/anime").retrieve().bodyToMono(AnimeContentData.class).block();
        if (animeContentData != null) {
            return animeContentData.getData().stream()
                    .map(AnimeContent::getAttributes)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public Mono<AnimeContentData> getTrendingAnimeContent(){
        return this.webClient.get().uri("/edge/trending/anime").retrieve().bodyToMono(AnimeContentData.class);
    }
}
