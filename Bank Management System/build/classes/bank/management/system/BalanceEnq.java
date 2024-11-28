package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author HARSHVARDHAN
 */
public class BalanceEnq extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnq(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Background Image
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/ATM_page.jpg"));
        Image i2 = atm.getImage().getScaledInstance(972, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 972, 790);
        add(image);

        back = new JButton("BACK");
        back.setBounds(390, 400, 120, 25);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amount;
                } else if (type.equalsIgnoreCase("Withdrawal")) {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs. " + balance);
        text.setBounds(230, 300, 500, 25);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);

        // Frame Settings
        setSize(972, 790);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnq("");
    }
}
