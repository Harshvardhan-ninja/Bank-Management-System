package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField oldPin, newPin, confirmPin;
    JButton submit, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        // Background Image
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/ATM_page.jpg"));
        Image i2 = atm.getImage().getScaledInstance(972, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 972, 790);
        add(image);

        // Header Text
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(300, 240, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Old PIN Field
        JLabel oldPinLabel = new JLabel("Old PIN:");
        oldPinLabel.setBounds(250, 280, 150, 25);
        oldPinLabel.setFont(new Font("System", Font.BOLD, 14));
        image.add(oldPinLabel);

        oldPin = new JPasswordField();
        oldPin.setBounds(380, 280, 120, 25);
        image.add(oldPin);

        // New PIN Field
        JLabel newPinLabel = new JLabel("New PIN:");
        newPinLabel.setBounds(250, 315, 150, 25);
        newPinLabel.setFont(new Font("System", Font.BOLD, 14));
        image.add(newPinLabel);

        newPin = new JPasswordField();
        newPin.setBounds(380, 315, 120, 25);
        image.add(newPin);

        // Confirm New PIN Field
        JLabel confirmPinLabel = new JLabel("Confirm New PIN:");
        confirmPinLabel.setBounds(250, 350, 150, 30);
        confirmPinLabel.setFont(new Font("System", Font.BOLD, 14));
        image.add(confirmPinLabel);

        confirmPin = new JPasswordField();
        confirmPin.setBounds(380, 350, 120, 25);
        image.add(confirmPin);

        // Buttons
        submit = new JButton("Submit");
        submit.setBounds(270, 400, 100, 30);
        submit.addActionListener(this);
        image.add(submit);

        back = new JButton("Back");
        back.setBounds(390, 400, 100, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame Settings
        setSize(972, 790);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String oPin = oldPin.getText();
                String nPin = newPin.getText();
                String cPin = confirmPin.getText();

                if (oPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter your old PIN");
                    return;
                }
                if (nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (!nPin.equals(cPin)) {
                    JOptionPane.showMessageDialog(null, "New PIN and Confirm PIN do not match");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pinnumber = '" + cPin + "' where pinnumber = '" + oPin + "'";
                String query2 = "update login set pinnumber = '" + cPin + "' where pinnumber = '" + oPin + "'";
                String query3 = "update signupthree set pinnumber = '" + cPin + "' where pinnumber = '" + oPin + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(cPin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
