package com.skypro.resale.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skypro.resale.config.SomeUserDetailsService;
import com.skypro.resale.dto.NewPassword;
import com.skypro.resale.dto.Role;
import com.skypro.resale.model.Avatar;
import com.skypro.resale.model.User;
import com.skypro.resale.repository.AvatarRepository;
import com.skypro.resale.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockPart;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AvatarRepository avatarRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SomeUserDetailsService userDetailsService;

    private Authentication auth;
    private final User user = new User();
    private final MockPart imageFile
            = new MockPart("image", "avatar", "avatar".getBytes());
    private final Avatar avatar = new Avatar();

    @BeforeEach
    void setUp() {
        user.setUsername("username@mail.ru");
        user.setFirstName("User");
        user.setLastName("Test");
        user.setPhone("+79609279284");
        user.setPassword(encoder.encode("password"));
        user.setRole(Role.USER);
        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities());
    }

    @AfterEach
    void clearAll() {
        userRepository.delete(user);
        avatarRepository.delete(avatar);
    }

    @Test
    public void testSetPasswordReturnsOkWhenPasswordUpdated() throws Exception {
        NewPassword newPassword = new NewPassword();
        newPassword.setCurrentPassword("password");
        newPassword.setNewPassword("newPassword");

        mockMvc.perform(post("/users/set_password")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newPassword))
                        .with(authentication(auth)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserReturnsUserFromDataBase() throws Exception {
        mockMvc.perform(get("/users/me")
                        .with(authentication(auth)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUserReturnsUpdatedUser() throws Exception {
        String newFirstName = "New";
        String newLastName = "NewTest";
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);

        mockMvc.perform(patch("/users/me")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user))
                        .with(authentication(auth)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(newFirstName))
                .andExpect(jsonPath("$.lastName").value(newLastName));
    }


    @Test
    public void testUpdateUserAvatar() throws Exception {
        mockMvc.perform(patch("/users/me/image")
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .with(request -> {
                            request.addPart(imageFile);
                            return request;
                        })
                        .with(authentication(auth)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAvatar() throws Exception {
        avatar.setData("avatar".getBytes());
        avatar.setMediaType("image/jpeg");
        avatarRepository.save(avatar);
        user.setAvatar(avatar);
        userRepository.save(user);

        mockMvc.perform(get("/users/avatar/{id}", avatar.getId())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                        .with(authentication(auth)))
                .andExpect(status().isOk())
                .andExpect(content().bytes(avatar.getData()));
    }



}
