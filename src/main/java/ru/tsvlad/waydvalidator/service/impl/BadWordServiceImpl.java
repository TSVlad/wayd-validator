package ru.tsvlad.waydvalidator.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tsvlad.waydvalidator.document.BadWordDocument;
import ru.tsvlad.waydvalidator.repo.BadWordRepository;
import ru.tsvlad.waydvalidator.restapi.dto.BadWordDTO;
import ru.tsvlad.waydvalidator.service.BadWordService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BadWordServiceImpl implements BadWordService {

    private BadWordRepository badWordRepository;
    private ModelMapper modelMapper;

    @Override
    public Flux<BadWordDTO> getAllBadWords() {
        return badWordRepository.findAll()
                .map(document -> modelMapper.map(document, BadWordDTO.class));
    }

    @Override
    public Flux<BadWordDTO> addAllBadWords(String words) {
        List<String> wordsList = List.of(words.split(" "));
        return badWordRepository.insert(wordsList.stream().map(BadWordDocument::new).collect(Collectors.toList()))
                .map(document -> modelMapper.map(document, BadWordDTO.class));
    }

    @Override
    public Mono<Void> deleteBadWordById(String id) {
        return badWordRepository.deleteById(id);
    }
}
