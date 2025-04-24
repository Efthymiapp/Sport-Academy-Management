package com.sportsacademy;

import java.util.Date;

public class Payment implements PriceList {
    private int id;
    private Date date;
    private String paymentMethod;
    private PriceList subscriptionOrEnrollment;
    private double totalCost;

    public Payment(int id, Date date, String paymentMethod, PriceList subscriptionOrEnrollment, double totalCost) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.subscriptionOrEnrollment = subscriptionOrEnrollment;
        this.totalCost = totalCost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PriceList getSubscriptionOrEnrollment() {
        return subscriptionOrEnrollment;
    }

    public void setSubscriptionOrEnrollment(PriceList subscriptionOrEnrollment) {
        this.subscriptionOrEnrollment = subscriptionOrEnrollment;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public double calculateTotalPrice() {
        return totalCost;  // Placeholder logic
    }
}
