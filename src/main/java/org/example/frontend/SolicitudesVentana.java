package org.example.frontend;

import org.example.modelos.Solicitud;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author boika_fire
 */
public class SolicitudesVentana extends javax.swing.JInternalFrame {

    /**
     * Creates new form solicitudes
     */
    public SolicitudesVentana() {
        initComponents();
    }

    public void actualizarSolicitudes(List<Solicitud> elementosNuevos) {
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            for (int j = 0; j < this.jTable1.getColumnCount(); j++) {
                this.jTable1.setValueAt("", i, j);
            }
        }
        for (Solicitud sol : elementosNuevos) {
            Object[] fila = {
                    sol.getNombre(),
                    sol.getFecha(),
                    sol.getTipo(),
                    sol.getDireccion()
            };
            ((DefaultTableModel)jTable1.getModel()).addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre ", "Numero", "Fecha", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
