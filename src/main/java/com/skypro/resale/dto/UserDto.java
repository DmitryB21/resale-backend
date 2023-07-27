package com.skypro.resale.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
}
