package UI;

import model.People;
import templete.PeopleTemp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;

public class AddPeople implements ActionListener {
    PeopleTemp peopleTemp ;
    JRadioButton mail;
    JRadioButton femail;
    ButtonGroup radiobuttongroub;
    JButton add;
    JFrame fram;
    JComboBox jbc;
    String[] location;
    JTable pepo;

    AddPeople() {
        peopleTemp = new PeopleTemp();
        List<People> peoples = peopleTemp.getAll();
        String[] detals = new String[]{
                "ID",
                "Name",
                "Nickname",
                "Birthdate",
                "Location",
                "Phone",
                "Gender",
                "Gid",
                "Notes",
                "Joundate"
        };
        mail = new JRadioButton("Male");
        femail = new JRadioButton("Female");
        radiobuttongroub = new ButtonGroup();
        add = new JButton("Add People");
        fram = new JFrame();
        Object[][] data = new Object[peoples.size()][10]; // عدد الأعمدة هو 10 كما في detals
        for (int i = 0; i < peoples.size(); i++) {
            People p = peoples.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getName();
            data[i][2] = p.getNickname();
            data[i][3] = p.getBirthdate();
            data[i][4] = p.getLocation();
            data[i][5] = p.getPhone();
            data[i][6] = p.getGender();
            data[i][7] = p.getGid();
            data[i][8] = p.getNotes();
            data[i][9] = p.getJoundate();
        }
        pepo = new JTable(data, detals);
        JScrollPane scrollPane = new JScrollPane(pepo);
        scrollPane.setPreferredSize(new Dimension(480, 300));


        location = new String[]{"الاسكندرية", "القاهرة", "المنصورة"};
//        location = new String[]{"Islam", "Mohamed", "Ahmed"};
        jbc = new JComboBox(location);

        jbc.setBounds(100, 200, 120, 40);


        mail.setBounds(110, 60, 100, 50);
        femail.setBounds(110, 100, 100, 50);

        radiobuttongroub.add(mail);
        radiobuttongroub.add(femail);

        add.setBounds(100, 160, 120, 40);
        add.addActionListener(this);

        fram.add(mail);
        fram.add(femail);
        fram.add(add);
        fram.add(jbc);
        fram.add(scrollPane);

        fram.setLayout(new FlowLayout());
        fram.setVisible(true);
        fram.setSize(500, 500);
        fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ea) {
        if (mail.isSelected())
            JOptionPane.showMessageDialog(null, "You are Male");
        else if (femail.isSelected())
            JOptionPane.showMessageDialog(null, "You are Female");
        else
            JOptionPane.showMessageDialog(null, "Please select a gender");
    }

    public static void main(String[] args) {
        new AddPeople();
    }
}
