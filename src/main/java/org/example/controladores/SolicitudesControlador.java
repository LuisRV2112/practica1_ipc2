package org.example.controladores;

import org.example.modelos.Solicitud;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolicitudesControlador {
    private final Connection connection;

    public SolicitudesControlador() {
        ConexionDb conexionDb = new ConexionDb();
        connection = conexionDb.getConnection();
    }

    public void crearSolicitud(Solicitud solicitud) {
        String sql = "insert into solicitudes (numero, fecha, tipo, nombre, salario, direccion) values (?,?,?,?,?,?)";
        try {
            PreparedStatement consulta = connection.prepareStatement(sql);
            consulta.setInt(1, solicitud.getNumero());
            consulta.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(solicitud.getFecha()));
            consulta.setString(3, solicitud.getTipo());
            consulta.setString(4, solicitud.getNombre());
            consulta.setDouble(5, solicitud.getSalario());
            consulta.setString(6, solicitud.getDireccion());

            Date startTime = new Date();
            consulta.executeUpdate();
            Date endTime = new Date();
            int msElapsedTime = (int) (endTime.getTime() - startTime.getTime());

        } catch (SQLException se){
            JOptionPane.showMessageDialog(null,"No se pudo crear la solicitud, detalles: "+se.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Solicitud> obtenerSolicitudes(){
        String sql = "SELECT * FROM solicitudes";
        List<Solicitud> listaSolicitudes = new ArrayList<>();
        try {
            PreparedStatement consulta = connection.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                Solicitud solicitud = new Solicitud(
                        resultado.getInt("numero"),
                        resultado.getDate("fecha"),
                        resultado.getString("tipo"),
                        resultado.getString("nombre"),
                        resultado.getDouble("salario"),
                        resultado.getString("direccion")
                );
                listaSolicitudes.add(solicitud);
            }

        } catch (SQLException se){

        }
        return listaSolicitudes;
    }
}
