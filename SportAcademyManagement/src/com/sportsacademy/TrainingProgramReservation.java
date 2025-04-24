package com.sportsacademy;

import java.util.Date;

public class TrainingProgramReservation {
    private int id;
    private Athlete athlete;
    private TrainingProgram trainingProgram;
    private Date date;

    public TrainingProgramReservation(int id, Athlete athlete, TrainingProgram trainingProgram, Date date) {
        this.id = id;
        this.athlete = athlete;
        this.trainingProgram = trainingProgram;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
