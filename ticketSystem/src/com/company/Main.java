package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        try {
            ticketSystem.loadCategories("categories.txt");
            ticketSystem.run();
        } catch (IOException e) {
            System.err.println("Failed to load categories: " + e.getMessage());
        }
    }
}

