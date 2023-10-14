package com.example.demo;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

@ControllerAdvice
public class ExceptionHandller {
    @ExceptionHandler({Exception.class})
    public String exceptionHandlle(Exception e, Model model) {

        String stackTrace = ExceptionUtils.getStackTrace(e);
        stackTrace = "hage";
        model.addAttribute("exception", e);
        model.addAttribute("stackTrace", stackTrace);
        model.addAttribute("hage", "WADA");
        return "custom_error";
    }
}
