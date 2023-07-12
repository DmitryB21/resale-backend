package com.skypro.resale.service;

import com.skypro.resale.dto.NewPassword;
import com.skypro.resale.dto.UpdateUser;
import com.skypro.resale.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void updatePassword(NewPassword newPassword);

    UserDto getUser();

    UserDto updateUser(UpdateUser updateUser);

    void updateUserAvatar(MultipartFile avatar) throws IOException;
}
