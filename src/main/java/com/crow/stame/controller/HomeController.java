package com.crow.stame.controller;

import com.crow.stame.client.dto.AnimeContent;
import com.crow.stame.client.dto.AnimeContentData;
import com.crow.stame.client.service.KitsuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final KitsuService kitsuService;

    HomeController(KitsuService kitsuService) {
        this.kitsuService = kitsuService;
    }

    @GetMapping
    public String home() {
        Mono<AnimeContentData> data = this.kitsuService.getAllAnimeContent();
        //List<AnimeContent> list = data.block().getData();

        /*list.forEach(anime -> {
            System.out.printf(anime.toString());
        });*/

        return "home";
    }
}



