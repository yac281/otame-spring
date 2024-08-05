package com.crow.stame.client;

import com.crow.stame.client.dto.AnimeContent;
import com.crow.stame.client.dto.AnimeContentAttributes;
import com.crow.stame.client.dto.AnimeContentData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface KitsuHttpClient {

    List<AnimeContentAttributes> getAllAnimeContent();
    Mono<AnimeContentData> getTrendingAnimeContent();
}
