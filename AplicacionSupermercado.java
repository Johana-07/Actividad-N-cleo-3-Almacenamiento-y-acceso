
package com.mycompany.aplicacionsupermercado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class AplicacionSupermercado extends javax.swing.JFrame {
    private ListaProductos listaProductos;
    private JTextArea textArea;
   
    public AplicacionSupermercado() {
     listaProductos = new ListaProductos();
        setTitle("Aplicación Supermercado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField codigoField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField cantidadField = new JTextField();
        JTextField precioField = new JTextField();
        JButton agregarButton = new JButton("Agregar");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");
        JButton buscarButton = new JButton("Buscar");
        JButton mostrarButton = new JButton("Mostrar");
        JButton facturaButton = new JButton("Generar Factura");

        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(agregarButton);
        panel.add(modificarButton);
        panel.add(eliminarButton);
        panel.add(buscarButton);
        panel.add(mostrarButton);
        panel.add(facturaButton);

        textArea = new JTextArea();
        textArea.setEditable(false);

        agregarButton.addActionListener((ActionEvent e) -> {
            String codigo = codigoField.getText();
            String nombre = nombreField.getText();
            int cantidad = Integer.parseInt(cantidadField.getText());
            double precio = Double.parseDouble(precioField.getText());
            Producto producto = new Producto(codigo, nombre, cantidad, precio);
            listaProductos.agregarProducto(producto);
            textArea.append("Producto agregado: " + codigo + "\n");
     });
        
        modificarButton.addActionListener((ActionEvent e) -> {
            String codigo = codigoField.getText();
            listaProductos.modificarProducto(codigo, 5); // Incremento del 5%
            textArea.append("Producto modificado: " + codigo + "\n");
     });
        
        eliminarButton.addActionListener((ActionEvent e) -> {
            String codigo = codigoField.getText();
            listaProductos.eliminarProducto(codigo);
            textArea.append("Producto eliminado: " + codigo + "\n");
     });
        
         buscarButton.addActionListener((ActionEvent e) -> {
             String codigo = codigoField.getText();
             Producto producto = listaProductos.buscarProducto(codigo);
             if (producto != null) {
                 textArea.append("Producto encontrado: " + producto.getCodigo() + "\n");
             } else {
                 textArea.append("Producto no encontrado.\n");
             }
     });

        mostrarButton.addActionListener((ActionEvent e) -> {
            textArea.append("Lista de productos:\n");
            listaProductos.mostrarProductos();
     });

        facturaButton.addActionListener((ActionEvent e) -> {
            textArea.append("Factura:\n");
            listaProductos.generarFactura();
     });

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplicacionSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacionSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacionSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacionSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            AplicacionSupermercado app = new AplicacionSupermercado();
            app.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
