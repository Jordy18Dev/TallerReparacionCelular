package com.mycompany.tallerreparacioncelular.JFames;

/**
 *
 * @author hamilton
 */

import com.mycompany.tallerreparacioncelular.Controlador.ClientesControlador;
import com.mycompany.tallerreparacioncelular.Controlador.EquipoControlador;
import com.mycompany.tallerreparacioncelular.Controlador.ReparacionControlador;
import com.mycompany.tallerreparacioncelular.entidades.ClientesEntidad;
import com.mycompany.tallerreparacioncelular.entidades.EquipoEntidad;
import com.mycompany.tallerreparacioncelular.entidades.ReparacionEntidad;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reparacion extends javax.swing.JPanel {

    // Controladores
    private final ReparacionControlador reparacionControlador = new ReparacionControlador();
    private final ClientesControlador clientesControlador = new ClientesControlador();
    private final EquipoControlador equipoControlador = new EquipoControlador();
    
    private DefaultTableModel modeloTabla;

    public Reparacion() {
        initComponents();
        configurarTabla();
        cargarCombos(); 
        cargarTabla();
    }

    // Configurar las columnas de la tabla
    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(
            new Object[][]{},
            // Columnas: 0=ID, 1=Cliente, 2=Cédula, 3=Equipo, 4=Estado, 5=Costo, 6=Falla
            new String[]{"ID", "Cliente", "Cédula", "Equipo (IMEI)", "Estado", "Costo", "Falla"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaReparaciones.setModel(modeloTabla);
    }

    // Llenar los ComboBox con datos de los otros controladores
    private void cargarCombos() {
        cbClientes.removeAllItems();
        cbEquipos.removeAllItems();
        
        List<ClientesEntidad> listaClientes = clientesControlador.listar();
        for(ClientesEntidad c : listaClientes) {
            // Guardamos "CEDULA - NOMBRE" en el combo
            cbClientes.addItem(c.getCedula() + " - " + c.getNombresCompletos());
        }
        
        List<EquipoEntidad> listaEquipos = equipoControlador.listarTodos();
        for(EquipoEntidad e : listaEquipos) {
            // Guardamos "IMEI - MODELO" en el combo
            cbEquipos.addItem(e.getImei() + " - " + e.getModelo());
        }
    }
    
    // Listar las reparaciones en la tabla
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<ReparacionEntidad> lista = reparacionControlador.listar();
        for(ReparacionEntidad r : lista) {
            modeloTabla.addRow(new Object[]{
                r.getIdReparacion(),
                r.getNombreCliente(), 
                r.getCedulaCliente(),
                r.getImeiEquipo(),
                r.getEstado(),
                r.getCostoEstimado(),
                r.getDescripcionFalla()
            });
        }
    }
    
    // Limpiar formulario
    private void limpiarFormulario() {
        txtIdReparacion.setText("");
        txtFecha.setText("");
        txtFalla.setText("");
        txtCosto.setText("");
        cbEstado.setSelectedIndex(0);
        if(cbClientes.getItemCount() > 0) cbClientes.setSelectedIndex(0);
        if(cbEquipos.getItemCount() > 0) cbEquipos.setSelectedIndex(0);
    }
 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReparaciones = new javax.swing.JTable();
        cbClientes = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFalla = new javax.swing.JTextArea();
        txtIdReparacion = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        cbEquipos = new javax.swing.JComboBox<>();
        cbEstado = new javax.swing.JComboBox<>();
        txtCosto = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("PANEL DE REPARACION");

        jLabel2.setText("ID Reparación:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Descripcion de Falla:");

        jLabel5.setText("Equipo:");

        jLabel6.setText("Estado:");

        jLabel7.setText("Fecha ingreso:");

        jLabel8.setText("Costo Estimado:");

        btnRegistrar.setText("Registrar Reparación");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar Estado");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tablaReparaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaReparaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReparacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaReparaciones);

        txtFalla.setColumns(20);
        txtFalla.setRows(5);
        txtFalla.setAutoscrolls(false);
        jScrollPane3.setViewportView(txtFalla);

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingresado", "En revisión", "Esperando respuesto", "Terminado" }));

        btnEliminar.setText("Eliminar Reparación");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(519, 519, 519))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtIdReparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if(txtIdReparacion.getText().isEmpty() || txtCosto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete ID y Costo obligatoriamente.");
                return;
            }
            
            String clienteSeleccionado = (String) cbClientes.getSelectedItem();
            String equipoSeleccionado = (String) cbEquipos.getSelectedItem();
            
            if(clienteSeleccionado == null || equipoSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Debe haber Clientes y Equipos registrados.");
                return;
            }
            
            // Separamos la Cédula del Nombre. 
            // Formato del combo: "CEDULA - NOMBRE"
            String[] partesCliente = clienteSeleccionado.split(" - ");
            String cedula = partesCliente[0].trim();
            // Si por alguna razón no hay guion, el nombre será igual a la cédula por seguridad
            String nombre = partesCliente.length > 1 ? partesCliente[1].trim() : cedula;
            
            // Separamos IMEI
            String imei = equipoSeleccionado.split(" - ")[0].trim();
            
            ReparacionEntidad nuevaReparacion = new ReparacionEntidad(
                txtIdReparacion.getText(),
                cedula,
                nombre, 
                imei,
                txtFecha.getText(),
                (String) cbEstado.getSelectedItem(),
                txtFalla.getText(),
                Double.parseDouble(txtCosto.getText())
            );
            
            reparacionControlador.registrar(nuevaReparacion);
            cargarTabla();
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Reparación registrada con éxito.");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            String id = txtIdReparacion.getText();
            String estado = (String) cbEstado.getSelectedItem();
            double costo = Double.parseDouble(txtCosto.getText());
            
            reparacionControlador.actualizar(id, estado, costo);
            cargarTabla();
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Reparación actualizada.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
        // 1. Verificamos directamente si hay una fila seleccionada en la tabla
        int filaSeleccionada = tablaReparaciones.getSelectedRow();
        
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una reparación de la tabla para eliminar.");
            return;
        }

        // 2. Obtenemos el ID directamente del modelo de la tabla (Columna 0 es el ID)
        String id = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de eliminar la reparación " + id + "?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            reparacionControlador.eliminar(id);
            cargarTabla();
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Reparación eliminada correctamente.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaReparacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReparacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaReparacionesMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbClientes;
    private javax.swing.JComboBox<String> cbEquipos;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaReparaciones;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextArea txtFalla;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdReparacion;
    // End of variables declaration//GEN-END:variables
}
