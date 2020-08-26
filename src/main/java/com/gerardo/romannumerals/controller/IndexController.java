package com.gerardo.romannumerals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String main(){
        return "main-page";
    }

    @GetMapping("/api")
    public String api(){ return "api"; }

}
