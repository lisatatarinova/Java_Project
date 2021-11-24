package main.java.menu.dbSideWork;

import main.java.domain.Client;

import java.sql.*;

public class ConnectionSource{
    public static Connection getConnection() throws SQLException {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarRental",
                    "root",
                    "rootroot");
        }  catch (SQLException  e) {
            System.out.println("Ошибка соединения: "+e.getMessage() + " "+e.getStackTrace());
        }

        return con;
    }
}
