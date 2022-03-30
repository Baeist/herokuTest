package com.example.herokutest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}

// run -> edit config tilføj environment varibler for pass, user og url
// og på heroku

// user = System.getenv("user"); efter oprettet som environment variabel

// add system,properties fil med "java.runtime.version=11"