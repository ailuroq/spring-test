package com.example.demo.logic.user;

import java.sql.*;
import java.util.Scanner;

public class User {

    private int id;
    private double balance;
    private double loanBalance;
    private String password;
    private String mail;
    private String firstName;
    private String lastName;
    private boolean credit;

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public boolean isCredit() {
        return credit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void signUp(String firstName, String lastName, String mail, String password) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "myuser";
        String pass = "mypass";
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mail = mail;

        Connection con = DriverManager.getConnection(url, user, pass);
        Statement statement = con.createStatement();
        statement = con.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT * FROM users");

        PreparedStatement statement1 = con.prepareStatement("INSERT INTO users VALUES (nextval('users_id_seq'),?,?,?,?,?,?,?)");
        statement1.setString(1, firstName);
        statement1.setString(2, lastName);
        statement1.setString(3, mail);
        statement1.setString(4, password);
        statement1.setInt(5, 0);
        statement1.setInt(6, 0);
        statement1.setInt(7, 0);
        statement1.executeUpdate();

        return;


    }


}
