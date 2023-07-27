package com.skypro.resale.service.impl;

import com.skypro.resale.dto.Register;
import com.skypro.resale.service.AuthService;
import com.skypro.resale.service.SomeUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SomeUserDetailsService manager;
    private final PasswordEncoder encoder;

//    public AuthServiceImpl(UserDetailsManager manager,
//                           PasswordEncoder passwordEncoder) {
//        this.manager = manager;
//        this.encoder = passwordEncoder;
//    }

    @Override
    public boolean login(String userName, String password) {
//        log.debug("Logging in user: {}", userName);
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(Register register) {
        if(register.getUsername() == null || register.getUsername().isBlank()
                || register.getFirstName() == null || register.getFirstName().isBlank()
                || register.getLastName() == null || register.getLastName().isBlank()
                || register.getPhone() == null || register.getPhone().isBlank()
                || register.getPassword() == null || register.getPassword().isBlank()) throw new IllegalArgumentException();

//        log.info("Registering new user: {}", registerReq.getUsername());
        manager.createUser(register);
//        log.info("User {} registered successfully", registerReq.getUsername());
        return true;
    }

}
