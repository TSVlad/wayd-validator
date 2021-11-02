package ru.tsvlad.waydvalidator.messaging.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private long id;
    private String username;
    private List<RoleDTO> roles;
    private String contacts;
    private String email;
}
