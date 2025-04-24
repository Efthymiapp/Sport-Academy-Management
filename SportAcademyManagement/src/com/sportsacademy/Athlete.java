package com.sportsacademy;

import java.util.Date;

public class Athlete extends User {
    private boolean professional;
    private int experienceLevel;

    public Athlete(int id, String firstName, String lastName, String gender, Date dob, String contactInfo, boolean professional, int experienceLevel) {
        super(id, firstName, lastName, gender, dob, contactInfo);
        this.professional = professional;
        this.experienceLevel = experienceLevel;
    }

    // Getters and Setters
    public boolean isProfessional() {
        return professional;
    }

    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
