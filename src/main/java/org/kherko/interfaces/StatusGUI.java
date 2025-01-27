package org.kherko.interfaces;

import org.kherko.implementation.StatusImp;
import org.kherko.model.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StatusGUI {
    private StatusImp statusImp;

    public StatusGUI() {  // تعديل هنا
        statusImp = new StatusImp();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StatusGUI app = new StatusGUI();  // تعديل هنا
            app.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Status Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Add Status
        JTextField addStatusField = new JTextField(20);
        JButton addButton = new JButton("Add Status");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String statusName = addStatusField.getText();
                if (!statusName.isEmpty()) {
                    statusImp.addStatus(statusName);
                    JOptionPane.showMessageDialog(frame, "Status added successfully!");
                    addStatusField.setText(""); // Clear input field
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a status name.");
                }
            }
        });

        // Delete Status
        JTextField deleteIdField = new JTextField(20);
        JButton deleteButton = new JButton("Delete Status");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(deleteIdField.getText());
                    if (statusImp.isTrueID(id)) { // التحقق من وجود الـ id قبل الحذف
                        statusImp.deleteStatus(id);
                        JOptionPane.showMessageDialog(frame, "Status deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Status ID not found!");
                    }
                    deleteIdField.setText(""); // Clear input field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid status ID.");
                }
            }
        });


        // Get All Statuses
        JButton getAllButton = new JButton("Get All Statuses");
        getAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Status> statuses = statusImp.getAll();
                StringBuilder statusList = new StringBuilder();
                for (Status status : statuses) {
                    statusList.append("ID: ").append(status.getId()).append(" - ").append(status.getStat_name()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, statusList.toString());
            }
        });

        // Get Status Name by ID
        JTextField getIdField = new JTextField(20);
        JButton getNameButton = new JButton("Get Status Name by ID");
        getNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(getIdField.getText());
                    String statusName = statusImp.getNameByID(id);
                    if (statusName != null) {
                        JOptionPane.showMessageDialog(frame, "Status Name: " + statusName);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Status not found.");
                    }
                    getIdField.setText(""); // Clear input field
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid status ID.");
                }
            }
        });

        // Layout components
        frame.add(new JLabel("Enter Status Name to Add:"));
        frame.add(addStatusField);
        frame.add(addButton);
        frame.add(new JLabel("Enter Status ID to Delete:"));
        frame.add(deleteIdField);
        frame.add(deleteButton);
        frame.add(getAllButton);
        frame.add(new JLabel("Enter Status ID to Get Name:"));
        frame.add(getIdField);
        frame.add(getNameButton);

        frame.setVisible(true);
    }
}
