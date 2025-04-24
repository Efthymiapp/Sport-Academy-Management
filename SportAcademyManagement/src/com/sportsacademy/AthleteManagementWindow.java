package com.sportsacademy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AthleteManagementWindow extends JFrame {
    private JTable athleteTable;
    private DefaultTableModel tableModel;
    private JButton addAthleteButton;
    private JButton editAthleteButton;
    private JButton deleteAthleteButton;
    private JButton goBackButton;
    private SportsAcademySystem system;

    public AthleteManagementWindow() {
        setTitle("Athlete Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        system = new SportsAcademySystem();

        String[] columnNames = {"ID", "First Name", "Last Name", "Gender", "DOB", "Contact", "Professional", "Experience"};
        tableModel = new DefaultTableModel(columnNames, 0);
        athleteTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(athleteTable);

        addAthleteButton = new JButton("Add Athlete");
        editAthleteButton = new JButton("Edit Athlete");
        deleteAthleteButton = new JButton("Delete Athlete");
        goBackButton = new JButton("Go Back");

        addAthleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAthlete();
            }
        });

        editAthleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAthlete();
            }
        });

        deleteAthleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAthlete();
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
        buttonPanel.add(addAthleteButton);
        buttonPanel.add(editAthleteButton);
        buttonPanel.add(deleteAthleteButton);
        buttonPanel.add(goBackButton);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshAthleteTable();
    }

    private void addAthlete() {
        JTextField idField = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField contactField = new JTextField();
        JCheckBox professionalBox = new JCheckBox();
        JTextField experienceLevelField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Date of Birth (yyyy-MM-dd):"));
        panel.add(dobField);
        panel.add(new JLabel("Contact Info:"));
        panel.add(contactField);
        panel.add(new JLabel("Professional:"));
        panel.add(professionalBox);
        panel.add(new JLabel("Experience Level:"));
        panel.add(experienceLevelField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Athlete",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String gender = genderField.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dob = dateFormat.parse(dobField.getText());
                String contactInfo = contactField.getText();
                boolean professional = professionalBox.isSelected();
                int experienceLevel = Integer.parseInt(experienceLevelField.getText());

                Athlete athlete = new Athlete(id, firstName, lastName, gender, dob, contactInfo, professional, experienceLevel);
                system.addAthlete(athlete);
                refreshAthleteTable();
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editAthlete() {
        int selectedRow = athleteTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) athleteTable.getValueAt(selectedRow, 0);
            Athlete athlete = system.getAthleteById(id);
            if (athlete != null) {
                JTextField idField = new JTextField(String.valueOf(athlete.getId()));
                JTextField firstNameField = new JTextField(athlete.getFirstName());
                JTextField lastNameField = new JTextField(athlete.getLastName());
                JTextField genderField = new JTextField(athlete.getGender());
                JTextField dobField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(athlete.getDateOfBirth()));
                JTextField contactField = new JTextField(athlete.getContactInfo());
                JCheckBox professionalBox = new JCheckBox();
                professionalBox.setSelected(athlete.isProfessional());
                JTextField experienceLevelField = new JTextField(String.valueOf(athlete.getExperienceLevel()));

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("ID:"));
                panel.add(idField);
                panel.add(new JLabel("First Name:"));
                panel.add(firstNameField);
                panel.add(new JLabel("Last Name:"));
                panel.add(lastNameField);
                panel.add(new JLabel("Gender:"));
                panel.add(genderField);
                panel.add(new JLabel("Date of Birth (yyyy-MM-dd):"));
                panel.add(dobField);
                panel.add(new JLabel("Contact Info:"));
                panel.add(contactField);
                panel.add(new JLabel("Professional:"));
                panel.add(professionalBox);
                panel.add(new JLabel("Experience Level:"));
                panel.add(experienceLevelField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Edit Athlete",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        athlete.setId(Integer.parseInt(idField.getText()));
                        athlete.setFirstName(firstNameField.getText());
                        athlete.setLastName(lastNameField.getText());
                        athlete.setGender(genderField.getText());
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        athlete.setDateOfBirth(dateFormat.parse(dobField.getText()));
                        athlete.setContactInfo(contactField.getText());
                        athlete.setProfessional(professionalBox.isSelected());
                        athlete.setExperienceLevel(Integer.parseInt(experienceLevelField.getText()));

                        refreshAthleteTable();
                    } catch (NumberFormatException | ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an athlete to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAthlete() {
        int selectedRow = athleteTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) athleteTable.getValueAt(selectedRow, 0);
            system.removeAthlete(id);
            refreshAthleteTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an athlete to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshAthleteTable() {
        tableModel.setRowCount(0); // Clear existing data
        for (Athlete athlete : system.getAllAthletes()) {
            Object[] rowData = {
                athlete.getId(),
                athlete.getFirstName(),
                athlete.getLastName(),
                athlete.getGender(),
                new SimpleDateFormat("yyyy-MM-dd").format(athlete.getDateOfBirth()),
                athlete.getContactInfo(),
                athlete.isProfessional(),
                athlete.getExperienceLevel()
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AthleteManagementWindow().setVisible(true);
            }
        });
    }
}
