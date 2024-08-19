package org.example;

import org.example.frontend.Principal;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Principal principal = new Principal();
        principal.setVisible(true);
        
//        ConexionDb cxdb = new ConexionDb();
//
//        Connection cnn = cxdb.getConnection();
//
//        var pS = cnn.prepareStatement("select * from solicitudes");
//        var rs = pS.executeQuery();
//
//        ResultSetMetaData metadata = rs.getMetaData();
//        int columnCount = metadata.getColumnCount();
//        for (int i = 1; i <= columnCount; i++) {
//            System.out.print(metadata.getColumnName(i) + ", ");//determina el nombre de la columna
//        }
//        System.out.println();
//        while (rs.next()) {
//            String row = "";
//            for (int i = 1; i <= columnCount; i++) {
//                row += rs.getString(i) + ", ";
//            }
//            System.out.println();
//            System.out.print(row);
//        }
    }
}