package master;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Test extends JFrame {
    JFrame f;
    public Test(){
        JButton b = new JButton("Test");
        b.setBounds(120 , 100 , 150 , 60);
        setSize(600 , 500);
        setLayout(null);
        setVisible(true);
        add(b);
    }

}
