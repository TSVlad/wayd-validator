package ru.tsvlad.waydvalidator.messaging.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO {
    private long id;
    private String name;
}
