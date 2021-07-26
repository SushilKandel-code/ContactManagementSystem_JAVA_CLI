package com.example.contactmanagement;

import java.util.ArrayList;

public class contact {
    String name;
    String number;
    String email;
    ArrayList<message> messages;

    public contact(String name, String number, String email, ArrayList<message> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public  void getDetails(){
        System.out.print("Contact Name:" + name + "\n Phone Number:" + number + "\n Email: " + email );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<message> messages) {
        this.messages = messages;
    }
}
