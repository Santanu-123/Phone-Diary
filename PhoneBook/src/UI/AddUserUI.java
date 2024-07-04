package UI;

import Database.HandleDatabase;
import Model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddUserUI extends JFrame {
    HandleDatabase hd = new HandleDatabase();
    User user = new User();
    JFrame frame = new JFrame("Add Contact Details");
    Color bg1 = new Color(1, 50, 32);
    Color bg2 = new Color(1, 0, 32);
    Color bg3 = new Color(100, 100, 100);
    Color t1 = new Color(255, 215, 0);
    Color t2 = new Color(10, 20, 15);
    boolean flag = false;

    public void showUI(){
        frame.setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        panel.setBackground(bg1);
        frame.add(panel);

        JLabel title = new JLabel("Add contact details");
        title.setBounds(140, 10, 270, 25);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Times new Roman", Font.BOLD, 20));
        panel.add(title);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 70, 50, 25);
        nameLabel.setForeground(Color.YELLOW);
        nameLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        panel.add(nameLabel);

        JTextField name = new JTextField();
        name.setBounds(70, 70, 165, 25);
        name.setForeground(Color.WHITE);
        name.setBackground(bg1);
        name.setBorder(new LineBorder(t1, 1));
        name.setFont(new Font("Times new Roman", Font.BOLD, 15));
        panel.add(name);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(250, 70, 50, 25);
        emailLabel.setForeground(Color.YELLOW);
        emailLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        panel.add(emailLabel);

        JTextField email = new JTextField();
        email.setBounds(310, 70, 160, 25);
        email.setForeground(Color.WHITE);
        email.setBackground(bg1);
        email.setBorder(new LineBorder(t1, 1));
        email.setFont(new Font("Times new Roman", Font.BOLD, 15));
        panel.add(email);

        JLabel phoneLabel = new JLabel("Phone Number: ");
        phoneLabel.setBounds(10, 110, 110, 25);
        phoneLabel.setForeground(Color.YELLOW);
        phoneLabel.setFont(new Font("Times new Roman", Font.BOLD, 16));
        panel.add(phoneLabel);

        JTextField phone = new JTextField();
        phone.setBounds(130, 110, 340, 25);
        phone.setForeground(Color.WHITE);
        phone.setBackground(bg1);
        phone.setBorder(new LineBorder(t1, 1));
        phone.setFont(new Font("Times new Roman", Font.BOLD, 15));
        panel.add(phone);

        JButton save = new JButton("Save");
        save.setBounds(150, 155, 170, 28);
        save.setForeground(Color.WHITE);
        save.setBackground(bg1);
        save.setBorder(new LineBorder(t1, 1));
        save.setFont(new Font("Times new Roman", Font.BOLD, 18));
        panel.add(save);

        JLabel outputLabel1 = new JLabel();
        outputLabel1.setBounds(10, 200, 450, 25);
        outputLabel1.setForeground(Color.LIGHT_GRAY);
        outputLabel1.setFont(new Font("Times new Roman", Font.BOLD, 15));
        panel.add(outputLabel1);

        JLabel outputLabel2 = new JLabel();
        outputLabel2.setBounds(10, 230, 450, 25);
        outputLabel2.setForeground(Color.LIGHT_GRAY);
        outputLabel2.setFont(new Font("Times new Roman", Font.BOLD, 15));
        panel.add(outputLabel2);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                String emailText = email.getText();
                String phoneText = phone.getText();

                if (!Objects.equals(nameText, "") && !Objects.equals(emailText, "") && !Objects.equals(phoneText, "")){
                    hd.addUser(nameText, emailText, phoneText);
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    outputLabel1.setText("Details: [ Name: "+nameText+",");
                    outputLabel2.setText("Email: "+emailText+" and Phone number: "+phoneText+" ]");
                }
                else{
                    outputLabel1.setText("All fields should be filled");
                }
            }
        });


        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setLocation(500, 100);
        frame.setResizable(false);
        uiClose();
    }
    public void uiClose(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String [] args){
        AddUserUI ui = new AddUserUI();
        ui.showUI();
    }
}
