/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.adingrt.cliente.caja;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Adin Rubio
 */
public class ProductoPanel extends javax.swing.JPanel {

    public JButton getBtnAgregarItem() {
        return btnAgregarItem;
    }

    public void setBtnAgregarItem(JButton btnAgregarItem) {
        this.btnAgregarItem = btnAgregarItem;
    }

    public JLabel getLblDescripcionProducto() {
        return lblDescripcionProducto;
    }

    public void setLblDescripcionProducto(JLabel lblDescripcionProducto) {
        this.lblDescripcionProducto = lblDescripcionProducto;
    }

    public JLabel getLblPrecioProducto() {
        return lblPrecioProducto;
    }

    public void setLblPrecioProducto(JLabel lblPrecioProducto) {
        this.lblPrecioProducto = lblPrecioProducto;
    }

    public JPanel getPanelProductoImg() {
        return panelProductoImg;
    }

    public void setPanelProductoImg(JPanel panelProductoImg) {
        this.panelProductoImg = panelProductoImg;
    }

    /**
     * Creates new form ProductoPanel
     */
    public ProductoPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarItem = new javax.swing.JButton();
        btnQuitarItem = new javax.swing.JButton();
        panelProductoImg = new javax.swing.JPanel();
        lblDescripcionProducto = new javax.swing.JLabel();
        lblPrecioProducto = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(20, 20));
        setPreferredSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(50, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregarItem.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarItem.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarItem.setText("AGREGAR");
        btnAgregarItem.setMaximumSize(new java.awt.Dimension(0, 0));
        btnAgregarItem.setMinimumSize(new java.awt.Dimension(0, 0));
        btnAgregarItem.setPreferredSize(new java.awt.Dimension(0, 0));
        btnAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarItem);

        btnQuitarItem.setBackground(new java.awt.Color(204, 204, 204));
        btnQuitarItem.setForeground(new java.awt.Color(0, 0, 0));
        btnQuitarItem.setText("QUITAR");
        btnQuitarItem.setMaximumSize(new java.awt.Dimension(0, 0));
        btnQuitarItem.setMinimumSize(new java.awt.Dimension(0, 0));
        btnQuitarItem.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.add(btnQuitarItem);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        panelProductoImg.setBackground(new java.awt.Color(102, 102, 102));
        panelProductoImg.setForeground(new java.awt.Color(255, 255, 255));
        panelProductoImg.setMaximumSize(new java.awt.Dimension(0, 0));
        panelProductoImg.setPreferredSize(new java.awt.Dimension(0, 0));
        panelProductoImg.setLayout(new java.awt.GridLayout(1, 0));

        lblDescripcionProducto.setBackground(new java.awt.Color(102, 102, 102));
        lblDescripcionProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcionProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcionProducto.setText("PRODUCTO");
        lblDescripcionProducto.setMaximumSize(new java.awt.Dimension(0, 0));
        lblDescripcionProducto.setMinimumSize(new java.awt.Dimension(0, 0));
        lblDescripcionProducto.setPreferredSize(new java.awt.Dimension(0, 0));
        panelProductoImg.add(lblDescripcionProducto);

        lblPrecioProducto.setBackground(new java.awt.Color(102, 102, 102));
        lblPrecioProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioProducto.setText("PRECIO");
        lblPrecioProducto.setMaximumSize(new java.awt.Dimension(0, 0));
        lblPrecioProducto.setMinimumSize(new java.awt.Dimension(0, 0));
        lblPrecioProducto.setPreferredSize(new java.awt.Dimension(0, 0));
        panelProductoImg.add(lblPrecioProducto);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        jPanel1.add(panelProductoImg, gridBagConstraints);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarItem;
    private javax.swing.JButton btnQuitarItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDescripcionProducto;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JPanel panelProductoImg;
    // End of variables declaration//GEN-END:variables
}
