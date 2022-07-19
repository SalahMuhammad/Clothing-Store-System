package main;

import CustomItem.GrayScrollBarUI;
import CustomItem.TableButton;
import DoDML.Customer;
import DoDML.Item;
import DoDML.Sales;
import Objects.SupplierInformationObj;
import DoDML.SupplierInformationaa;
import DoDML.SupplierTransaction;
import Objects.CustomerObj;
import Objects.ItemsObj;
import Objects.SalesObj;
import Objects.SuppliersTransactionsObj;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class main extends javax.swing.JFrame {
    
    public main() {
        initComponents();
        
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        
        columnModel = suppliersInfoTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(210);
        
        focusLost(searchForItemTXT);
        focusLost(searchForSupplierNameTXT1);
        focusLost(searchForSupplierTrnsacTXT2);
                

        this.setIconImage(new SplashScreen().icon);
        
        
//        Image icon = Toolkit.getDefaultToolkit().getImage("data/i.dll"); 
//        try {
//            this.setIconImage(icon);
//        
//        Image a = Toolkit.getDefaultToolkit().getImage("data/i.dll").getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon logo = new ImageIcon(a);
//        
//        
//        img.setIcon(logo);
//        } catch (Exception e) {
//            System.out.println();
//            System.exit(1);
//        }
        
        
        setTableRowsTextToCenter();
        setTablesScrollBarToGray();
        modificationJtablesHeader();
        setTablesSelectionToSingleSelection();

        salesBTN1.setBackground(Color.BLUE);

        initDateEditor(fromDateChooser);
        try {
            fromDateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(file.getFileData("./data/ini.dll")));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "error", 0);
        }
        initDateEditor(toDateChooser1);
        
        
        
        status = "where status='Active'";
        searchStatus = "and status='Active'";
        
        
        
        
        
        displayItems(true);
        displaySalesTransactions();
        displayCustomer();
    }
    
    FileReader file = new FileReader();
    
    TableColumnModel columnModel = null;
    
    // ===================
    // jFrames
    // ===================
    // <editor-fold>

    Item item;
    Sales sales;
    SupplierTransaction st;
    SupplierInformationaa si;
    Customer customer;
    Reports reports;
    
    // </editor-fold>
    
    // from utilty library
    TableButton tableButton;
    
    Action doSomeThing;
    
    DefaultTableModel model = null;
    Object[] row;
    
    ArrayList<Object> arr;
    
    long millis = 0;
    
    
    String id;
    String status;
    String searchStatus;
    
    DatabaseHandler handler = new DatabaseHandler();
    
    
    void reWritCardPanel(JPanel cardPanel, JPanel RequiredPanel) {
        
        // Removing the panel
        cardPanel.removeAll();

        //adding panels
        cardPanel.add(RequiredPanel);
        cardPanel.repaint();
        cardPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        categoriesPanel = new javax.swing.JPanel();
        suppliersBTN = new javax.swing.JButton();
        salesBTN1 = new javax.swing.JButton();
        settingBTN = new javax.swing.JButton();
        refreshBTN = new javax.swing.JButton();
        statusBTN = new javax.swing.JButton();
        reportsBTN = new javax.swing.JButton();
        img = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        salesPanel = new javax.swing.JPanel();
        itemsScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        newItemBTN = new javax.swing.JButton();
        salesScrollPane2 = new javax.swing.JScrollPane();
        salesTable2 = new javax.swing.JTable();
        newSalesTBTN = new javax.swing.JButton();
        totalsTable = new javax.swing.JTable();
        searchForItemTXT = new javax.swing.JTextField();
        sizesLabel = new javax.swing.JLabel();
        itemsScrollPane2 = new javax.swing.JScrollPane();
        customersTable = new javax.swing.JTable();
        newCustomerBTN = new javax.swing.JButton();
        suppliresPanel = new javax.swing.JPanel();
        suppliersInfoScrollPane = new javax.swing.JScrollPane();
        suppliersInfoTable = new javax.swing.JTable();
        newSupplierBTN = new javax.swing.JButton();
        suppliersTransScrollPane1 = new javax.swing.JScrollPane();
        suppliersTransaTable1 = new javax.swing.JTable();
        newSupplierTransactionBTN1 = new javax.swing.JButton();
        totalsTable1 = new javax.swing.JTable();
        searchForSupplierNameTXT1 = new javax.swing.JTextField();
        searchForSupplierTrnsacTXT2 = new javax.swing.JTextField();
        settingPanel = new javax.swing.JPanel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setDateBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sport Zone");

        categoriesPanel.setBackground(new java.awt.Color(45, 52, 71));

        suppliersBTN.setBackground(new java.awt.Color(255, 0, 0));
        suppliersBTN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        suppliersBTN.setText("Suppliers");
        suppliersBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersBTNActionPerformed(evt);
            }
        });

        salesBTN1.setBackground(new java.awt.Color(255, 0, 0));
        salesBTN1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        salesBTN1.setText("Sales");
        salesBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBTN1ActionPerformed(evt);
            }
        });

        settingBTN.setBackground(new java.awt.Color(255, 0, 0));
        settingBTN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        settingBTN.setText("Setting");
        settingBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBTNActionPerformed(evt);
            }
        });

        refreshBTN.setBackground(new java.awt.Color(255, 0, 0));
        refreshBTN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        refreshBTN.setText("Reload");
        refreshBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBTNActionPerformed(evt);
            }
        });

        statusBTN.setBackground(new java.awt.Color(255, 0, 0));
        statusBTN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        statusBTN.setText("Display All");
        statusBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBTNActionPerformed(evt);
            }
        });

        reportsBTN.setBackground(new java.awt.Color(255, 0, 0));
        reportsBTN.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        reportsBTN.setText("Reports");
        reportsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
        categoriesPanel.setLayout(categoriesPanelLayout);
        categoriesPanelLayout.setHorizontalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(refreshBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(statusBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(reportsBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addGroup(categoriesPanelLayout.createSequentialGroup()
                        .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salesBTN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(suppliersBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        categoriesPanelLayout.setVerticalGroup(
            categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesPanelLayout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesBTN1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suppliersBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportsBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardPanel.setLayout(new java.awt.CardLayout());

        itemsTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        itemsTable.setForeground(new java.awt.Color(0, 0, 204));
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Discription", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.setRowHeight(35);
        itemsTable.getTableHeader().setReorderingAllowed(false);
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        itemsScrollPane1.setViewportView(itemsTable);

        newItemBTN.setText("New item");
        newItemBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemBTNActionPerformed(evt);
            }
        });

        salesTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        salesTable2.setForeground(new java.awt.Color(0, 0, 204));
        salesTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item ID", "Customer Name", "Size", "Price", "Count", "Date", "Total", "Note", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesTable2.setRowHeight(35);
        salesTable2.getTableHeader().setReorderingAllowed(false);
        salesScrollPane2.setViewportView(salesTable2);

        newSalesTBTN.setText("New Transaction");
        newSalesTBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSalesTBTNActionPerformed(evt);
            }
        });

        totalsTable.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        totalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Total", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "null", "Title 7", "Title 8", "Title 9"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalsTable.setRowHeight(25);

        searchForItemTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchForItemTXT.setToolTipText("");
        searchForItemTXT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchForItemTXTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchForItemTXTFocusLost(evt);
            }
        });
        searchForItemTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForItemTXTKeyReleased(evt);
            }
        });

        sizesLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sizesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        customersTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        customersTable.setForeground(new java.awt.Color(0, 0, 204));
        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customersTable.setRowHeight(35);
        customersTable.getTableHeader().setReorderingAllowed(false);
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersTableMouseClicked(evt);
            }
        });
        itemsScrollPane2.setViewportView(customersTable);

        newCustomerBTN.setText("New Customer");
        newCustomerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomerBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout salesPanelLayout = new javax.swing.GroupLayout(salesPanel);
        salesPanel.setLayout(salesPanelLayout);
        salesPanelLayout.setHorizontalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesScrollPane2)
                    .addComponent(totalsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addComponent(newSalesTBTN)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sizesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesPanelLayout.createSequentialGroup()
                                .addComponent(itemsScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchForItemTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(itemsScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(salesPanelLayout.createSequentialGroup()
                                        .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(newItemBTN)
                                            .addComponent(newCustomerBTN))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        salesPanelLayout.setVerticalGroup(
            salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sizesLabel)
                .addGap(10, 10, 10)
                .addGroup(salesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(salesPanelLayout.createSequentialGroup()
                        .addComponent(newItemBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchForItemTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCustomerBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemsScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addComponent(itemsScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSalesTBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salesScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(salesPanel, "card3");

        suppliersInfoTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        suppliersInfoTable.setForeground(new java.awt.Color(0, 0, 204));
        suppliersInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppliersInfoTable.setRowHeight(35);
        suppliersInfoTable.getTableHeader().setReorderingAllowed(false);
        suppliersInfoScrollPane.setViewportView(suppliersInfoTable);

        newSupplierBTN.setText("New Supplier");
        newSupplierBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSupplierBTNActionPerformed(evt);
            }
        });

        suppliersTransaTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        suppliersTransaTable1.setForeground(new java.awt.Color(0, 0, 204));
        suppliersTransaTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Name", "Item ID", "Recieipt Number", "Date", "Price", "Count", "Total", "Sizes", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suppliersTransaTable1.setRowHeight(35);
        suppliersTransaTable1.getTableHeader().setReorderingAllowed(false);
        suppliersTransScrollPane1.setViewportView(suppliersTransaTable1);

        newSupplierTransactionBTN1.setText("New Transaction");
        newSupplierTransactionBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSupplierTransactionBTN1ActionPerformed(evt);
            }
        });

        totalsTable1.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        totalsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Total", null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "null", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalsTable1.setRowHeight(25);

        searchForSupplierNameTXT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchForSupplierNameTXT1.setToolTipText("");
        searchForSupplierNameTXT1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchForSupplierNameTXT1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchForSupplierNameTXT1FocusLost(evt);
            }
        });
        searchForSupplierNameTXT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForSupplierNameTXT1KeyReleased(evt);
            }
        });

        searchForSupplierTrnsacTXT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchForSupplierTrnsacTXT2.setToolTipText("");
        searchForSupplierTrnsacTXT2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchForSupplierTrnsacTXT2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchForSupplierTrnsacTXT2FocusLost(evt);
            }
        });
        searchForSupplierTrnsacTXT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForSupplierTrnsacTXT2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout suppliresPanelLayout = new javax.swing.GroupLayout(suppliresPanel);
        suppliresPanel.setLayout(suppliresPanelLayout);
        suppliresPanelLayout.setHorizontalGroup(
            suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suppliresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newSupplierBTN)
                    .addComponent(suppliersInfoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(searchForSupplierNameTXT1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalsTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(suppliersTransScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addGroup(suppliresPanelLayout.createSequentialGroup()
                        .addComponent(newSupplierTransactionBTN1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchForSupplierTrnsacTXT2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                .addContainerGap())
        );
        suppliresPanelLayout.setVerticalGroup(
            suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suppliresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newSupplierTransactionBTN1)
                    .addComponent(newSupplierBTN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchForSupplierNameTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchForSupplierTrnsacTXT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suppliresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suppliresPanelLayout.createSequentialGroup()
                        .addComponent(suppliersTransScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalsTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(suppliersInfoScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap())
        );

        cardPanel.add(suppliresPanel, "card2");

        fromDateChooser.setDateFormatString("yyyy-MM-dd");
        fromDateChooser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        toDateChooser1.setDateFormatString("yyyy-MM-dd");
        toDateChooser1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("From: ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("To: ");

        setDateBTN.setText("Submit");
        setDateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDateBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingPanelLayout = new javax.swing.GroupLayout(settingPanel);
        settingPanel.setLayout(settingPanelLayout);
        settingPanelLayout.setHorizontalGroup(
            settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(settingPanelLayout.createSequentialGroup()
                        .addGroup(settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(setDateBTN))
                .addGap(0, 435, Short.MAX_VALUE))
        );
        settingPanelLayout.setVerticalGroup(
            settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(settingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(toDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setDateBTN)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        cardPanel.add(settingPanel, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(categoriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(categoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suppliersBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersBTNActionPerformed
        // TODO add your handling code here:
        suppliersBTN.setBackground(Color.BLUE);
        salesBTN1.setBackground(new Color(255, 0, 0));
        settingBTN.setBackground(new Color(255, 0, 0));
        
        displaySuppliersNames(true);
        displaySuppliersTransactions(true);
        
        reWritCardPanel(cardPanel, suppliresPanel);
    }//GEN-LAST:event_suppliersBTNActionPerformed

    private void newSupplierBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSupplierBTNActionPerformed
        // TODO add your handling code here:
        si = new SupplierInformationaa(this, true);
        
        reWritCardPanel(si.getCardPanel(), si.getInsertPanel());
        si.setTitle("Insert New Supplier...");
        
        si.pack();
        si.setLocationRelativeTo(null);
        si.setVisible(true);
        
        si.dispose();
        
        displaySuppliersNames(true);       
    }//GEN-LAST:event_newSupplierBTNActionPerformed

    private void newSupplierTransactionBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSupplierTransactionBTN1ActionPerformed
        // TODO add your handling code here:
        st = new SupplierTransaction(this, true);
        
        reWritCardPanel(st.getCardPanel(), st.getInsertPanel());
        st.setTitle("New Transaction...");
        
        st.getIcountTXT3().setText("1");
        
        if(suppliersInfoTable.getSelectedRow() >= 0) {
            st.getIsupplierNameCB().setSelectedItem(getSelectedRowValues(suppliersInfoTable, 0).toString());
        }
        
        st.dialogInitialization();
        
        displaySuppliersTransactions(true);
    }//GEN-LAST:event_newSupplierTransactionBTN1ActionPerformed

    private void salesBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBTN1ActionPerformed
        // TODO add your handling code here:
        salesBTN1.setBackground(Color.BLUE);
        suppliersBTN.setBackground(new Color(255, 0, 0));
        settingBTN.setBackground(new Color(255, 0, 0));
        
        displayItems(true);
        displaySalesTransactions();
        displayCustomer();
        
        reWritCardPanel(cardPanel, salesPanel);
    }//GEN-LAST:event_salesBTN1ActionPerformed

    private void newItemBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemBTNActionPerformed
        // TODO add your handling code here:
        item = new Item(null, true);
                
        reWritCardPanel(item.getCardPanel(), item.getInsertPanel());

        item.setTitle("New Item...");
        item.dialogInitialization();

        displayItems(true);
    }//GEN-LAST:event_newItemBTNActionPerformed

    private void newSalesTBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSalesTBTNActionPerformed
        // TODO add your handling code here:
        
        sales = new Sales(null, true);
                
        reWritCardPanel(sales.getCardPanel(), sales.getInsertPanel());

        if(itemsTable.getSelectedRow() >= 0) {
            sales.getItemIdjComboBox1().setSelectedItem(getSelectedRowValues(itemsTable, 0).toString());
        }
        
        if(customersTable.getSelectedRow() >= 0) {
            sales.getCustomerJCeckbox().setSelectedItem(getSelectedRowValues(customersTable, 0).toString());
        }
        
        sales.setTitle("New Transaction...");
        sales.dialogInitialization();

        displaySalesTransactions();
    }//GEN-LAST:event_newSalesTBTNActionPerformed

    private void settingBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBTNActionPerformed
        // TODO add your handling code here:
        settingBTN.setBackground(Color.BLUE);
        suppliersBTN.setBackground(new Color(255, 0, 0));
        salesBTN1.setBackground(new Color(255, 0, 0));
        
        reWritCardPanel(cardPanel, settingPanel);
    }//GEN-LAST:event_settingBTNActionPerformed

    private void setDateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDateBTNActionPerformed
        // TODO add your handling code here:
        file.createFile(((JTextField)fromDateChooser.getDateEditor().getUiComponent()).getText());
        JOptionPane.showMessageDialog(this, "Done...");
    }//GEN-LAST:event_setDateBTNActionPerformed

    private void searchForItemTXTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForItemTXTFocusGained
        // TODO add your handling code here:
        focusGained(searchForItemTXT);
    }//GEN-LAST:event_searchForItemTXTFocusGained

    private void searchForItemTXTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForItemTXTFocusLost
        // TODO add your handling code here:
        focusLost(searchForItemTXT);
    }//GEN-LAST:event_searchForItemTXTFocusLost

    private void searchForItemTXTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForItemTXTKeyReleased
        // TODO add your handling code here:
        displayItems(false);
    }//GEN-LAST:event_searchForItemTXTKeyReleased

    private void searchForSupplierNameTXT1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForSupplierNameTXT1FocusGained
        // TODO add your handling code here:
        focusGained(searchForSupplierNameTXT1);
    }//GEN-LAST:event_searchForSupplierNameTXT1FocusGained

    private void searchForSupplierNameTXT1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForSupplierNameTXT1FocusLost
        // TODO add your handling code here:
        focusLost(searchForSupplierNameTXT1);
    }//GEN-LAST:event_searchForSupplierNameTXT1FocusLost

    private void searchForSupplierNameTXT1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForSupplierNameTXT1KeyReleased
        // TODO add your handling code here:
        displaySuppliersNames(false);
    }//GEN-LAST:event_searchForSupplierNameTXT1KeyReleased

    private void searchForSupplierTrnsacTXT2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForSupplierTrnsacTXT2FocusGained
        // TODO add your handling code here:
        focusGained(searchForSupplierTrnsacTXT2);
    }//GEN-LAST:event_searchForSupplierTrnsacTXT2FocusGained

    private void searchForSupplierTrnsacTXT2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchForSupplierTrnsacTXT2FocusLost
        // TODO add your handling code here:
        focusLost(searchForSupplierTrnsacTXT2);
    }//GEN-LAST:event_searchForSupplierTrnsacTXT2FocusLost

    private void searchForSupplierTrnsacTXT2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForSupplierTrnsacTXT2KeyReleased
        // TODO add your handling code here:
        displaySuppliersTransactions(false);
    }//GEN-LAST:event_searchForSupplierTrnsacTXT2KeyReleased

    private void refreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBTNActionPerformed
        // TODO add your handling code here:
        sizesLabel.setText("");
        
        displayCustomer();
        displayItems(true);
        displaySalesTransactions();
        displaySuppliersNames(true);
        displaySuppliersTransactions(true);
    }//GEN-LAST:event_refreshBTNActionPerformed

    private void statusBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBTNActionPerformed
        // TODO add your handling code here:
        if(statusBTN.getText() == "Display All") {
            statusBTN.setText("Active Only");
            searchStatus = "";
            status = "";
        }
        else {
            statusBTN.setText("Display All");
            status = "where status='Active'";
            searchStatus = "and status='Active'";
        }
        
        displayItems(true);
        displaySuppliersNames(true);
        displayCustomer();
    }//GEN-LAST:event_statusBTNActionPerformed

    private void customersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_customersTableMouseClicked

    private void newCustomerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomerBTNActionPerformed
        customer = new Customer(null, true);
                
        reWritCardPanel(customer.getCardPanel2(), customer.getInsertPanel2());

        customer.dialogInitialization();

        displayCustomer();
    }//GEN-LAST:event_newCustomerBTNActionPerformed

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        // TODO add your handling code here:
        sizesLabel.setText(handler.getAvailableSizes(getSelectedRowValues(itemsTable, 0).toString()));
    }//GEN-LAST:event_itemsTableMouseClicked

    
    private void reportsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsBTNActionPerformed
        // TODO add your handling code here:
        reports = new Reports(this, true);
        
        reports.getjDateChooser1().setDate(fromDateChooser.getDate());
        reports.getjDateChooser2().setDate(toDateChooser1.getDate());
        
        reports.dialogInitialization();
    }//GEN-LAST:event_reportsBTNActionPerformed

    
    
    // initialize date choosers
    JTextFieldDateEditor jtde;
    public void initDateEditor(JDateChooser at) {
        //Start Code
        jtde = (JTextFieldDateEditor) at.getDateEditor();
        jtde.setEditable(false);
        jtde.setDate(new java.util.Date());
    }
    
    
    
    
    
    // totals
    // <editor-fold>
    
    int total;
    int getJTableColumnTotal(JTable tableName1, int column) {
        total = 0;

        for (int i = 0; i < tableName1.getRowCount(); i++) {
            total = total + (Integer) tableName1.getValueAt(i, column);
        }

        return total;
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    public void focusGained(JTextField txt) {
        if (txt.getText().equals("Search")) {
            txt.setText("");
            txt.setForeground(Color.BLACK);
        }
    }
    
    public void focusLost(JTextField txt) {
        if (txt.getText().isEmpty()) {
            txt.setForeground(Color.GRAY);
            txt.setText("Search");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    // ===================================
    // get data and display on the tables
    // =================================
    // <editor-fold>
    
    private void displaySuppliersNames(boolean val) {
        arr = new ArrayList();
        
        if (val) {
            handler.getSuppliersInformations(arr, status);
        } else {
            handler.getSuppliersNames(arr, '%' + searchForSupplierNameTXT1.getText() + '%', searchStatus);
        }
        
        
        model = (DefaultTableModel)suppliersInfoTable.getModel();
        model.setRowCount(0);
        row = new Object[2];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = ((SupplierInformationObj)arr.get(i)).getName();
            row[1] = "Edit";
            model.addRow(row);
        }
        
        doSomeThing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arr = new ArrayList<>();
                
                handler.getSuppliersInformations(arr, status);

                si = new SupplierInformationaa(null, true);
                
                reWritCardPanel(si.getCardPanel(), si.getUpdatePanel());
                
                
                for (int i = 0; i < arr.size(); i++) {
                    if (((SupplierInformationObj)arr.get(i)).getName() == 
                            getSelectedRowValues(suppliersInfoTable, 0).toString()) {
                        si.inflateUI(
                        getSelectedRowValues(suppliersInfoTable, 0).toString(), 
                        ((SupplierInformationObj)arr.get(i)).getPhoneNumber(),
                        ((SupplierInformationObj)arr.get(i)).getAddress(),
                        ((SupplierInformationObj)arr.get(i)).getStatus());
                        break;
                    }
                }

                si.dispose();
                
                displaySuppliersNames(true);
            }
        };
        
        tableButton = new TableButton(suppliersInfoTable, doSomeThing, 1);
    }
   
    private void displaySuppliersTransactions(boolean val) {
        arr = new ArrayList();
        
        if (val) {
            handler.getSuppliersTransactions(arr, 
                ((JTextField)fromDateChooser.getDateEditor().getUiComponent()).getText(),
                ((JTextField)toDateChooser1.getDateEditor().getUiComponent()).getText());
        } else {
            handler.getSuppliersTransactions(arr, 
                ((JTextField)fromDateChooser.getDateEditor().getUiComponent()).getText(),
                ((JTextField)toDateChooser1.getDateEditor().getUiComponent()).getText(),
                '%' + searchForSupplierTrnsacTXT2.getText() + '%',
                '%' + searchForSupplierTrnsacTXT2.getText() + '%');
        }
        
        
        model = (DefaultTableModel)suppliersTransaTable1.getModel();
        model.setRowCount(0);
        
        row = new Object[9];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = ((SuppliersTransactionsObj)arr.get(i)).getSupplierName();
            row[1] = ((SuppliersTransactionsObj)arr.get(i)).getItemID();
            row[2] = ((SuppliersTransactionsObj)arr.get(i)).getRecieiptNumber();
            row[3] = ((SuppliersTransactionsObj)arr.get(i)).getDate();
            row[4] = ((SuppliersTransactionsObj)arr.get(i)).getRecieiptPrice();
            row[5] = ((SuppliersTransactionsObj)arr.get(i)).getCount();
            row[6] = ((SuppliersTransactionsObj)arr.get(i)).getCount() * ((SuppliersTransactionsObj)arr.get(i)).getRecieiptPrice();
            row[7] = ((SuppliersTransactionsObj)arr.get(i)).getSizes().split("/")[0];
            row[8] = "Edit";
            model.addRow(row);
        }
        
        doSomeThing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arr = new ArrayList<>();
                
                st = new SupplierTransaction(null, true);
                
                reWritCardPanel(st.getCardPanel(), st.getUpdatePanel());
                
                st.inflateUI(
                        getSelectedRowValues(suppliersTransaTable1, 0).toString(),
                        getSelectedRowValues(suppliersTransaTable1, 1).toString(),
                        getSelectedRowValues(suppliersTransaTable1, 2).toString(),
                        (Date)getSelectedRowValues(suppliersTransaTable1, 3),
                        (Integer)getSelectedRowValues(suppliersTransaTable1, 4),
                        (Integer)getSelectedRowValues(suppliersTransaTable1, 5));
                
                displaySuppliersTransactions(true);
            }
        };
        
        tableButton = new TableButton(suppliersTransaTable1, doSomeThing, 8);
        
        
        totalsTable1.setValueAt(getJTableColumnTotal(suppliersTransaTable1, 6), 0, 6);
    }
    
    private void displayItems(boolean value) {
        arr = new ArrayList();
        
        if (value) {
            handler.getItems(arr, status);
        } else {
            handler.getItems(arr, '%' + searchForItemTXT.getText() + '%', '%' + searchForItemTXT.getText() + '%', searchStatus);
        }
        
        
        model = (DefaultTableModel)itemsTable.getModel();
        model.setRowCount(0);
        row = new Object[3];

        for (int i = 0; i < arr.size(); i++) {
            
            id = ((ItemsObj)arr.get(i)).getId();
            
            row[0] = id;
            row[1] = ((ItemsObj)arr.get(i)).getDescription();
            row[2] = "Edit";
            
            model.addRow(row);
        }
        
        doSomeThing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                item = new Item(null, true);
                
                reWritCardPanel(item.getCardPanel(), item.getUpdatePanel());
                
                item.inflateUI(
                        getSelectedRowValues(itemsTable, 0).toString(), 
                        getSelectedRowValues(itemsTable, 1).toString(),
                        handler.getItemStatus(getSelectedRowValues(itemsTable, 0).toString()));
                
                displayItems(true);  
            }
        };
        
        tableButton = new TableButton(itemsTable, doSomeThing, 2);
        
    }
    
    private void displayCustomer() {
        arr = new ArrayList();

        handler.getCustomers(arr, status);
        
        model = (DefaultTableModel)customersTable.getModel();
        model.setRowCount(0);
        row = new Object[2];

        for (int i = 0; i < arr.size(); i++) {
            
            row[0] = ((CustomerObj)arr.get(i)).getName();
            row[1] = "Edit";
            
            model.addRow(row);
        }
        
        doSomeThing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                arr = new ArrayList();

                handler.getCustomers(arr, status);
                
                customer = new Customer(null, true);
                
                reWritCardPanel(customer.getCardPanel2(), customer.getUpdatePanel());
                
                for (int i = 0; i < arr.size(); i++) {
                    if (((CustomerObj)arr.get(i)).getName() == getSelectedRowValues(customersTable, 0).toString()) {
                        customer.inflateUI(
                        getSelectedRowValues(customersTable, 0).toString(), 
                        ((CustomerObj)arr.get(i)).getPhoneNumbers(),
                        ((CustomerObj)arr.get(i)).getAddress(),
                        ((CustomerObj)arr.get(i)).getStatus());
                        break;
                    }
                }
                customer.dispose();
                displayCustomer();
                displaySalesTransactions();
            }
        };
        
        tableButton = new TableButton(customersTable, doSomeThing, 1);
        
    }
    DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
    private void displaySalesTransactions() {
        arr = new ArrayList();

        handler.getSaelsTransactions(arr, 
                ((JTextField)fromDateChooser.getDateEditor().getUiComponent()).getText(),
                ((JTextField)toDateChooser1.getDateEditor().getUiComponent()).getText());

        
        model = (DefaultTableModel)salesTable2.getModel();
        model.setRowCount(0);
        row = new Object[10];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = ((SalesObj)arr.get(i)).getId();
            row[1] = ((SalesObj)arr.get(i)).getItemId();
            row[2] = ((SalesObj)arr.get(i)).getCustomer_name();
            row[3] = ((SalesObj)arr.get(i)).getSize();
            row[4] = ((SalesObj)arr.get(i)).getPrice();
            row[5] = ((SalesObj)arr.get(i)).getCount();
            row[6] = ((SalesObj)arr.get(i)).getDate();
            row[7] = ((SalesObj)arr.get(i)).getPrice() * ((SalesObj)arr.get(i)).getCount();
            row[8] = ((SalesObj)arr.get(i)).getNote();
            row[9] = "Edit";
            model.addRow(row);
        }
        
        doSomeThing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                sales = new Sales(null, true);
                
                reWritCardPanel(sales.getCardPanel(), sales.getUpdatePanel());

                sales.inflateUI(
                        getSelectedRowValues(salesTable2, 0).toString(), 
                        getSelectedRowValues(salesTable2, 1).toString(),
                        getSelectedRowValues(salesTable2, 3).toString(), 
                        getSelectedRowValues(salesTable2, 4).toString(),
                        getSelectedRowValues(salesTable2, 5).toString(), 
                        (Date)getSelectedRowValues(salesTable2, 6),
                        getSelectedRowValues(salesTable2, 8).toString(),
                        getSelectedRowValues(salesTable2, 2).toString());
                
                displaySalesTransactions();
            }
        };
        
        tableButton = new TableButton(salesTable2, doSomeThing, 9);
        
        
        totalsTable.setValueAt(getJTableColumnTotal(salesTable2, 7), 0, 7);
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // =====================
    // manipulating Jtables
    // =====================
    // <editor-fold>
    
    Object getSelectedRowValues(JTable table, int column) {
        return table.getValueAt(table.getSelectedRow(), column);
    }
    
    JTableHeader header;
    void modificationJtablesHeader() {
        header = suppliersInfoTable.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        header = suppliersTransaTable1.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        header = itemsTable.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        header = salesTable2.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
    
    DefaultTableCellRenderer centerRenderer;
    public void setTableRowsTextToCenter() {
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        suppliersInfoTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 0; i < suppliersTransaTable1.getColumnCount(); i++) {
            suppliersTransaTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        for (int i = 0; i < itemsTable.getColumnCount(); i++) {
            itemsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        for (int i = 0; i < salesTable2.getColumnCount(); i++) {
            salesTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        totalsTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        
        totalsTable1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

    }

    void setTablesScrollBarToGray() {
        suppliersInfoScrollPane.getVerticalScrollBar().setUI(new GrayScrollBarUI());
        suppliersTransScrollPane1.getVerticalScrollBar().setUI(new GrayScrollBarUI());
        itemsScrollPane1.getVerticalScrollBar().setUI(new GrayScrollBarUI());
        salesScrollPane2.getVerticalScrollBar().setUI(new GrayScrollBarUI());
    }

    void setTablesSelectionToSingleSelection() {
        suppliersInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        suppliersTransaTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        salesTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // </editor-fold>
    
    
    
    
    
    
    
    

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel categoriesPanel;
    private javax.swing.JTable customersTable;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel img;
    private javax.swing.JScrollPane itemsScrollPane1;
    private javax.swing.JScrollPane itemsScrollPane2;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newCustomerBTN;
    private javax.swing.JButton newItemBTN;
    private javax.swing.JButton newSalesTBTN;
    private javax.swing.JButton newSupplierBTN;
    private javax.swing.JButton newSupplierTransactionBTN1;
    private javax.swing.JButton refreshBTN;
    private javax.swing.JButton reportsBTN;
    private javax.swing.JButton salesBTN1;
    private javax.swing.JPanel salesPanel;
    private javax.swing.JScrollPane salesScrollPane2;
    private javax.swing.JTable salesTable2;
    private javax.swing.JTextField searchForItemTXT;
    private javax.swing.JTextField searchForSupplierNameTXT1;
    private javax.swing.JTextField searchForSupplierTrnsacTXT2;
    private javax.swing.JButton setDateBTN;
    private javax.swing.JButton settingBTN;
    private javax.swing.JPanel settingPanel;
    private javax.swing.JLabel sizesLabel;
    private javax.swing.JButton statusBTN;
    private javax.swing.JButton suppliersBTN;
    private javax.swing.JScrollPane suppliersInfoScrollPane;
    private javax.swing.JTable suppliersInfoTable;
    private javax.swing.JScrollPane suppliersTransScrollPane1;
    private javax.swing.JTable suppliersTransaTable1;
    private javax.swing.JPanel suppliresPanel;
    private com.toedter.calendar.JDateChooser toDateChooser1;
    private javax.swing.JTable totalsTable;
    private javax.swing.JTable totalsTable1;
    // End of variables declaration//GEN-END:variables
}
