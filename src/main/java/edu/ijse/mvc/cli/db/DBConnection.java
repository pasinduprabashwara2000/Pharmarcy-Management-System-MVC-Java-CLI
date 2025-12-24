package edu.ijse.mvc.cli.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static DBConnection dbConnection;
    public Connection connection;

    final private String URL = "jdbc:mysql://localhost:3306/pharmacy";
    final private String USERNAME = "root";
    final private String PASSWORD = "mysql";

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
