package com.example.contactmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String args[]) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to the Contact Management System");
        initialization();

    }

    private static void initialization() {
        System.out.println("Please select one option:" + "\n\t 1. Manage Contact" + "\n\t 2. Message" + "\n\t 3. Quit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContact();
                break;
            case 2:
                manageMessage();
                break;
            default:
                break;
        }

    }

    private static void manageContact() {
        System.out.println("Please select one option:" + "\n\t 1. Show all Contacts" + "\n\t 2. Add new contact" + "\n\t 3. Search for a contact" + "\n\t 4. Delete a contact" + "\n\t 5. Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContacts();
                break;
            case 3:
                searchContacts();
                break;
            case 4:
                deleteContacts();
                break;
            default:
                initialization();
                break;
        }

    }

    private static void showAllContacts() {
        if (contacts.size() > 0) {
            for (contact c : contacts) {
                c.getDetails();
                System.out.println("\n************************");
            }
            initialization();
        } else {
            System.out.println("You dont have any contacts");
            manageContact();
        }
    }

    private static void addNewContacts() {
        System.out.println("Adding new Contacts" + "\n Please enter name: ");
        String name = scanner.next();
        System.out.println("Please enter contact number: ");
        String number = scanner.next();
        System.out.println("Please enter email: ");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please provide all the informations");
            addNewContacts();
        } else {
            boolean doesExist = false;
            for (contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }

            }
            if (doesExist) {
                System.out.println("Contact" + name + " saved on device");
            } else {
                contact contact = new contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
        }
        initialization();


    }

    private static void searchContacts() {
        System.out.println("Enter name for searching contact:");
        String choice = scanner.next();
        if (choice.equals("")) {
            System.out.println("Name required for searching");
            searchContacts();
        } else {
            boolean doesExist = false;
            for (contact c : contacts) {
                if (c.getName().equals(choice)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact in list");
                searchContacts();
            }
        }
        initialization();
    }

    private static void deleteContacts() {
        System.out.println("Enter contact name to delete:");
        String choice = scanner.next();
        if (choice.equals("")) {
            System.out.println("Name required for searching");
            deleteContacts();
        } else {
            boolean doesExist = false;
            for (contact c : contacts) {
                if (c.getName().equals(choice)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact in list");
            }
        }
        initialization();
    }

    private static void manageMessage() {
        System.out.println("Please select one option:" + "\n\t 1. Show all messages" + "\n\t 2. Send new message" + "\n\t 3. Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                initialization();
                break;
        }
    }

    private static void showAllMessages() {
        ArrayList<message> allMessages = new ArrayList<>();
        for (contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size() > 0) {
            for (message m : allMessages) {
                m.getDetails();
                System.out.println("************************");
            }

        } else {
            System.out.println("You dont have any messages");
        }
        initialization();
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send message");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Name required for sending message");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("What are going to text?");
                String message = scanner.next();
                if (message.equals("")) {
                    System.out.println("Message required!!!!");
                    sendNewMessage();
                } else {
                    id++;
                    message newmessage = new message(message, name, id);
                    for (contact c : contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<message> allMessages = c.getMessages();
                            allMessages.add(newmessage);
                            c.setMessages(allMessages);
                        }
                    }
                }
            } else {
                System.out.println("There is no such contact in list");
            }
        }
        initialization();
    }
}
