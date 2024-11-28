package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saveAcc, fixedAcc, currentAcc, reccurAcc;
    JCheckBox atmcard, internetbanking, mobilebanking, emailsms, cheque, estate, correct;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno) {

        this.formno = formno;

        setTitle("---- New Account Application Page - Page 3 ----");
        setLayout(null);

        JLabel l1 = new JLabel("Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Raleway", Font.BOLD, 22));
        accType.setBounds(100, 140, 200, 30);
        add(accType);

        saveAcc = new JRadioButton("Savings Account");
        saveAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        saveAcc.setBackground(Color.WHITE);
        saveAcc.setBounds(100, 180, 250, 20);
        saveAcc.setToolTipText("Select this for a savings account.");
        add(saveAcc);

        fixedAcc = new JRadioButton("Fixed Deposit Account");
        fixedAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedAcc.setBackground(Color.WHITE);
        fixedAcc.setBounds(350, 180, 250, 20);
        fixedAcc.setToolTipText("Select this for a fixed deposit account.");
        add(fixedAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setBounds(100, 220, 250, 20);
        currentAcc.setToolTipText("Select this for a current account.");
        add(currentAcc);

        reccurAcc = new JRadioButton("Recurring Account");
        reccurAcc.setFont(new Font("Raleway", Font.BOLD, 16));
        reccurAcc.setBackground(Color.WHITE);
        reccurAcc.setBounds(350, 220, 250, 20);
        reccurAcc.setToolTipText("Select this for a recurring account.");
        add(reccurAcc);

        ButtonGroup groupAcc = new ButtonGroup();
        groupAcc.add(saveAcc);
        groupAcc.add(fixedAcc);
        groupAcc.add(currentAcc);
        groupAcc.add(reccurAcc);

        JLabel cardType = new JLabel("Card Type :");
        cardType.setFont(new Font("Raleway", Font.BOLD, 22));
        cardType.setBounds(100, 300, 200, 30);
        add(cardType);

        JLabel cardNo = new JLabel("XXXX - XXXX - XXXX - 9702");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNo.setBounds(330, 300, 300, 30);
        add(cardNo);

        JLabel carddetail = new JLabel("Your 16 Digit card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel pin = new JLabel("Pin :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pinNo = new JLabel("XXXX");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNo.setBounds(330, 370, 300, 30);
        add(pinNo);

        JLabel pindetails = new JLabel("Your 4 Digit PIN Number");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Service Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 200, 20);
        add(services);

        atmcard = new JCheckBox("ATM CARD");
        atmcard.setBackground(Color.WHITE);
        atmcard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmcard.setBounds(100, 500, 200, 30);
        add(atmcard);

        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setBackground(Color.WHITE);
        internetbanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetbanking.setBounds(350, 500, 200, 30);
        add(internetbanking);

        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobilebanking.setBounds(100, 550, 200, 30);
        add(mobilebanking);

        emailsms = new JCheckBox("EMAIL & SMS Alert");
        emailsms.setBackground(Color.WHITE);
        emailsms.setFont(new Font("Raleway", Font.BOLD, 16));
        emailsms.setBounds(350, 550, 200, 30);
        add(emailsms);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway", Font.BOLD, 16));
        cheque.setBounds(100, 600, 200, 30);
        add(cheque);

        estate = new JCheckBox("E-Statement");
        estate.setBackground(Color.WHITE);
        estate.setFont(new Font("Raleway", Font.BOLD, 16));
        estate.setBounds(350, 600, 200, 30);
        add(estate);

        correct = new JCheckBox("I hereby declare that the above-entered details are correct to the best of my knowledge.");
        correct.setBackground(Color.WHITE);
        correct.setFont(new Font("Raleway", Font.BOLD, 12));
        correct.setBounds(100, 680, 550, 30);
        add(correct);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (saveAcc.isSelected()) {
                accountType = "Saving Account";
            } else if (fixedAcc.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (currentAcc.isSelected()) {
                accountType = "Current Account";
            } else if (reccurAcc.isSelected()) {
                accountType = "Recurring Account";
            }

            if (accountType == null) {
                JOptionPane.showMessageDialog(null, "Account Type is Required");
                return;
            }

            if (!correct.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please confirm that the details are correct.");
                return;
            }

            Random random = new Random();
            String cardnumber = String.format("%016d", Math.abs(random.nextLong() % 9000000000000000L + 1000000000000000L));
            String pinnumber = String.format("%04d", Math.abs(random.nextInt(9000) + 1000));

            String service = "";
            if (atmcard.isSelected()) service += "ATM CARD, ";
            if (internetbanking.isSelected()) service += "Internet Banking, ";
            if (mobilebanking.isSelected()) service += "Mobile Banking, ";
            if (emailsms.isSelected()) service += "EMAIL & SMS Alert, ";
            if (cheque.isSelected()) service += "Cheque Book, ";
            if (estate.isSelected()) service += "E-Statement, ";
            if (!service.isEmpty()) {
                service = service.substring(0, service.length() - 2); // Remove trailing comma
            }

            try {
                Conn conn = new Conn();
                String query1 = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + service + "')";
                String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Account created successfully.");
                JOptionPane.showMessageDialog(null, "\nCard Number: " + cardnumber + "\nPIN: " + pinnumber);
                conn.s.close();
                
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error saving account details. Please try again.");
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
