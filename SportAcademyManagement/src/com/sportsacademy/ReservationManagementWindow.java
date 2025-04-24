package com.sportsacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationManagementWindow extends JFrame {
    private JTable reservationTable;
    private JButton addReservationButton;
    private JButton cancelReservationButton;
    private JButton goBackButton;
    private SportsAcademySystem system;

    public ReservationManagementWindow() {
        setTitle("Reservation Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        system = new SportsAcademySystem();

        String[] columnNames = {"ID", "Athlete", "Program", "Date"};
        Object[][] data = {};  // Fill this with reservation data from the system

        reservationTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(reservationTable);

        addReservationButton = new JButton("Add Reservation");
        cancelReservationButton = new JButton("Cancel Reservation");
        goBackButton = new JButton("Go Back");

        addReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReservation();
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to cancel reservation
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new MainWindow().setVisible(true); // Open the main window
            }
        });


        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addReservationButton);
        buttonPanel.add(cancelReservationButton);
        buttonPanel.add(goBackButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addReservation() {
        JTextField idField = new JTextField();
        JTextField athleteIdField = new JTextField();
        JTextField trainingProgramIdField = new JTextField();
        JTextField dateField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Athlete ID:"));
        panel.add(athleteIdField);
        panel.add(new JLabel("Training Program ID:"));
        panel.add(trainingProgramIdField);
        panel.add(new JLabel("Date (yyyy-MM-dd):"));
        panel.add(dateField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Reservation",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                int athleteId = Integer.parseInt(athleteIdField.getText());
                int trainingProgramId = Integer.parseInt(trainingProgramIdField.getText());

                // Parse date using SimpleDateFormat
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(dateField.getText());

                Athlete athlete = system.getAthleteById(athleteId);
                TrainingProgram trainingProgram = system.getTrainingProgramById(trainingProgramId);

                if (athlete == null || trainingProgram == null) {
                    JOptionPane.showMessageDialog(null, "Invalid Athlete ID or Training Program ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TrainingProgramReservation reservation = new TrainingProgramReservation(id, athlete, trainingProgram, date);
                system.addReservation(reservation);
                refreshReservationTable();
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void refreshReservationTable() {
        // Logic to refresh reservation table based on the system's data
    }
}
