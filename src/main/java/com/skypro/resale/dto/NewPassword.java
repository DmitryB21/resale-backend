package com.skypro.resale.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewPassword {
    private String currentPassword;
    private String newPassword;
}
