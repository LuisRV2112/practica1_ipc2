/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.example.frontend;

import org.example.controladores.SolicitudesControlador;
import org.example.modelos.Solicitud;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author boika_fire
 */
public class Principal extends javax.swing.JFrame {

    private final SolicitudesControlador solicitudesControlador;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        solicitudesControlador = new SolicitudesControlador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        entradaArchivo = new javax.swing.JMenuItem();
        pruebamenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contenedorPrincipalLayout = new javax.swing.GroupLayout(contenedorPrincipal);
        contenedorPrincipal.setLayout(contenedorPrincipalLayout);
        contenedorPrincipalLayout.setHorizontalGroup(
            contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        contenedorPrincipalLayout.setVerticalGroup(
            contenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        entradaArchivo.setText("Archivo de entrada");
        entradaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(entradaArchivo);

        pruebamenu.setText("prueba ");
        pruebamenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebamenuActionPerformed(evt);
            }
        });
        jMenu1.add(pruebamenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner scanner = new Scanner(fileChooser.getSelectedFile());
                scanner.useDelimiter(";");
                while (scanner.hasNext()){
                    String input = scanner.next();
                    int startIndex = input.indexOf('(');
                    int endIndex = input.lastIndexOf(')');

                    // Check if both parentheses are found
                    if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                        // Extract the substring between the parentheses
                        Solicitud solicitud = new Solicitud(input.substring(startIndex + 1, endIndex).split(","));
                        solicitudesControlador.crearSolicitud(solicitud);
//                        System.out.println(Arrays.toString(input.substring(startIndex + 1, endIndex).split(",")));
                    }
                }
            } catch (FileNotFoundException fe){}
        }

    }//GEN-LAST:event_entradaArchivoActionPerformed

    private void pruebamenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebamenuActionPerformed
        SolicitudesVentana ventana = new SolicitudesVentana();
        contenedorPrincipal.add(ventana);
        ventana.actualizarSolicitudes(solicitudesControlador.obtenerSolicitudes());
        ventana.setVisible(true);
    }//GEN-LAST:event_pruebamenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedorPrincipal;
    private javax.swing.JMenuItem entradaArchivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem pruebamenu;
    // End of variables declaration//GEN-END:variables
}
