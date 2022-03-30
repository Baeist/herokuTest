package com.example.herokutest.repository;

import com.example.herokutest.model.Author;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DBManager {

    private String url = System.getenv("url");
    private String password = System.getenv("password");
    private String user = System.getenv("user");

    private Connection connection;

    public DBManager(){ }

    public void makeDBConnection(){

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established.");
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

        makeDBConnection();

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
