package com.crow.stame.client;

import com.crow.stame.client.dto.AnimeContentAttributes;
import com.crow.stame.model.AnimeModel;
import com.crow.stame.model.EpisodeModel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface KitsuHttpClient {

    Mono<List<AnimeContentAttributes>> getAnimeAttributes();

    Mono<List<AnimeModel>> getTrendingAnimeModels();

    Mono<List<EpisodeModel>> getNewEpisodesModels();

}
