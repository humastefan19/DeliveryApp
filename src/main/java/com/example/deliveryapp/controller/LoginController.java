package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.LoginModel;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.security.UserDetailsDeliveryApp;
import com.example.deliveryapp.security.UserDetailsServiceDeliveryApp;
import com.example.deliveryapp.utils.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserDetailsServiceDeliveryApp userDetailsServiceDeliveryApp;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @RequestMapping(value = "/perform_login", method = RequestMethod.POST, produces = "application/json")
//    public ModelAndView performLogin(@Valid @ModelAttribute LoginModel loginModel, BindingResult bindingResult, ModelMap modelMap){
//        if(bindingResult.hasErrors()){
//            return new ModelAndView("login.html");
//        }
//        UserDetailsDeliveryApp userDetailsDeliveryApp = (UserDetailsDeliveryApp) userDetailsServiceDeliveryApp.loadUserByUsername(loginModel.getUsername());
//        if(userDetailsDeliveryApp != null){
//                return new ModelAndView("index.html");
//
//        }
//        else {
//            return new ModelAndView("login.html");
//        }
//    }
}
