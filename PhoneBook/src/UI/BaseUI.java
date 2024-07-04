package UI;

import Database.HandleDatabase;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseUI extends JFrame {

    public static void main(String[] args) {
        Color bg1 = new Color(1, 50, 32);
        Color bg2 = new Color(1, 0, 32);
        Color bg3 = new Color(100, 100, 100);
        Color t1 = new Color(255, 215, 0);
        Color t2 = new Color(10, 20, 15);

        HandleDatabase hd = new HandleDatabase();
        User user = new User();

        JFrame frame = new JFrame("Phone Note Book");
        frame.setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 200, 400);
        panel1.setBackground(bg1);
        frame.add(panel1);
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(201, 0, 290, 400);
        panel2.setBackground(bg2);
        frame.add(panel2);

        JLabel title1 = new JLabel("Phone Book");
        title1.setBounds(40, 140, 170, 25);
        title1.setForeground(t1);
        title1.setFont(new Font("Times new Roman", Font.BOLD, 25));
        panel1.add(title1);

        JLabel title2 = new JLabel("Diary ...");
        title2.setBounds(105, 170, 170, 25);
        title2.setForeground(Color.LIGHT_GRAY);
        title2.setFont(new Font("Times new Roman", Font.BOLD, 20));
        panel1.add(title2);

        JButton button1 = new JButton("Add Contact");
        button1.setLayout(null);
        button1.setBounds(40, 140, 200, 25);
        button1.setFont(new Font("Times new Roman", Font.BOLD, 18));
        button1.setBackground(t2);
        button1.setForeground(Color.WHITE);
        panel2.add(button1);

        JButton button2 = new JButton("All Contacts");
        button2.setLayout(null);
        button2.setBounds(40, 175, 200, 25);
        button2.setFont(new Font("Times new Roman", Font.BOLD, 18));
        button2.setBackground(t2);
        button2.setForeground(Color.YELLOW);
        panel2.add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserUI newUi = new AddUserUI();
                newUi.showUI();
//                button1.setEnabled(false);
//                button1.setEnabled(true);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchAllUI sui = new SearchAllUI();
                sui.showUI();
            }
        });


        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
