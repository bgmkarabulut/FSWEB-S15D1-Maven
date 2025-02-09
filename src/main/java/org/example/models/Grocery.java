package org.example.models;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    // Static list to hold grocery items
    public static ArrayList<String> groceryList = new ArrayList<>();

    // Method to start the grocery app and interact with the user
    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select an option:");
            System.out.println("0 - Stop");
            System.out.println("1 - Add items");
            System.out.println("2 - Remove items");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    System.out.println("Application stopped.");
                    break;

                case 1:
                    System.out.println("Enter items to add (separate with commas for multiple items):");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;

                case 2:
                    System.out.println("Enter items to remove (separate with commas for multiple items):");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    // Method to add items to the grocery list
    public static void addItems(String input) {
        // Split the input by commas and add each item to the list
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim(); // Remove any leading/trailing spaces
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " is already in the list.");
            }
        }
        sortList();
    }

    // Method to remove items from the grocery list
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " is not in the list.");
            }
        }
        sortList();
    }

    // Method to check if an item exists in the list
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // Method to sort the list alphabetically
    public static void sortList() {
        Collections.sort(groceryList);
    }

    // Method to print the sorted grocery list
    public static void printSorted() {
        System.out.println("Grocery List:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}

