package com.sportsacademy;

public class TrainingProgram {
    private int id;
    private Sport sport;
    private Facility facility;
    private Coach coach;
    private int minExperienceLevel;
    private boolean requiresReservation;
    private String gender;
    private int durationMinutes;
    private String dayOfWeek;

    public TrainingProgram(int id, Sport sport, Facility facility, Coach coach, int minExperienceLevel, boolean requiresReservation, String gender, int durationMinutes, String dayOfWeek) {
        this.id = id;
        this.sport = sport;
        this.facility = facility;
        this.coach = coach;
        this.minExperienceLevel = minExperienceLevel;
        this.requiresReservation = requiresReservation;
        this.gender = gender;
        this.durationMinutes = durationMinutes;
        this.dayOfWeek = dayOfWeek;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getMinExperienceLevel() {
        return minExperienceLevel;
    }

    public void setMinExperienceLevel(int minExperienceLevel) {
        this.minExperienceLevel = minExperienceLevel;
    }

    public boolean isRequiresReservation() {
        return requiresReservation;
    }

    public void setRequiresReservation(boolean requiresReservation) {
        this.requiresReservation = requiresReservation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
