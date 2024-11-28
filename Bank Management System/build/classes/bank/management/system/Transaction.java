/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author HARSHVARDHAN
 */
public class Transaction extends JFrame implements ActionListener{

    JButton deposit, withdraw, fastcash, ministate, balenq, pinchange, exit;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/ATM_page.jpg"));
        Image i2 = atm.getImage().getScaledInstance(972, 790, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 972, 790);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(260, 240, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(235, 300, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(385, 300, 130, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(235, 340, 130, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Mini Statement");
        ministate.setBounds(385, 340, 130, 30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(235, 380, 130, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(385, 380, 130, 30);
        balenq.addActionListener(this);
        image.add(balenq);
        
        exit = new JButton("Exit");
        exit.setBounds(425, 420, 90, 20);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(972, 790);
        setLocation(300, 20);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == balenq){
            setVisible(false);
            new BalanceEnq(pinNumber).setVisible(true);
        }else if(ae.getSource() == ministate){
            new MiniState(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transaction("");
    }
}
