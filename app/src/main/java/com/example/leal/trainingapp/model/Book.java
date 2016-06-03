package com.example.leal.trainingapp.model;

import com.orm.SugarRecord;

public class Book extends SugarRecord {
    private Long id;
    String title;
    String edition;

    public Book(){
    }

    public Book(String title, String edition){
        this.title = title;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return this.id+" | "+this.edition+" | "+this.title;
    }
}


