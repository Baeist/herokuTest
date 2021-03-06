package com.example.herokutest.model;

public class Author {

    private int id;
    private String first;
    private String last;
    private String email;
    private String birthdate;
    private String added;

    public Author(){}

    public Author(int id, String first, String last, String email, String birthdate, String added){
        this.first = first;
        this.last = last;
        this.birthdate = birthdate;
        this.added = added;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAdded() {
        return added;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
