package com.example.dataviewfx;

public class University {
    private int id;
    private String name;
    private int rank;
    private String location;

    public University(int id, String name, int rank, String location) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.location = location;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getLocation() {
        return location;
    }
}
