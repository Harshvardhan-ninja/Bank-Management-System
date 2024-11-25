package bank.management.system;

import java.sql.*;

/**
 * Database connection utility for the Bank Management System
 * 
 * @author HARSHVARDHAN
 */
public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Securely fetch database credentials
            String url = "jdbc:mysql:///bankmanagementsystem";
            String user = System.getenv("DB_USER"); // Use "root" as a fallback
            String password = System.getenv("DB_PASSWORD"); // Use a fallback password if needed

            if (user == null || password == null) {
                user = "root";
                password = "Harshvardhan@26";
            }

            // Establish connection
            c = DriverManager.getConnection(url, user, password);
            s = c.createStatement();
            
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    // Method to close the connection
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.out.println("Error while closing database connection: " + e.getMessage());
        }
    }
}

//1. register driver
//2. creata connection 
//3. create statement 
//4. execute query 
// 5. close connection