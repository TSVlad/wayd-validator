package ru.tsvlad.waydvalidator.messaging.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.tsvlad.waydvalidator.config.security.Role;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserKafkaDTO {
    private String id;
    private String username;
    private List<Role> roles;
    private String name;
    private String surname;
    private String description;
    private String contacts;
    private String email;

    private LocalDate dateOfBirt;
}
