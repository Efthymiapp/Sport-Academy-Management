package com.sportsacademy;

import java.util.ArrayList;

public class SportsAcademySystem {
    private ArrayList<User> users;
    private ArrayList<Athlete> athletes;
    private ArrayList<Coach> coaches;
    private ArrayList<Sport> sports;
    private ArrayList<Facility> facilities;
    private ArrayList<TrainingProgram> trainingPrograms;
    private ArrayList<TrainingProgramReservation> reservations;
    private ArrayList<Subscription> subscriptions;
    private ArrayList<Enrollment> enrollments;
    private ArrayList<Payment> payments;

    public SportsAcademySystem() {
        users = new ArrayList<>();
        athletes = new ArrayList<>();
        coaches = new ArrayList<>();
        sports = new ArrayList<>();
        facilities = new ArrayList<>();
        trainingPrograms = new ArrayList<>();
        reservations = new ArrayList<>();
        subscriptions = new ArrayList<>();
        enrollments = new ArrayList<>();
        payments = new ArrayList<>();
        
        // Initialize the system with sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample data initialization here
    }

    public static void main(String[] args) {
        new SportsAcademySystem();
    }

    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }

    public Athlete getAthleteById(int id) {
        for (Athlete athlete : athletes) {
            if (athlete.getId() == id) {
                return athlete;
            }
        }
        return null;
    }

    public void addReservation(TrainingProgramReservation reservation) {
        reservations.add(reservation);
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public Subscription getSubscriptionById(int id) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getId() == id) {
                return subscription;
            }
        }
        return null;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

	public TrainingProgram getTrainingProgramById(int trainingProgramId) {
		// TODO Auto-generated method stub
		return null;
	}
    public void removeAthlete(int id) {
        athletes.removeIf(athlete -> athlete.getId() == id);
    }
    public ArrayList<Athlete> getAllAthletes() {
        return new ArrayList<>(athletes);
    }



    
}
