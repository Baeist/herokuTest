package com.example.herokutest.repository;

import com.example.herokutest.model.Author;
import org.springframework.stereotype.Repository;

import java.sql.*;

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

    public Author showOneAuthorFromDB(){

        int id;
        String first;
        String last ;
        String email;
        String birthdate;
        String added;
        Author author = null;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM authors WHERE id = 1";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                id = rs.getInt(1);
                first = rs.getString(2);
                last = rs.getString(3);
                email = rs.getString(4);
                 birthdate = rs.getString(5);
                added = rs.getString(6);

                author = new Author(id, first, last, email, birthdate, added);
            }


        }
        catch (SQLException s){
            System.out.println("fail " + s);
        }
        return author;
    }



}
