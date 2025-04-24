package com.sportsacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JButton manageAthletesButton;
    private JButton manageSubscriptionsButton;
    private JButton manageReservationsButton;

    public MainWindow() {
        setTitle("Sports Academy Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        manageAthletesButton = new JButton("Manage Athletes");
        manageSubscriptionsButton = new JButton("Manage Subscriptions");
        manageReservationsButton = new JButton("Manage Reservations");

        manageAthletesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AthleteManagementWindow().setVisible(true);
            }
        });

        manageSubscriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SubscriptionManagementWindow().setVisible(true);
            }
        });

        manageReservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReservationManagementWindow().setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        // Add spacing between buttons
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(centerButton(manageAthletesButton));
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(centerButton(manageSubscriptionsButton));
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(centerButton(manageReservationsButton));
        buttonPanel.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JPanel centerButton(JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(button);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
