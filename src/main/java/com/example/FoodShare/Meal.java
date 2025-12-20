package com.example.FoodShare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Meal {
    private int id;
    private String name;
    private int quantity;
    private String description;
    private String location;
    private int donorId;
    private String donorName;
    private String donorPhone;
    private LocalDateTime createdAt;

    public Meal(String name, int quantity, String description, String location, int donorId) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.location = location;
        this.donorId = donorId;
        this.createdAt = LocalDateTime.now();
    }

    public Meal(int id, String name, int quantity, String description, String location,
                int donorId, String donorName, String donorPhone, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.location = location;
        this.donorId = donorId;
        this.donorName = donorName;
        this.donorPhone = donorPhone;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }

    public String getDonorName() { return donorName; }
    public void setDonorName(String donorName) { this.donorName = donorName; }

    public String getDonorPhone() { return donorPhone; }
    public void setDonorPhone(String donorPhone) { this.donorPhone = donorPhone; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt.format(formatter);
    }
}