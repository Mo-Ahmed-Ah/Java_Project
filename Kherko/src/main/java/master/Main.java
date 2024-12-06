package master;

import model.Status;
import templete.StatusTemp;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Main extends JFrame {
    private final JTextField nameField;
    private final JTextField nicknameField;
    private final JTextField locationField;
    private final JTextField phoneField;
    private final JTextField notesField;
    private final JTextField gidField;
    private final JRadioButton maleRadioButton;
    private final JTextArea statusDisplay;

    private final StatusTemp statusTemp = new StatusTemp(); // Instantiating the StatusTemp class

    public Main() {
        setTitle("Status Management");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Nickname:"));
        nicknameField = new JTextField();
        inputPanel.add(nicknameField);

        inputPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        inputPanel.add(locationField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Notes:"));
        notesField = new JTextField();
        inputPanel.add(notesField);

        inputPanel.add(new JLabel("GID:"));
        gidField = new JTextField();
        inputPanel.add(gidField);

        inputPanel.add(new JLabel("Gender:"));
        maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        JPanel genderPanel = new JPanel(new FlowLayout());
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        inputPanel.add(genderPanel);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Status");
        JButton updateButton = new JButton("Update Status");
        JButton deleteButton = new JButton("Delete Status");
        JButton getAllButton = new JButton("Get All Status");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(getAllButton);

        // Panel for status display
        statusDisplay = new JTextArea(10, 40);
        statusDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusDisplay);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            Status status = new Status();
            status.setName(nameField.getText());
            status.setNickname(nicknameField.getText());
            status.setLocation(locationField.getText());
            status.setPhone(phoneField.getText());
            status.setNotes(notesField.getText());

            try {
                // Try parsing GID as an integer
                status.setGid(Integer.parseInt(gidField.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid GID input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            status.setGender(maleRadioButton.isSelected() ? "male" : "female");
            // set default birthdate and joundate for simplicity
            status.setBirthdate(new Date());
            status.setJoundate(new Date());

            statusTemp.addStatus(status);
            displayAllStatuses();
        });

        updateButton.addActionListener(e -> {
            // Assuming we are updating by ID (you can prompt the user for the ID)
            Status status = new Status();
            status.setId(1); // Update ID manually for testing
            status.setName(nameField.getText());
            status.setNickname(nicknameField.getText());
            status.setLocation(locationField.getText());
            status.setPhone(phoneField.getText());
            status.setNotes(notesField.getText());

            try {
                // Try parsing GID as an integer
                status.setGid(Integer.parseInt(gidField.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid GID input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            status.setGender(maleRadioButton.isSelected() ? "male" : "female");
            status.setBirthdate(new Date());
            status.setJoundate(new Date());

            statusTemp.updateStatus(status);
            displayAllStatuses();
        });

        deleteButton.addActionListener(e -> {
            // Assuming we are deleting by ID (you can prompt the user for the ID)
            statusTemp.deleteStatus(1); // Delete status with ID = 1
            displayAllStatuses();
        });

        getAllButton.addActionListener(e -> displayAllStatuses());
    }

    private void displayAllStatuses() {
        statusDisplay.setText(""); // Clear the text area
        for (Status status : statusTemp.getAll()) {
            statusDisplay.append("ID: " + status.getId() + ", Name: " + status.getName() + ", Nickname: " + status.getNickname() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main gui = new Main();
            gui.setVisible(true);
        });
    }
}
