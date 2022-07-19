/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package DoDML;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.DatabaseHandler;

/**
 *
 * @author salah
 */
public class Customer extends java.awt.Dialog {

    /**
     * Creates new form Customer
     */
    public Customer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    String oldName;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameTXT = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        phoneNumbersTXT = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        AddressTXT = new javax.swing.JTextArea();
        jCheckBox2 = new javax.swing.JCheckBox();
        cardPanel2 = new javax.swing.JPanel();
        insertPanel2 = new javax.swing.JPanel();
        insertBTN2 = new javax.swing.JButton();
        updatePanel = new javax.swing.JPanel();
        updateBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();

        setResizable(false);
        setTitle("Insert Customer...");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Phone Numbers: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name:  ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Address: ");

        phoneNumbersTXT.setColumns(20);
        phoneNumbersTXT.setRows(5);
        jScrollPane4.setViewportView(phoneNumbersTXT);

        AddressTXT.setColumns(20);
        AddressTXT.setRows(5);
        jScrollPane5.setViewportView(AddressTXT);

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Active");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        cardPanel2.setLayout(new java.awt.CardLayout());

        insertBTN2.setText("Submit");
        insertBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBTN2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insertPanel2Layout = new javax.swing.GroupLayout(insertPanel2);
        insertPanel2.setLayout(insertPanel2Layout);
        insertPanel2Layout.setHorizontalGroup(
            insertPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertBTN2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        insertPanel2Layout.setVerticalGroup(
            insertPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertBTN2)
                .addContainerGap())
        );

        cardPanel2.add(insertPanel2, "card2");

        updateBTN.setText("Submit");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        deleteBTN.setText("Delete");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteBTN)
                .addGap(18, 18, 18)
                .addComponent(updateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBTN)
                    .addComponent(deleteBTN))
                .addContainerGap())
        );

        cardPanel2.add(updatePanel, "card2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTXT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addContainerGap(439, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cardPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addComponent(jLabel5))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addContainerGap(200, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(181, Short.MAX_VALUE)
                    .addComponent(cardPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    private void insertBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBTN2ActionPerformed
        // TODO add your handling code here:
        new DatabaseHandler()
            .insertCustomer(
                    nameTXT.getText(), 
                    phoneNumbersTXT.getText(), 
                    AddressTXT.getText(), 
                    jCheckBox2.getText());

        nameTXT.setText("");
        phoneNumbersTXT.setText("");
        AddressTXT.setText("");
    }//GEN-LAST:event_insertBTN2ActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        // TODO add your handling code here:
        new DatabaseHandler()
            .updateCustomer(
                    nameTXT.getText(), 
                    phoneNumbersTXT.getText(),
                    AddressTXT.getText(), 
                    jCheckBox2.getText(),
                    oldName);

        this.closeDialog(null);
    }//GEN-LAST:event_updateBTNActionPerformed

    int response;
    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        response = JOptionPane.showConfirmDialog(this, "are you sure that you wanna delete it..", "confirm message", 0);

        if(response == 0) {
            new DatabaseHandler()
                .deleteCustomer(oldName);

            this.closeDialog(null);
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    public void inflateUI(String name, String phoneNumbers, String address, String status) {
        
        oldName = name;
        
        jCheckBox2.setText(status);
        if(jCheckBox2.getText() == "Active")
            jCheckBox2.setSelected(true);
        else
            jCheckBox2.setSelected(false);
            
        nameTXT.setText(name);
        phoneNumbersTXT.setText(phoneNumbers);
        AddressTXT.setText(address);
        
        dialogInitialization();
    }
    
    public void dialogInitialization() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
//        this.dispose();
    }
    
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox2.getText() == "Active")
            jCheckBox2.setText("InActive");
        else
            jCheckBox2.setText("Active");
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    public JPanel getInsertPanel2() {
        return insertPanel2;
    }

    public JPanel getUpdatePanel() {
        return updatePanel;
    }

    public JPanel getCardPanel2() {
        return cardPanel2;
    }

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer dialog = new Customer(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AddressTXT;
    private javax.swing.JPanel cardPanel2;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton insertBTN2;
    private javax.swing.JPanel insertPanel2;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JTextArea phoneNumbersTXT;
    private javax.swing.JButton updateBTN;
    private javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables
}
