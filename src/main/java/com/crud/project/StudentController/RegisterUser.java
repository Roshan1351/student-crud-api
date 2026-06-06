package com.crud.project.StudentController;

import com.crud.project.StudentRepo.UserRepo;
import com.crud.project.model.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/register")
public class RegisterUser {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public String UserRegister(@Valid @RequestBody UserEntity user){
        if(userRepo.existsByUsername(user.getUsername())){
            return "username already exists";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User Register Successfully";
    }
}
