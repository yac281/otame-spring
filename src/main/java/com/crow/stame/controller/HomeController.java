package com.crow.stame.controller;

import org.springframework.ui.Model;
import com.crow.stame.client.dto.AnimeContent;
import com.crow.stame.client.dto.AnimeContentAttributes;
import com.crow.stame.client.dto.AnimeContentData;
import com.crow.stame.client.service.KitsuService;
import com.crow.stame.model.AnimeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final KitsuService kitsuService;

    HomeController(KitsuService kitsuService) {
        this.kitsuService = kitsuService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/anime/{slug}")
    public Mono<String> animeDetail(@PathVariable String slug, Model model) {

        return this.kitsuService.getDetailAnimeModel(slug)
                .doOnNext(animeModel -> {
                    System.out.println("AnimeModel: " + animeModel); // Debug log
                    model.addAttribute("anime", animeModel);
                })
                .then(Mono.just("detail"));
    }
}



