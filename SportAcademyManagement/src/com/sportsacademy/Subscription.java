package com.sportsacademy;

public class Subscription implements PriceList {
    private int id;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private double monthlyCost;

    public Subscription(int id, Athlete athlete, TrainingProgram trainingProgram, double monthlyCost) {
        this.id = id;
        this.athlete = athlete;
        this.trainingProgram = trainingProgram;
        this.monthlyCost = monthlyCost;
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

    public TrainingProgram getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(TrainingProgram trainingProgram) {
        this.trainingProgram = trainingProgram;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public double calculateTotalPrice() {
        // Implement the calculation logic here
        return monthlyCost;  // Placeholder logic
    }
}
