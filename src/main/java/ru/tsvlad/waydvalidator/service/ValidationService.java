package ru.tsvlad.waydvalidator.service;

import org.springframework.stereotype.Service;
import ru.tsvlad.waydvalidator.messaging.dto.EventDTO;

public interface ValidationService {
    boolean isValidEvent(EventDTO eventDTO);
}
