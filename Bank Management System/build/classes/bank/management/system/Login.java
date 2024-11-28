package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * 
 * @author HARSHVARDHAN
 */

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    // Constructor to set up the GUI
    Login() {
        setTitle("---- ATM Login Page ----");

        setLayout(null);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90, 30, 100, 100);
        add(label);

        // Welcome Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(220, 70, 400, 40);
        add(text);

        // Card Number Label and Field
        JLabel cardno = new JLabel("CARD NO.");
        cardno.setFont(new Font("Osward", Font.BOLD, 25));
        cardno.setBounds(120, 180, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(250, 180, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        // PIN Label and Field
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setBounds(120, 220, 400, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(250, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Buttons
        login = new JButton("SIGN IN");
        login.setBounds(120, 300, 180, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(320, 300, 180, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(120, 350, 380, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(630, 460);
        setVisible(true);
        setLocation(350, 200);
    }

    // Action Handler for Buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();

            if (cardNumber.isEmpty() || pinNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Card Number and PIN cannot be empty");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM login WHERE cardnumber = ? AND pinnumber = ?";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, cardNumber);
                pstmt.setString(2, pinNumber);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number & PIN");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
