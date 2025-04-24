package com.sportsacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscriptionManagementWindow extends JFrame {
    private JTable subscriptionTable;
    private JButton addSubscriptionButton;
    private JButton cancelSubscriptionButton;
    private JButton paySubscriptionButton;
    private SportsAcademySystem system;

    public SubscriptionManagementWindow() {
        setTitle("Subscription Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        system = new SportsAcademySystem();

        String[] columnNames = {"ID", "Athlete", "Program", "Monthly Cost"};
        Object[][] data = {};  // Fill this with subscription data from the system

        subscriptionTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(subscriptionTable);

        addSubscriptionButton = new JButton("Add Subscription");
        cancelSubscriptionButton = new JButton("Cancel Subscription");
        paySubscriptionButton = new JButton("Pay Subscription");

        addSubscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSubscription();
            }
        });

        cancelSubscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to cancel subscription
            }
        });

        paySubscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payForSubscription();
            }
        });

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addSubscriptionButton);
        buttonPanel.add(cancelSubscriptionButton);
        buttonPanel.add(paySubscriptionButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addSubscription() {
        JTextField idField = new JTextField();
        JTextField athleteIdField = new JTextField();
        JTextField trainingProgramIdField = new JTextField();
        JTextField monthlyCostField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Athlete ID:"));
        panel.add(athleteIdField);
        panel.add(new JLabel("Training Program ID:"));
        panel.add(trainingProgramIdField);
        panel.add(new JLabel("Monthly Cost:"));
        panel.add(monthlyCostField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Subscription",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                int athleteId = Integer.parseInt(athleteIdField.getText());
                int trainingProgramId = Integer.parseInt(trainingProgramIdField.getText());
                double monthlyCost = Double.parseDouble(monthlyCostField.getText());

                Athlete athlete = system.getAthleteById(athleteId);
                TrainingProgram trainingProgram = system.getTrainingProgramById(trainingProgramId);

                if (athlete == null || trainingProgram == null) {
                    JOptionPane.showMessageDialog(null, "Invalid Athlete ID or Training Program ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Subscription subscription = new Subscription(id, athlete, trainingProgram, monthlyCost);
                system.addSubscription(subscription);
                refreshSubscriptionTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void payForSubscription() {
        int selectedRow = subscriptionTable.getSelectedRow();
        if (selectedRow >= 0) {
            int subscriptionId = (int) subscriptionTable.getValueAt(selectedRow, 0);
            Subscription subscription = system.getSubscriptionById(subscriptionId);

            JTextField paymentIdField = new JTextField();
            JTextField paymentDateField = new JTextField();
            JTextField paymentMethodField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Payment ID:"));
            panel.add(paymentIdField);
            panel.add(new JLabel("Payment Date (yyyy-MM-dd):"));
            panel.add(paymentDateField);
            panel.add(new JLabel("Payment Method:"));
            panel.add(paymentMethodField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Pay for Subscription",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    int paymentId = Integer.parseInt(paymentIdField.getText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date paymentDate = dateFormat.parse(paymentDateField.getText());
                    String paymentMethod = paymentMethodField.getText();

                    Payment payment = new Payment(paymentId, paymentDate, paymentMethod, subscription, subscription.calculateTotalPrice());
                    system.addPayment(payment);
                    refreshPaymentTable();
                } catch (NumberFormatException | ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a subscription to pay for.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshSubscriptionTable() {
        // Logic to refresh subscription table based on the system's data
    }

    private void refreshPaymentTable() {
        // Logic to refresh payment table based on the system's data
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SubscriptionManagementWindow().setVisible(true);
            }
        });
    }
}
