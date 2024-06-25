package com.company;

public class Ticket {

    private static int nextId = 1;
    private int id;
    private String category;
    private String issueType;
    private String description;

    public Ticket(String category, String issueType, String description) {
        this.id = nextId++;
        this.category = category;
        this.issueType = issueType;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + "\nCategory: " + category + "\nIssue Type: " + issueType + "\nDescription: " + description;
    }

}
