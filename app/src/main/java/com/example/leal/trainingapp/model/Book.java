package com.example.leal.trainingapp.model;

import com.orm.SugarRecord;

public class Book extends SugarRecord {
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
        return this.edition+" | "+this.title;
    }
}


