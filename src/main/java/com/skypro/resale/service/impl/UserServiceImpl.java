package com.skypro.resale.service.impl;

import com.skypro.resale.dto.NewPassword;
import com.skypro.resale.dto.UpdateUser;
import com.skypro.resale.dto.UserDto;
import com.skypro.resale.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public void updatePassword(NewPassword newPassword) {

    }

    @Override
    public UserDto getUser() {
        return null;
    }

    @Override
    public UserDto updateUser(UpdateUser updateUser) {
        return null;
    }

    @Override
    public void updateUserAvatar(MultipartFile avatar) {

    }
}
