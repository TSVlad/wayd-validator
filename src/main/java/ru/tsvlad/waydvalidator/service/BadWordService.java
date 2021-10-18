package ru.tsvlad.waydvalidator.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsvlad.waydvalidator.restapi.dto.BadWordDTO;

public interface BadWordService {
    Flux<BadWordDTO> getAllBadWords();
    Flux<BadWordDTO> addAllBadWords(String words);
    Mono<Void> deleteBadWordById(String id);
}
