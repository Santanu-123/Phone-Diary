package UI;

import Database.HandleDatabase;
import Model.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class SearchAllUI extends JFrame {
    JFrame frame = new JFrame("All Contacts");
    HandleDatabase hd = new HandleDatabase();
    List<User> userList = hd.getAllUsers();
    User user = new User();
    Color bg1 = new Color(1, 50, 32);
    Color bg2 = new Color(1, 0, 32);
    Color bg3 = new Color(100, 100, 100);
    Color t1 = new Color(255, 215, 0);
    Color t2 = new Color(10, 20, 15);

    public void showUI(){
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        panel.setBackground(bg1);
        frame.add(panel);

        JLabel title = new JLabel("Contact Details");
        title.setBounds(180, 10, 270, 25);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Times new Roman", Font.BOLD, 20));
        panel.add(title);

        String[] columnNames = {"ID", "Name", "Email", "Phone No"};
        Object[][] data = new Object[userList.size()][4];

        for(int i = 0; i < userList.size(); i++){
            user = userList.get(i);
            data[i][0] = user.getId();
            data[i][1] = user.getName();
            data[i][2] = user.getEmail();
            data[i][3] = user.getPhoneNumber();
        }

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setBorder(null);
        table.setBackground(bg1);
        table.setForeground(Color.LIGHT_GRAY);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 468, 280);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton add = new JButton("Add");
        add.setBounds(50, 330, 90, 20);
        add.setBackground(bg1);
        add.setForeground(t1);
        add.setBorder(new LineBorder(t1, 1));
        panel.add(add);

        JButton update = new JButton("Update");
        update.setBounds(150, 330, 90, 20);
        update.setBackground(bg1);
        update.setForeground(t1);
        update.setBorder(new LineBorder(t1, 1));
        panel.add(update);

        JButton delete = new JButton("Delete");
        delete.setBounds(250, 330, 90, 20);
        delete.setBackground(bg1);
        delete.setForeground(t1);
        delete.setBorder(new LineBorder(t1, 1));
        panel.add(delete);

        JButton search = new JButton("Search");
        search.setBounds(350, 330, 90, 20);
        search.setBackground(bg1);
        search.setForeground(t1);
        search.setBorder(new LineBorder(t1, 1));
        panel.add(search);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserUI ui = new AddUserUI();
                ui.showUI();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateUserUI ui = new UpdateUserUI();
                ui.showUI();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteUserUI ui = new DeleteUserUI();
                ui.showUI();
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchByIdUI ui = new SearchByIdUI();
                ui.showUI();
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
    public static void main(String[] args){
        SearchAllUI ui = new SearchAllUI();
        ui.showUI();
    }
}
