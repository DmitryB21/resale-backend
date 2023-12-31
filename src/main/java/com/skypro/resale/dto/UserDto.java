package com.skypro.resale.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String image;
    private Role role;
}
