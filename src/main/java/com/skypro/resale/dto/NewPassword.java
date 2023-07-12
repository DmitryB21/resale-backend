package com.skypro.resale.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewPassword {
    //Эта аннотация гарантирует, что значения полей не могут быть пустыми или содержать только пробелы
    @NotBlank(message = "currentPassword need be filled")
    private String currentPassword;
    @NotBlank(message = "newPassword need be filled")
    private String newPassword;
}
