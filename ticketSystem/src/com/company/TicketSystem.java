package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TicketSystem {
    private Map<String, List<String>> categories;
    private List<Ticket> tickets;

    public TicketSystem() {
        this.categories = new HashMap<>();
        this.tickets = new ArrayList<>();
    }

    public void loadCategories(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String category = parts[0];
                    String[] issues = parts[1].split(",");
                    List<String> issueList = new ArrayList<>();
                    for (String issue : issues) {
                        issueList.add(issue.trim());
                    }
                    categories.put(category, issueList);
                }
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    createTicket(scanner);
                    break;
                case 2:
                    viewTickets();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void createTicket(Scanner scanner) {
        System.out.println("Available Categories:");
        for (String category : categories.keySet()) {
            System.out.println("- " + category);
        }
        System.out.print("Enter Category: ");
        String category = scanner.nextLine().toLowerCase(Locale.ROOT);

        if (!categories.containsKey(category)) {
            System.out.println("Invalid category.");
            return;
        }

        System.out.println("Available Issue Types:");
        for (String issueType : categories.get(category)) {
            System.out.println("- " + issueType);
        }
        System.out.print("Enter Issue Type: ");
        String issueType = scanner.nextLine().toLowerCase(Locale.ROOT);

        if (!categories.get(category).contains(issueType)) {
            System.out.println("Invalid issue type.");
            return;
        }

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        Ticket ticket = new Ticket(category, issueType, description);
        tickets.add(ticket);
        System.out.println("Ticket created successfully!");
    }

    private void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
                System.out.println("---------------");
            }
        }
    }
}
