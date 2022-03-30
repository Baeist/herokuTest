package com.example.herokutest;

import com.example.herokutest.repository.DBManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HerokuTestApplication {

    public static void main(String[] args) {

        DBManager dbm = new DBManager();
        SpringApplication.run(HerokuTestApplication.class, args);
    }

}
