package com.skypro.resale.controller;

import com.skypro.resale.dto.NewPassword;
import com.skypro.resale.dto.UpdateUser;
import com.skypro.resale.dto.UserDto;
import com.skypro.resale.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Пользователи")
public class UserController {

    private final UserService userService;
//    private final AvatarServiceImpl avatarService;

    @Operation(
            summary = "Обновление пароля", tags = "Пользователи",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = NewPassword.class))}),
                    @ApiResponse(responseCode = "401", description = "Unauthorised"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword) {
        userService.updatePassword(newPassword);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Получить информацию об авторизованном пользователе", tags = "Пользователи",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = UserDto.class))}),
                    @ApiResponse(responseCode = "401", description = "Unauthorised"),
            }
    )
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @Operation(
            summary = "Обновить информацию об авторизованном пользователе", tags = "Пользователи",
            responses = {
                    @ApiResponse(
                            responseCode = "200", description = "OK",
                            content = {@Content(mediaType = "application/json",
                                        schema = @Schema(implementation = UpdateUser.class))}),
                    @ApiResponse(responseCode = "401", description = "Unauthorised"),
            }
    )
    @PatchMapping("/me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUser updateUser) {
        return ResponseEntity.ok(userService.updateUser(updateUser));
    }

    @Operation(
            summary = "Обновить аватар авторизованного пользователя", tags = "Пользователи",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateUserImage(@RequestPart("image") MultipartFile avatarFile) throws IOException {
        userService.updateUserAvatar(avatarFile);
        return ResponseEntity.ok().build();
    }

//    @Operation(hidden = true)
//    @GetMapping(value = "/avatar/{id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public byte[] getAvatar(@PathVariable("id") Integer id) {
//        return avatarService.getImageById(id).getData();
//    }

}
