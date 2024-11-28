/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;


/**
 *
 * @author HARSHVARDHAN
 */

public class Withdrawal extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawal(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/ATM_page.jpg"));
        Image i2 = atm.getImage().getScaledInstance(972, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 972, 790);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 240, 700, 35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(230, 280, 300, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(430, 360, 90, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(430, 400, 90, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(972, 790);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);

}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else {
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Withdrawal("");
    }
}
