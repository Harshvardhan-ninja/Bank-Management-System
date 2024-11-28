package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 * 
 * @author HARSHVARDHAN
 */

public class FastCash extends JFrame implements ActionListener {

    JButton cash100, cash500, cash1000, cash2000, cash5000, cash10000, back;
    String pinNumber;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/ATM_page.jpg"));
        Image i2 = atm.getImage().getScaledInstance(972, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 972, 790);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(260, 240, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        cash100 = new JButton("Rs. 100");
        cash100.setBounds(235, 300, 130, 30);
        cash100.addActionListener(this);
        image.add(cash100);

        cash500 = new JButton("Rs. 500");
        cash500.setBounds(385, 300, 130, 30);
        cash500.addActionListener(this);
        image.add(cash500);

        cash1000 = new JButton("Rs. 1000");
        cash1000.setBounds(235, 340, 130, 30);
        cash1000.addActionListener(this);
        image.add(cash1000);

        cash2000 = new JButton("Rs. 2000");
        cash2000.setBounds(385, 340, 130, 30);
        cash2000.addActionListener(this);
        image.add(cash2000);

        cash5000 = new JButton("Rs. 5000");
        cash5000.setBounds(235, 380, 130, 30);
        cash5000.addActionListener(this);
        image.add(cash5000);

        cash10000 = new JButton("Rs. 10000");
        cash10000.setBounds(385, 380, 130, 30);
        cash10000.addActionListener(this);
        image.add(cash10000);

        back = new JButton("BACK");
        back.setBounds(425, 420, 90, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(972, 790);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4); // Extract amount
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinnumber = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdrawal")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "INSERT INTO bank VALUES ('" + pinNumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
