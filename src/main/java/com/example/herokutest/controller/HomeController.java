package com.example.herokutest.controller;

import com.example.herokutest.repository.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    DBManager dbm = new DBManager();
    HomeController(DBManager dbm){
        this.dbm = dbm;
    }


    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("author", dbm.showOneAuthorFromDB());
        return "index";
    }

}

// run -> edit config tilføj environment varibler for pass, user og url
// og på heroku

// user = System.getenv("user"); efter oprettet som environment variabel

// add system,properties fil med "java.runtime.version=11"