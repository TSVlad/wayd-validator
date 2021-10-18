package ru.tsvlad.waydvalidator.restapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsvlad.waydvalidator.restapi.dto.BadWordDTO;
import ru.tsvlad.waydvalidator.service.BadWordService;

@RestController
@RequestMapping("/bad-words")
@AllArgsConstructor
public class BadWordsController {
    private BadWordService badWordService;

    @GetMapping
    public Flux<BadWordDTO> getAll() {
        return badWordService.getAllBadWords();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBadWord(@PathVariable String id) {
        return badWordService.deleteBadWordById(id);
    }

    @PostMapping()
    public Flux<BadWordDTO> addWords(@RequestBody String words) {
        return badWordService.addAllBadWords(words);
    }
}
