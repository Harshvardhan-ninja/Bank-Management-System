package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniState extends JFrame {

    String pinnumber;

    MiniState(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 360, 400); // Set bounds for the mini statement
        add(mini);

        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(120, 20, 200, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 480, 300, 30);
        add(balanceLabel);

        try {
            Conn c = new Conn();
            // Fetch card details
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber = '" + pinnumber + "'");
            if (rs.next()) {
                String cardNumber = rs.getString("cardnumber");
                if (cardNumber != null && cardNumber.length() == 16) {
                    card.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
                } else {
                    card.setText("Card Number: Invalid");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int balance = 0;
            // Fetch transaction details
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
            StringBuilder statement = new StringBuilder("<html>");
            while (rs.next()) {
                statement.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount"))
                        .append("<br> <br>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("Withdrawal")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            statement.append("</html>");
            mini.setText(statement.toString());
            balanceLabel.setText("Your current account balance is Rs. " + balance);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniState("");
    }
}
