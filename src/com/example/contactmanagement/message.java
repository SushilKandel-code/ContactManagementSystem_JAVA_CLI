package com.example.contactmanagement;

public class message {
    String text;
    String recipent;
    int id;




    public message(String text, String recipent, int id) {
        this.text = text;
        this.recipent = recipent;
        this.id = id;
    }

    public void getDetails(){
        System.out.print("Contact Name:" + recipent + "/n Message:" + text + "/n ID: " + id );
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipent() {
        return recipent;
    }

    public void setRecipent(String recipent) {
        this.recipent = recipent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
