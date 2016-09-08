package com.github.kurkov.androidrestclient.domain;

import java.sql.Timestamp;

public class Message {

    private int id;
    private Timestamp dateOfCreation;
    private String text;

    public Message() {
    }

    public Message(int id, Timestamp dateOfCreation, String text) {
        this.id = id;
        this.dateOfCreation = dateOfCreation;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Timestamp dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}