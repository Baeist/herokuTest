package com.example.herokutest.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

@Repository
public class DBManager {

    private String url;
    private String password;
    private String user;

    private Connection connection;


    public DBManager(){
        makeDBConnection();
    }

    public void makeDBConnection(){

        url = System.getenv("url");
        password = System.getenv("password");
        user = System.getenv("user");

        try{
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e){
            System.out.println("failed to connect to db " + e);

        }



    }




}
