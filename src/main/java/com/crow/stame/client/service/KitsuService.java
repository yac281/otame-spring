package com.crow.stame.client.service;


import com.crow.stame.client.KitsuHttpClient;
import com.crow.stame.client.dto.*;
import com.crow.stame.model.AnimeModel;
import com.crow.stame.model.EpisodeModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KitsuService implements KitsuHttpClient {
    private final WebClient webClient;

    public Mono<List<AnimeContentAttributes>> getAnimeAttributes() {
        return this.webClient.get()
                .uri("/edge/anime")
                .retrieve()
                .bodyToMono(AnimeContentData.class)
                .map(AnimeContentData::getData)
                .map(dataList -> dataList.stream()
                        .map(AnimeContent::getAttributes)
                        .collect(Collectors.toList()));
    }

    public Mono<List<AnimeModel>> getTrendingAnimeModels() {
        return this.webClient.get()
                .uri("/edge/trending/anime?limit=6")
                .retrieve()
                .bodyToMono(AnimeContentData.class)
                .map(AnimeContentData::getData)
                .map(dataList -> dataList.stream()
                        .map(data -> {
                            AnimeModel model = new AnimeModel();
                            AnimeContentAttributes attributes = data.getAttributes();
                            model.setId(data.getId());
                            model.setCreatedAt(attributes.getCreatedAt());
                            model.setUpdatedAt(attributes.getUpdatedAt());
                            model.setSlug(attributes.getSlug());
                            model.setPosterImage(attributes.getCoverImage());
                            model.setTitles(attributes.getTitles());
                            model.setDescription(attributes.getDescription());
                            model.setShowType(attributes.getShowType());
                            return model;
                        })
                        .collect(Collectors.toList()));
    }

    public Mono<List<EpisodeModel>> getNewEpisodesModels() {
        return this.webClient.get()
                .uri("/edge/episodes?sort=-airdate&limit=20")
                .retrieve()
                .bodyToMono(EpisodeContentData.class)
                .map(EpisodeContentData::getData)
                .map(dataList -> {
                    LocalDate today = LocalDate.now(); // Data odierna

                    // Usa il formatter adatto per la data senza orario
                    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

                    return dataList.stream()
                            .map(data -> {
                                EpisodeModel model = new EpisodeModel();
                                EpisodeContentAttributes attributes = data.getAttributes();
                                model.setId(data.getId());
                                model.setCanonicalTitle(attributes.getCanonicalTitle());
                                model.setDescription(attributes.getDescription());
                                model.setPosterImage(attributes.getPosterImage());
                                model.setNumber(attributes.getNumber());
                                model.setSeason(attributes.getSeason());

                                // Parsing della data di rilascio e confronto con oggi
                                LocalDate episodeDate = LocalDate.parse(attributes.getAirdate(), formatter);
                                if (!episodeDate.isAfter(today)) {
                                    model.setAirdate(attributes.getAirdate());
                                    return model;
                                } else {
                                    return null; // Filtra l'episodio se la data è dopo oggi
                                }
                            })
                            .filter(Objects::nonNull) // Rimuovi gli episodi nulli
                            .collect(Collectors.toList());
                });
    }

    public Mono<AnimeModel> getDetailAnimeModel(String animeSlug) {
        return this.webClient.get()
                .uri("/edge/anime?filter[slug]=" + animeSlug)
                .retrieve()
                .bodyToMono(AnimeContentData.class)
                .flatMap(animeContentData -> {
                    if (animeContentData.getData().isEmpty()) {
                        return Mono.empty();
                    }
                    AnimeContent data = animeContentData.getData().get(0);
                    AnimeContentAttributes attributes = data.getAttributes();
                    AnimeModel model = new AnimeModel();
                    model.setId(data.getId());
                    model.setCreatedAt(attributes.getCreatedAt());
                    model.setUpdatedAt(attributes.getUpdatedAt());
                    model.setSlug(attributes.getSlug());
                    model.setPosterImage(attributes.getCoverImage());
                    model.setTitles(attributes.getTitles());
                    model.setDescription(attributes.getDescription());
                    model.setShowType(attributes.getShowType());
                    return Mono.just(model);
                });
    }



}
