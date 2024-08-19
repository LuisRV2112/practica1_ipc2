package org.example.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDb {
    private Connection connection = null;
    private final String dbUrl = "jdbc:mysql://localhost/banco";
    private final String dbUser = "root";
    private final String dbPassword = "Boik@1775.";

    public Connection getConnection (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("se conectó a la base de datos");
            return connection;
        } catch (SQLException | ClassNotFoundException ex){
            System.out.println("no se pudo conectar a la base de datos");
            ex.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("log: connection closed");
            } catch (SQLException se) {
                System.out.println("log: error on closing connection: "+se);
                se.printStackTrace();
            }
        }
    }
}
