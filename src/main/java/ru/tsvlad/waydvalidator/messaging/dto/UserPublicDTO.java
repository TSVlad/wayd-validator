package ru.tsvlad.waydvalidator.messaging.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserPublicDTO {
    private long id;
    private String username;
    private List<RoleDTO> roles;
    private String contacts;
}
