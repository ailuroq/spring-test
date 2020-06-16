package com.example.demo.logic.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Base {

    // JDBC URL, username and password of MySQL server
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/pupils";
    private static final String user = "myuser";
    private static final String password = "mypass";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement statement;
    private static ResultSet rs;

    public void base(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "myuser";
        String password = "mypass";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {

            if (rs.next()) {
                System.out.println(rs.getString("firstname"));
            }

        } catch (SQLException e) {


        }

    }

}
