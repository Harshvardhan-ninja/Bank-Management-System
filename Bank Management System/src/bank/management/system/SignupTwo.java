package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * 
 * @author HARSHVARDHAN
 */
public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religionCombo, categoryCombo, incomeCombo, eduquaCombo, occupationCombo;
    String formno;

    // Constructor
    public SignupTwo(String formno) {
        this.formno = formno;
        
        setLayout(null);
        setTitle("---- New Account Application Form - Page 2 ----");
        
        JLabel personDetails = new JLabel("Additional Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[] = {"Select", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionCombo = new JComboBox<>(valReligion);
        religionCombo.setBounds(300, 140, 400, 30);
        religionCombo.setBackground(Color.WHITE);
        add(religionCombo);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = {"Select", "General", "OBC", "SC", "ST", "Other"};
        categoryCombo = new JComboBox<>(valCategory);
        categoryCombo.setBounds(300, 190, 400, 30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valIncome[] = {"Select", "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeCombo = new JComboBox<>(valIncome);
        incomeCombo.setBounds(300, 240, 400, 30);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        
        String valEduqua[] = {"Select", "Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Other"};
        eduquaCombo = new JComboBox<>(valEduqua);
        eduquaCombo.setBounds(300, 315, 400, 30);
        eduquaCombo.setBackground(Color.WHITE);
        add(eduquaCombo);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 365, 200, 30);
        add(occupation);

        String valOccupation[] = {"Select", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationCombo = new JComboBox<>(valOccupation);
        occupationCombo.setBounds(300, 365, 400, 30);
        occupationCombo.setBackground(Color.WHITE);
        add(occupationCombo);

        JLabel pan = new JLabel("PAN number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 415, 200, 30);
        add(pan);

        // PAN Field
panTextField = new JTextField();
panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
panTextField.setBounds(300, 415, 400, 30);
add(panTextField);

// Add Key Listener for PAN Validation
panTextField.addKeyListener(new KeyAdapter() {
    @Override
    public void keyTyped(KeyEvent e) {
        String text = panTextField.getText();
        if (text.length() >= 10) { // Limit to 10 characters
            e.consume(); // Prevent further typing
        }
    }
});
        
        JLabel aadhar = new JLabel("AADHAR number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 465, 200, 30);
        add(aadhar);

        // AADHAR Field
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 465, 400, 30);
        add(aadharTextField);

        // Add Key Listener for AADHAR Formatting and Validation
        aadharTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            String text = aadharTextField.getText();
        
            // Allow only digits and prevent extra characters
            if (!Character.isDigit(c) || text.length() >= 19) { // 16 digits + 3 spaces
                e.consume(); // Prevent further typing
                return;
            }
        
            // Automatically insert spaces after every 4 digits
            if ((text.replaceAll(" ", "").length() % 4 == 0) && text.length() < 14 && text.length() != 0) {
                aadharTextField.setText(text + " "); // Append space
            }
        }
    });
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 515, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 515, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 515, 120, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
        JLabel existAccount = new JLabel("Existing Account:");
        existAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existAccount.setBounds(100, 565, 200, 30);
        add(existAccount);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 565, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 565, 120, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existAccountGroup = new ButtonGroup();
        existAccountGroup.add(eyes);
        existAccountGroup.add(eno);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(820, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionCombo.getSelectedItem();
        String category = (String) categoryCombo.getSelectedItem();
        String income = (String) incomeCombo.getSelectedItem();
        String eduqua = (String) eduquaCombo.getSelectedItem();
        String occupation = (String) occupationCombo.getSelectedItem();
        String seniorCitizen = syes.isSelected() ? "YES" : sno.isSelected() ? "NO" : null;
        String existAccount = eyes.isSelected() ? "YES" : eno.isSelected() ? "NO" : null;
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        // Validate the Combo Box
        if (religion.equals("Select") || category.equals("Select") || income.equals("Select") ||
                eduqua.equals("Select") || occupation.equals("Select") ||
                seniorCitizen == null || existAccount == null || pan.isEmpty() || aadhar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.");
            return;
        }

        // Validate PAN
        if (pan.isEmpty() || pan.length() != 10) {
            JOptionPane.showMessageDialog(null, "PAN must be exactly 10 characters.");
            return;
        }
    
        // Validate AADHAR
        if (aadhar.isEmpty() || aadhar.length() != 14) {
            JOptionPane.showMessageDialog(null, "AADHAR must be exactly 12 digits.");
            return;
        }
        
        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo (formno, religion, category, income, eduqua, occupation, seniorcitizen, existaccount, pan, aadhar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(query);
            pstmt.setString(1, formno);
            pstmt.setString(2, religion);
            pstmt.setString(3, category);
            pstmt.setString(4, income);
            pstmt.setString(5, eduqua);
            pstmt.setString(6, occupation);
            pstmt.setString(7, seniorCitizen);
            pstmt.setString(8, existAccount);
            pstmt.setString(9, pan);
            pstmt.setString(10, aadhar);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Details saved successfully.");
            setVisible(false);
            // Navigate to SignupThree
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
