package main;

import Objects.CustomerObj;
import Objects.ItemsObj;
import Objects.SalesObj;
import Objects.SuppliersTransactionsObj;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reports extends java.awt.Dialog {

    DatabaseHandler handler = new DatabaseHandler();
    
    public Reports(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CustomerBTN = new javax.swing.JButton();
        supplierBTN = new javax.swing.JButton();
        itemsBTN = new javax.swing.JButton();
        salesBTN = new javax.swing.JButton();
        from = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        to = new com.toedter.calendar.JDateChooser();
        supplimentTransaction = new javax.swing.JButton();

        setResizable(false);
        setTitle("Reports");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        CustomerBTN.setText("Customers");
        CustomerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerBTNActionPerformed(evt);
            }
        });

        supplierBTN.setText("Suppliers");
        supplierBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBTNActionPerformed(evt);
            }
        });

        itemsBTN.setText("Items");
        itemsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsBTNActionPerformed(evt);
            }
        });

        salesBTN.setText("Sales");
        salesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBTNActionPerformed(evt);
            }
        });

        from.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("From: ");

        jLabel2.setText("To: ");

        to.setDateFormatString("yyyy-MM-dd");

        supplimentTransaction.setText("Supplier Transactions");
        supplimentTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplimentTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemsBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(supplimentTransaction))
                    .addComponent(salesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CustomerBTN)
                        .addComponent(jLabel1))
                    .addComponent(from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(supplierBTN)
                        .addComponent(jLabel2))
                    .addComponent(to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemsBTN)
                    .addComponent(salesBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplimentTransaction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void salesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBTNActionPerformed
        // TODO add your handling code here:
        sales("./data/reports dist/Sales.jrxml");
    }//GEN-LAST:event_salesBTNActionPerformed

    private void itemsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsBTNActionPerformed
        // TODO add your handling code here:
        items("./data/reports dist/items.jrxml");
    }//GEN-LAST:event_itemsBTNActionPerformed

    private void supplierBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBTNActionPerformed
        // TODO add your handling code here:
        suppliersInfo("./data/reports dist/Suppliers.jrxml");
    }//GEN-LAST:event_supplierBTNActionPerformed

    private void CustomerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerBTNActionPerformed
        // TODO add your handling code here:
        customers("./data/reports dist/Customers.jrxml");
    }//GEN-LAST:event_CustomerBTNActionPerformed

    private void supplimentTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplimentTransactionActionPerformed
        // TODO add your handling code here:
        supplierTransactions("./data/reports dist/SupplierTransactions.jrxml");
    }//GEN-LAST:event_supplimentTransactionActionPerformed
    
    JasperReport jr;
    JasperPrint jp;
    HashMap hashMap;
    ArrayList<Object> arr;
    
    void customers(String reportPath) {
        try {
            arr = new ArrayList();

            handler.getCustomers(arr, "");
         
            common(reportPath, CustomerBTN.getText(), arr, 0);
            
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Location OR File Not Found..\n\n" + ex, "Error", 0);
        } finally {

        }
    }
    
    void suppliersInfo(String reportPath) {
        try {
            arr = new ArrayList();

            handler.getSuppliersInformations(arr, "");
         
            common(reportPath, supplierBTN.getText(), arr, 0);
            
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Location OR File Not Found..\n\n" + ex, "Error", 0);
        } finally {

        }
    }
    
    void items(String reportPath) {
        try {
            arr = new ArrayList();

            handler.getItems(arr, "where status='Active'");
         
            common(reportPath, itemsBTN.getText(), arr, 0);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Location OR File Not Found..\n\n" + ex, "Error", 0);
        } finally {

        }
    }
    
    int total;
    void sales(String reportPath) {
        try {
            arr = new ArrayList();

            handler.getSaelsTransactions(
                    arr,
                    ((JTextField)from.getDateEditor().getUiComponent()).getText(),
                    ((JTextField)to.getDateEditor().getUiComponent()).getText());
            
            for (int i = 0; i < arr.size(); i++) {
                total += (((SalesObj)arr.get(i)).getPrice() * ((SalesObj)arr.get(i)).getCount());
            }
         
            common(reportPath, salesBTN.getText(), arr, total);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Location OR File Not Found..\n\n" + ex, "Error", 0);
        } finally {

        }
    }
    
    void supplierTransactions(String reportPath) {
        try {
            arr = new ArrayList();

            handler.getSuppliersTransactions(
                    arr,
                    ((JTextField)from.getDateEditor().getUiComponent()).getText(),
                    ((JTextField)to.getDateEditor().getUiComponent()).getText());
            
            for (int i = 0; i < arr.size(); i++) {
                ((SuppliersTransactionsObj)arr
                        .get(i))
                        .setSizes(((SuppliersTransactionsObj)arr
                                .get(i))
                                .getSizes()
                                .split("/")[0]);
            }

            for (int i = 0; i < arr.size(); i++) {
                total += (((SuppliersTransactionsObj)arr.get(i)).getRecieiptPrice()* ((SuppliersTransactionsObj)arr.get(i)).getCount());
            }
         
            common(reportPath, supplimentTransaction.getText(), arr, total);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Wrong Location OR File Not Found..\n\n" + ex, "Error", 0);
        } finally {

        }
    }
    
    void common(String reportPath, String ReportName, List a, int totoal) throws JRException {
        JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(a);
            
        hashMap = new HashMap();

        hashMap.put("from", ((JTextField)from.getDateEditor().getUiComponent()).getText());
        hashMap.put("to", ((JTextField)to.getDateEditor().getUiComponent()).getText());
        hashMap.put("total", totoal);

        jr = JasperCompileManager.compileReport(reportPath);
        jp = JasperFillManager.fillReport(jr, hashMap, jrbcds);

        JasperExportManager.exportReportToPdfFile(jp, "./reports/" + ReportName + " Report.pdf");

        JOptionPane.showMessageDialog(this, "File Genrated successfully...");
    }
    
    public void dialogInitialization() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JDateChooser getjDateChooser1() {
        return from;
    }

    public JDateChooser getjDateChooser2() {
        return to;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reports dialog = new Reports(new java.awt.Frame(), true);
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
    private javax.swing.JButton CustomerBTN;
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JButton itemsBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salesBTN;
    private javax.swing.JButton supplierBTN;
    private javax.swing.JButton supplimentTransaction;
    private com.toedter.calendar.JDateChooser to;
    // End of variables declaration//GEN-END:variables
}
