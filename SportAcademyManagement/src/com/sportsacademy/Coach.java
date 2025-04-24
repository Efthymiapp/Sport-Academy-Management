package com.sportsacademy;

import java.util.Date;

public class Coach extends User {
    private String sport;
    private String certifications;

    public Coach(int id, String firstName, String lastName, String gender, Date dateOfBirth, String contactInfo, String sport, String certifications) {
        super(id, firstName, lastName, gender, dateOfBirth, contactInfo);
        this.sport = sport;
        this.certifications = certifications;
    }

    // Getters and Setters
    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }
}
