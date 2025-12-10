/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tallerreparacioncelular.JFames;
import com.mycompany.tallerreparacioncelular.entidades.ClientesEntidad;

import com.mycompany.tallerreparacioncelular.Controlador.ClientesControlador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorda
 */
public class Clientes extends javax.swing.JPanel {

    private final ClientesControlador controller = new ClientesControlador();
    private DefaultTableModel modeloTabla; 
    private String cedulaSeleccionada = null; 
    
    
    private void inicializarModuloClientes() {
    // 1) Modelo de tabla con encabezados
    modeloTabla = new DefaultTableModel(
        new Object[]{"Cédula", "Nombres", "Dirección", "Celular", "Correo"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // no editar directo en tabla
        }
    };
    tablaDatos.setModel(modeloTabla);

    // 2) Estado inicial de botones
    btnActualizarCliente.setEnabled(false);
    btnEliminar.setEnabled(false);

    // (opcional) si quieres que cédula no se edite cuando seleccionas fila
    // cedulaCampo.setEnabled(true);

    // 3) Cargar datos precargados en tabla
    cargarTabla(controller.listar());

    // 4) Listener de selección de tabla
    tablaDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) return;
            onTablaSeleccionChanged();
        }
    });
}
    
    
    private void cargarTabla(List<ClientesEntidad> lista) {
    modeloTabla.setRowCount(0);
    for (ClientesEntidad c : lista) {
        modeloTabla.addRow(new Object[]{
            c.getCedula(),
            c.getNombresCompletos(),
            c.getDireccion(),
            c.getCelular(),
            c.getCorreo()
        });
    }
}

private void limpiarCampos() {
    cedulaCampo.setText("");
    nombresCampo.setText("");
    direccionCampo.setText("");
    celularCampo.setText("");
    correoCampo.setText("");

    cedulaSeleccionada = null;
    btnActualizarCliente.setEnabled(false);
    btnEliminar.setEnabled(false);

    // cedulaCampo.setEnabled(true);
    tablaDatos.clearSelection();
}

private boolean camposLlenos() {
    return !cedulaCampo.getText().trim().isEmpty()
        && !nombresCampo.getText().trim().isEmpty()
        && !direccionCampo.getText().trim().isEmpty()
        && !celularCampo.getText().trim().isEmpty()
        && !correoCampo.getText().trim().isEmpty();
}

private void onTablaSeleccionChanged() {
    int row = tablaDatos.getSelectedRow();
    if (row < 0) {
        limpiarCampos();
        return;
    }

    // leer valores de la fila
    String cedula = String.valueOf(modeloTabla.getValueAt(row, 0));
    String nombres = String.valueOf(modeloTabla.getValueAt(row, 1));
    String direccion = String.valueOf(modeloTabla.getValueAt(row, 2));
    String celular = String.valueOf(modeloTabla.getValueAt(row, 3));
    String correo = String.valueOf(modeloTabla.getValueAt(row, 4));

    // llenar campos
    cedulaCampo.setText(cedula);
    nombresCampo.setText(nombres);
    direccionCampo.setText(direccion);
    celularCampo.setText(celular);
    correoCampo.setText(correo);

    // guardar cédula seleccionada para actualizar/eliminar
    cedulaSeleccionada = cedula;

    // activar botones
    btnActualizarCliente.setEnabled(true);
    btnEliminar.setEnabled(true);

    // (opcional) bloquear edición de cédula para que no cambie el "ID"
    // cedulaCampo.setEnabled(false);
}


    public Clientes() {
        initComponents();
        inicializarModuloClientes();
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
        correoCampo = new javax.swing.JTextField();
        cedulaCampo = new javax.swing.JTextField();
        nombresCampo = new javax.swing.JTextField();
        direccionCampo = new javax.swing.JTextField();
        celularCampo = new javax.swing.JTextField();
        btnActualizarCliente = new javax.swing.JButton();
        buscarClienteCampo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("PANEL DE CLIENTES");

        jLabel2.setText("Nombres Completos:");

        jLabel3.setText("Cedula:");

        jLabel4.setText("Dirección: ");

        jLabel5.setText("Celular: ");

        jLabel6.setText("Correo: ");

        direccionCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionCampoActionPerformed(evt);
            }
        });

        btnActualizarCliente.setText("ACTUALIZAR CLIENTE");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Dirección", "Celular", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setText("REGISTRAR CLIENTE");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre del cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cedulaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombresCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(direccionCampo))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(correoCampo)
                            .addComponent(celularCampo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnActualizarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarCliente)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buscarClienteCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btnBuscar)))
                        .addGap(73, 73, 73))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(453, 453, 453))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(986, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarClienteCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombresCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(direccionCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(celularCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(correoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarCliente)
                            .addComponent(btnRegistrarCliente)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(jLabel3)
                    .addContainerGap(470, Short.MAX_VALUE)))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void direccionCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionCampoActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        try {
        if (cedulaSeleccionada == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un cliente de la tabla para actualizar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!camposLlenos()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos deben estar llenos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClientesEntidad nuevosDatos = new ClientesEntidad(
            cedulaSeleccionada, // no permitir cambiar cédula
            nombresCampo.getText().trim(),
            direccionCampo.getText().trim(),
            celularCampo.getText().trim(),
            correoCampo.getText().trim()
        );

        controller.actualizar(cedulaSeleccionada, nuevosDatos);

        cargarTabla(controller.listar());
        limpiarCampos();

        JOptionPane.showMessageDialog(this,
                "Cliente actualizado correctamente.",
                "OK", JOptionPane.INFORMATION_MESSAGE);

    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        try {
        if (!camposLlenos()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos deben estar llenos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ClientesEntidad nuevo = new ClientesEntidad(
            cedulaCampo.getText().trim(),
            nombresCampo.getText().trim(),
            direccionCampo.getText().trim(),
            celularCampo.getText().trim(),
            correoCampo.getText().trim()
        );

        controller.registrar(nuevo);

        cargarTabla(controller.listar());
        limpiarCampos();

        JOptionPane.showMessageDialog(this,
                "Cliente registrado correctamente.",
                "OK", JOptionPane.INFORMATION_MESSAGE);

    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         try {
        String q = buscarClienteCampo.getText().trim();
        List<ClientesEntidad> resultado = controller.buscarPorNombre(q);
        cargarTabla(resultado);

        // Si haces una búsqueda, deselecciona (por seguridad)
        limpiarCampos();

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al buscar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
        if (cedulaSeleccionada == null) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un cliente de la tabla para eliminar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int op = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que deseas eliminar este cliente?\nCédula: " + cedulaSeleccionada,
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (op != JOptionPane.YES_OPTION) return;

        controller.eliminar(cedulaSeleccionada);

        cargarTabla(controller.listar());
        limpiarCampos();

        JOptionPane.showMessageDialog(this,
                "Cliente eliminado correctamente.",
                "OK", JOptionPane.INFORMATION_MESSAGE);

    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JTextField buscarClienteCampo;
    private javax.swing.JTextField cedulaCampo;
    private javax.swing.JTextField celularCampo;
    private javax.swing.JTextField correoCampo;
    private javax.swing.JTextField direccionCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombresCampo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
