package org.example.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Solicitud {
    private int numero;
    private Date fecha;
    private String tipo;
    private String nombre;
    private Double salario;
    private String direccion;

    public Solicitud(int numero, Date fecha, String tipo, String nombre, Double salario, String direccion) {
        this.numero = numero;
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.salario = salario;
        this.direccion = direccion;
    }

    public Solicitud (String[] parametros) {
        this(
                Integer.parseInt(parametros[0]),
                convertirFecha(parametros[1]),
                parametros[2],
                parametros[3].replace("\"", ""),
                Double.parseDouble(parametros[4]),
                parametros[5].replace("\"", "")
        );
    }

    public static Date convertirFecha(String fecha) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String fechaArreglada = fecha.replace("\"", "");

        try {
            return dateFormat.parse(fechaArreglada);
        } catch (ParseException pe) {
            pe.printStackTrace();
            return null;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
