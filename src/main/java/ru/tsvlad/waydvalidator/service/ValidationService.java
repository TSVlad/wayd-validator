package ru.tsvlad.waydvalidator.service;

import ru.tsvlad.waydvalidator.messaging.dto.EventDTO;
import ru.tsvlad.waydvalidator.messaging.dto.UserPublicDTO;

public interface ValidationService {
    boolean isValidEvent(EventDTO eventDTO);
    boolean isValidUser(UserPublicDTO userPublicDTO);
}
