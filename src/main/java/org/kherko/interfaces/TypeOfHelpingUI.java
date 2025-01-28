package org.kherko.ui;

import org.kherko.implementation.TypeOfHelpingImp;
import org.kherko.model.TypeOfHelping;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TypeOfHelpingUI {
    private TypeOfHelpingImp typeOfHelpingImp = new TypeOfHelpingImp();

    public void createUI() {
        JFrame frame = new JFrame("Type Of Helping Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JTextField nameField = new JTextField();
        JButton addButton = new JButton("Add Type");
        JButton deleteButton = new JButton("Delete Type by ID");
        JTextField idField = new JTextField();
        JButton viewButton = new JButton("View All");
        JTextArea outputArea = new JTextArea(5, 20);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                typeOfHelpingImp.addTypeOfHelping(name);
                outputArea.setText("Type added successfully.");
            } else {
                outputArea.setText("Please enter a type name.");
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                if (typeOfHelpingImp.isTrueId(id)) {
                    typeOfHelpingImp.deleteTypeOfHelping(id);
                    outputArea.setText("Type deleted successfully.");
                } else {
                    outputArea.setText("Invalid ID.");
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Please enter a valid numeric ID.");
            }
        });

        viewButton.addActionListener(e -> {
            List<TypeOfHelping> types = typeOfHelpingImp.getAllType();
            StringBuilder sb = new StringBuilder();
            for (TypeOfHelping type : types) {
                sb.append("ID: ").append(type.getId()).append(" - Name: ").append(type.getHelpingName()).append("\n");
            }
            outputArea.setText(sb.toString());
        });

        panel.add(new JLabel("Enter Type Name:"));
        panel.add(nameField);
        panel.add(addButton);
        panel.add(new JLabel("Enter ID to Delete:"));
        panel.add(idField);
        panel.add(deleteButton);
        panel.add(viewButton);
        panel.add(new JScrollPane(outputArea));

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TypeOfHelpingUI().createUI());
    }
}
