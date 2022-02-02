package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RegisterUser;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.repository.UserRepository;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.UserService;
import com.example.deliveryapp.utils.Roles;
import com.example.deliveryapp.validator.UserValidator;
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
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.getAllUsers();

        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/getUserForEdit/{id}")
    public String getUserForEdit(@PathVariable Long id, Model model){
        Optional<User> user = userService.getUserById(id);
        model.addAttribute("userEdit", user);
        if(user == null){
            return "users";
        }else {
            return "editUser";
        }
    }

    @PostMapping("/editUserRequest")
    public String editUser(@ModelAttribute("userEdit") User userEdit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "users";
        }

        userService.updateUser(userEdit);


        return "redirect:/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        userService.deleteUser(id);
        return "users";
    }

}
