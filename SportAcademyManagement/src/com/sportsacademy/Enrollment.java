package com.sportsacademy;

import java.util.Date;

public class Enrollment implements PriceList {
    private int id;
    private Athlete athlete;
    private Date date;
    private double cost;
    private double discount;

    public Enrollment(int id, Athlete athlete, Date date, double cost, double discount) {
        this.id = id;
        this.athlete = athlete;
        this.date = date;
        this.cost = cost;
        this.discount = discount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotalPrice() {
        // Implement the calculation logic here
        return cost * (1 - discount / 100);  // Placeholder logic
    }
}
