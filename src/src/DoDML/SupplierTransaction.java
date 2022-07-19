package DoDML;

import Objects.ItemsObj;
import Objects.SupplierInformationObj;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.DatabaseHandler;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class SupplierTransaction extends java.awt.Dialog {

    public SupplierTransaction(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initDateEditor(jDateChooser1);
        
        // fill combo boxes with thes
        getSuppliersNames(supplierNameCB);
        getItemID(itemidCB);
        
        AutoCompleteDecorator.decorate(supplierNameCB);
        AutoCompleteDecorator.decorate(itemidCB);
    }
    
    String oldRecieiptNumber;
    JTextFieldDateEditor jtde;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        recieiptNumberTXT1 = new javax.swing.JTextField();
        recieiptPriceTXT2 = new javax.swing.JTextField();
        IcountTXT3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        supplierNameCB = new javax.swing.JComboBox();
        itemidCB = new javax.swing.JComboBox();
        cardPanel = new javax.swing.JPanel();
        insertPanel = new javax.swing.JPanel();
        insertBTN = new javax.swing.JButton();
        updatePanel = new javax.swing.JPanel();
        updateBTN1 = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        s = new javax.swing.JCheckBox();
        xl = new javax.swing.JCheckBox();
        m = new javax.swing.JCheckBox();
        l = new javax.swing.JCheckBox();
        xx = new javax.swing.JCheckBox();
        xxx = new javax.swing.JCheckBox();
        xxxx = new javax.swing.JCheckBox();
        xxxxx = new javax.swing.JCheckBox();

        setResizable(false);
        setTitle("Update Supplier Transaction...");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Item ID: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Supplier Name: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Recieipt Number: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Recieipt Price: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Count: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Date: ");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        supplierNameCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "ggg", "hhhh", "jjj", "eeee" }));

        itemidCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cardPanel.setLayout(new java.awt.CardLayout());

        insertBTN.setText("Submit");
        insertBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
        insertPanel.setLayout(insertPanelLayout);
        insertPanelLayout.setHorizontalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(insertBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertBTN)
                .addContainerGap())
        );

        cardPanel.add(insertPanel, "card2");

        updateBTN1.setText("Submit");
        updateBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTN1ActionPerformed(evt);
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
                .addGap(39, 39, 39)
                .addComponent(updateBTN1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBTN1)
                    .addComponent(deleteBTN))
                .addContainerGap())
        );

        cardPanel.add(updatePanel, "card2");

        s.setText("s");

        xl.setSelected(true);
        xl.setText("xl");

        m.setSelected(true);
        m.setText("m");

        l.setSelected(true);
        l.setText("l");

        xx.setSelected(true);
        xx.setText("xx");

        xxx.setText("xxx");

        xxxx.setText("xxxx");

        xxxxx.setText("xxxxx");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(s)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xxx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xxxx)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xxxxx)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s)
                    .addComponent(m)
                    .addComponent(l)
                    .addComponent(xl)
                    .addComponent(xxx)
                    .addComponent(xxxx)
                    .addComponent(xx)
                    .addComponent(xxxxx))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(supplierNameCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(itemidCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recieiptNumberTXT1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22)
                        .addComponent(recieiptPriceTXT2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IcountTXT3, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemidCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recieiptNumberTXT1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recieiptPriceTXT2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IcountTXT3)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(206, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initDateEditor(JDateChooser at) {
        //Start Code
        jtde = (JTextFieldDateEditor) at.getDateEditor();
        jtde.setEditable(false);
        jtde.setDate(new java.util.Date());
    }
    
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    ArrayList<String> stringList;
    ArrayList<String> valuesList;
    String columnsNames;
    String values;
    
    ArrayList<JCheckBox> cbArr;
    void getCheckBoxes() {
        
        cbArr = new ArrayList<>();
        
        cbArr.add(s);
        cbArr.add(m);
        cbArr.add(l);
        cbArr.add(xl);
        cbArr.add(xx);
        cbArr.add(xxx);
        cbArr.add(xxxx);
        cbArr.add(xxxxx);
    }
    
    public String getColumnNamesAndValues(int count) {
        stringList = new ArrayList<>();
        valuesList = new ArrayList<>();
        
        getCheckBoxes();
        
        for (int i = 0; i < cbArr.size(); i++) {
            if (cbArr.get(i).isSelected()) {
                stringList.add(cbArr.get(i).getText());
                
                valuesList.add(Integer.toString(count));
            }    
        }       
        
        columnsNames = String.join(", ", stringList);
        values = String.join(", ", valuesList); 
        
        return String.join("/", columnsNames, values);
    }
    
    String sizes;
    private void insertBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBTNActionPerformed
        // TODO add your handling code here:
        try {
            
            sizes = getColumnNamesAndValues(Integer.parseInt(IcountTXT3.getText()));
        
            if (sizes.equals("/")) {
                JOptionPane.showMessageDialog(this, "at least select one size...", "error", 0);
                return;
            }
            
            new DatabaseHandler()
                .insertSupplierTransaction(
                    supplierNameCB.getSelectedItem().toString(),
                    recieiptNumberTXT1.getText(),
                    Integer.parseInt(recieiptPriceTXT2.getText()),
                    itemidCB.getSelectedItem().toString(),
                    Integer.parseInt(IcountTXT3.getText()),
                    ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText(),
                    sizes);

            new DatabaseHandler()
                    .insertSizes(itemidCB.getSelectedItem().toString(), 
                    recieiptNumberTXT1.getText(), 
                    sizes.split("/")[0], 
                    sizes.split("/")[1]);
            
            JOptionPane.showMessageDialog(null, "transaction inserted successfully..");
            
            recieiptNumberTXT1.setText("");
            recieiptPriceTXT2.setText("");
            
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "error", 0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "error", 0);
        } finally {
            new DatabaseHandler().closeConnection();
        }
    }//GEN-LAST:event_insertBTNActionPerformed

    private void updateBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTN1ActionPerformed
        // TODO add your handling code here:
        try {
            new DatabaseHandler()
            .updateSupplierTransaction(
                    recieiptNumberTXT1.getText(),
                    supplierNameCB.getSelectedItem().toString(),
                    itemidCB.getSelectedItem().toString(),
                    ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText(),
                    Integer.parseInt(recieiptPriceTXT2.getText()),
                    Integer.parseInt(IcountTXT3.getText()),
                    oldRecieiptNumber);
            
            this.closeDialog(null);
                    
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "erroe", 0);
        }
    }//GEN-LAST:event_updateBTN1ActionPerformed

    int response;
    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        // TODO add your handling code here:
        response = JOptionPane.showConfirmDialog(this, "are you sure that you wanna delete it..", "confirm message", 0);

        if(response == 0) {
            new DatabaseHandler()
                .deleteSupplierTransaction(recieiptNumberTXT1.getText());
            
            new DatabaseHandler()
                .deleteSizes(recieiptNumberTXT1.getText());
            
            this.closeDialog(null);
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    
    ArrayList<Object> arr;
    void getSuppliersNames(JComboBox cb) {
        arr = new ArrayList<>();
        
        cb.removeAllItems();
        
        new DatabaseHandler().getSuppliersInformations(arr, "");
        
        for(int i = 0; i < arr.size(); i++) {    
            cb.addItem(((SupplierInformationObj)arr.get(i)).getName());
        } 
    }
    
    void getItemID(JComboBox cb) {
        arr = new ArrayList<>();
        
        cb.removeAllItems();
        
        new DatabaseHandler().getItems(arr, "where status='Active'");
        
        for(int i = 0; i < arr.size(); i++) {
            cb.addItem(((ItemsObj)arr.get(i)).getId());
        } 
    }
    
    public void inflateUI(String supplierName, String itemId, String recieiptNumber,Date date, int recieiptPrice, int count) {

        recieiptNumberTXT1.setEnabled(false);
        supplierNameCB.setEnabled(false);
        itemidCB.setEnabled(false);
        IcountTXT3.setEnabled(false);
        
        oldRecieiptNumber = recieiptNumber;
        
        supplierNameCB.setSelectedItem(supplierName);
        itemidCB.setSelectedItem(itemId);
        recieiptNumberTXT1.setText(recieiptNumber);
        jDateChooser1.setDate(date);
        recieiptPriceTXT2.setText(Integer.toString(recieiptPrice));
        IcountTXT3.setText(Integer.toString(count));
        

        dialogInitialization();
    }
    
    public void dialogInitialization() {
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.dispose();
    }
    
    public JPanel getCardPanel() {
        return cardPanel;
    }

    public JPanel getInsertPanel() {
        return insertPanel;
    }

    public JPanel getUpdatePanel() {
        return updatePanel;
    }

    public JTextField getIcountTXT3() {
        return IcountTXT3;
    }

    public JComboBox getIsupplierNameCB() {
        return supplierNameCB;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SupplierTransaction dialog = new SupplierTransaction(new java.awt.Frame(), true);
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
    private javax.swing.JTextField IcountTXT3;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton insertBTN;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JComboBox itemidCB;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JCheckBox l;
    private javax.swing.JCheckBox lCheckBox4;
    private javax.swing.JCheckBox m;
    private javax.swing.JCheckBox mCheckBox3;
    private javax.swing.JTextField recieiptNumberTXT1;
    private javax.swing.JTextField recieiptPriceTXT2;
    private javax.swing.JCheckBox s;
    private javax.swing.JCheckBox sCheckBox1;
    private javax.swing.JButton submitBTN;
    private javax.swing.JComboBox supplierNameCB;
    private javax.swing.JButton updateBTN1;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JCheckBox x2CheckBox5;
    private javax.swing.JCheckBox x3CheckBox6;
    private javax.swing.JCheckBox x4CheckBox7;
    private javax.swing.JCheckBox x5CheckBox8;
    private javax.swing.JCheckBox xl;
    private javax.swing.JCheckBox xlCheckBox2;
    private javax.swing.JCheckBox xx;
    private javax.swing.JCheckBox xxx;
    private javax.swing.JCheckBox xxxx;
    private javax.swing.JCheckBox xxxxx;
    // End of variables declaration//GEN-END:variables
}
