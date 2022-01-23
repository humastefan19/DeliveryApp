package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RegisterUser;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.repository.UserRepository;
import com.example.deliveryapp.utils.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = "/perform_register",method = RequestMethod.POST, produces = "application/json")
    public String register(@Valid @ModelAttribute("registerUser") RegisterUser registerUser, BindingResult bindingResult, ModelMap modelMap) {
        if(bindingResult.hasErrors()){
            return "register.html";
        }
        User user = new User();
        BeanUtils.copyProperties(registerUser,user);
        user.setPassword(passwordEncoder().encode(registerUser.getPassword()));
        user.setRole(Roles.USER);
        userRepository.save(user);
        return "redirect:/login.html";
    }

}
