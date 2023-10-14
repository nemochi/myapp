package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.UserRegistrationForm;



@Controller
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping("")
    public String index() {
        return "user";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userRegistrationForm", new UserRegistrationForm());
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@Validated @ModelAttribute UserRegistrationForm userRegistrationForm, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            model.addAttribute("userRegistrationForm", userRegistrationForm);
            return "user/registration";
        }
        model.addAttribute("userRegistrationForm", userRegistrationForm);
        //return "user/registrationComplete";
        return "redirect:/user/registrationComplete";
    }
    @GetMapping("registrationComplete")
    public String registrationComplete() {
        return "user/registrationComplete";
    }
}
