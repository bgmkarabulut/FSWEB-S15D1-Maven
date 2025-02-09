package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber, ArrayList<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts;
    }

    // Getter methods
    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // Method to add a new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    // Method to update an existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index != -1) {
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    // Method to remove a contact
    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    // Method to find a contact using a Contact object
    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Method to find a contact using a name (String)
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Method to query a contact by name
    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    // Method to print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
