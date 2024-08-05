package com.crow.stame.controller;


import com.crow.stame.client.service.KitsuService;
import com.crow.stame.model.AnimeModel;
import com.crow.stame.model.EpisodeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnimeApiController {

    private final KitsuService kitsuService;

    AnimeApiController(KitsuService kitsuService) {
        this.kitsuService = kitsuService;
    }

    @GetMapping("/trendig")
    public Mono<List<AnimeModel>> getTrendingAnime() {
        return kitsuService.getTrendingAnimeModels();
    }

    @GetMapping("/last-episodes")
    public Mono<List<EpisodeModel>> getLastEpisodes() {
        return kitsuService.getNewEpisodesModels();
    }
}
