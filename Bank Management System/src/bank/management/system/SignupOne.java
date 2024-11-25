package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

/**
 * @author HARSHVARDHAN
 */
public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;

    SignupOne() {
        setTitle("---- Application Page - Page 1 ----");
        setLayout(null);

        // Generate a unique random number for the form number
        Random ran = new Random();
        random = ran.nextInt(900000) + 100000;

        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        // Name
        addLabelAndTextField("Name:", 140, nameTextField = new JTextField());
        nameTextField.setToolTipText("Enter your full name");

        // Father's Name
        addLabelAndTextField("Father's Name:", 190, fnameTextField = new JTextField());
        fnameTextField.setToolTipText("Enter your father's full name");

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setToolTipText("Select your date of birth");
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        addRadioButtons(gender, male, female, 290);

        // Email
        addLabelAndTextField("Email:", 340, emailTextField = new JTextField());
        emailTextField.setToolTipText("Enter a valid email address (e.g., example@mail.com)");

        // Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        other = new JRadioButton("Other");
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        married.setBounds(300, 390, 100, 30);
        unmarried.setBounds(450, 390, 120, 30);
        other.setBounds(630, 390, 60, 30);
        setRadioButtonProperties(married, unmarried, other);
        add(married);
        add(unmarried);
        add(other);

        // Address
        addLabelAndTextField("Address:", 440, addressTextField = new JTextField());
        addressTextField.setToolTipText("Enter your current residential address");

        // City
        addLabelAndTextField("City:", 490, cityTextField = new JTextField());
        cityTextField.setToolTipText("Enter the name of your city");

        // State
        addLabelAndTextField("State:", 540, stateTextField = new JTextField());
        stateTextField.setToolTipText("Enter the name of your state");

        // Pin Code
        addLabelAndTextField("Pin Code:", 590, pincodeTextField = new JTextField());
        pincodeTextField.setToolTipText("Enter a 6-digit Pin Code");

        // Next Button
        next = createButton("NEXT", 620, 660);
        next.addActionListener(this);
        add(next);

        // Frame properties
        getContentPane().setBackground(Color.WHITE);
        setSize(820, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    // Method to add labels and text fields
    private void addLabelAndTextField(String labelText, int yPosition, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(100, yPosition, 200, 30);
        add(label);

        textField.setFont(new Font("Raleway", Font.BOLD, 14));
        textField.setBounds(300, yPosition, 400, 30);
        add(textField);
    }

    // Method to add radio buttons
    private void addRadioButtons(JLabel label, JRadioButton option1, JRadioButton option2, int yPosition) {
        label.setBounds(100, yPosition, 200, 30);
        add(label);

        option1.setBounds(300, yPosition, 60, 30);
        option2.setBounds(450, yPosition, 120, 30);
        setRadioButtonProperties(option1, option2);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);

        add(option1);
        add(option2);
    }

    // Set radio button properties
    private void setRadioButtonProperties(JRadioButton... buttons) {
        for (JRadioButton button : buttons) {
            button.setBackground(Color.WHITE);
        }
    }

    // Method to create a button
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 80, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Raleway", Font.BOLD, 14));
        return button;
    }

    // Validation methods
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private boolean isValidPincode(String pincode) {
        return pincode.matches("\\d{6}");
    }

    private boolean isValidDate(String date) {
        return date != null && !date.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = " " + random;
        String name = nameTextField.getText().trim();
        String fname = fnameTextField.getText().trim();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().trim();
        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : null;
        String email = emailTextField.getText().trim();
        String marital = married.isSelected() ? "Married" : unmarried.isSelected() ? "Unmarried" : other.isSelected() ? "Other" : null;
        String address = addressTextField.getText().trim();
        String city = cityTextField.getText().trim();
        String state = stateTextField.getText().trim();
        String pincode = pincodeTextField.getText().trim();

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }
            if (!isValidDate(dob)) {
                JOptionPane.showMessageDialog(null, "Please select a valid Date of Birth");
                return;
            }
            if (!isValidPincode(pincode)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 6-digit Pin Code");
                return;
            }
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                return;
            }

            Conn c = new Conn();
            String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, marital, address, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query);
            pstmt.setString(1, formno);
            pstmt.setString(2, name);
            pstmt.setString(3, fname);
            pstmt.setString(4, dob);
            pstmt.setString(5, gender);
            pstmt.setString(6, email);
            pstmt.setString(7, marital);
            pstmt.setString(8, address);
            pstmt.setString(9, city);
            pstmt.setString(10, state);
            pstmt.setString(11, pincode);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sign Up Successfully");
            
            new SignupTwo(formno).setVisible(true);
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
