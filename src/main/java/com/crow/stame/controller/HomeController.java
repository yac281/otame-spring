package com.crow.stame.controller;

import com.crow.stame.client.dto.AnimeContent;
import com.crow.stame.client.dto.AnimeContentAttributes;
import com.crow.stame.client.dto.AnimeContentData;
import com.crow.stame.client.service.KitsuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final KitsuService kitsuService;

    HomeController(KitsuService kitsuService) {
        this.kitsuService = kitsuService;
    }

    @GetMapping
    public String home() {
        this.kitsuService.getAnimeAttributes()
                .doOnNext(attributesList -> attributesList.forEach(attributes -> {
                    System.out.println("Slug: " + attributes.getSlug());
                    System.out.println("Cover Image (large): " + attributes.getCoverImage().getLarge());
                    System.out.println("Title (en): " + attributes.getTitles().getEn());
                }))
                .subscribe();

        return "home";
    }
}



