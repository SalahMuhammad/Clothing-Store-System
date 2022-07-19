package main;

import Objects.CustomerObj;
import Objects.SupplierInformationObj;
import Objects.ItemsObj;
import Objects.SalesObj;
import Objects.SuppliersTransactionsObj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class DatabaseHandler {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    long millis = 0;
    String sql;

    ItemsObj item;
    SalesObj sales;
    CustomerObj customer;
    
    public DatabaseHandler() {
        initializeColumnNamesList();
    }
    
    
    String dbFile = "sss.accdb";
    private Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://" + dbFile);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getConnection error...\n" + ex.getMessage());
            closeConnection();
            System.exit(1);
        }
        
        return con;
    }
    
    public void closeConnection() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "close connection error...\n" + ex);
        }
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // suppliers_info block
    // <editor-fold>
    
    SupplierInformationObj si = null;
    public ArrayList getSuppliersInformations(ArrayList arr, String status) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select * from suppliers_info " + status + " order by name_ asc");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                si = new SupplierInformationObj(
                        rs.getString("name_"),
                        rs.getString("phone_number"),
                        rs.getString("office_location"), 
                        rs.getString("status"));
                
                arr.add(si);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "get all data error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public ArrayList getSuppliersNames(ArrayList arr, String name, String status) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select name_ from suppliers_info where (name_ like ?) " + status + " order by name_ asc");
            
            ps.setString(1, name);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                si = new SupplierInformationObj(rs.getString("name_"));
                
                arr.add(si);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "get all data error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public void insertSupplier(String name, String phone_number, String office_location, String status) {
        getConnection();
        
        try {
            ps = con.prepareStatement("insert into suppliers_info (name_, phone_number, office_location, status) values (?, ?, ?, '" + status + "')");

            ps.setString(1, name);
            ps.setString(2, phone_number);
            ps.setString(3, office_location);
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "supplier inserted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertSupplier error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void updateSupplier(String name, String phone_number, String office_location, String status) {
        getConnection();
        
        try {
            ps = con.prepareStatement("update suppliers_info set phone_number=?, office_location=?, status='" + status + "' where name_ = ?");

            ps.setString(1, phone_number);
            ps.setString(2, office_location);
            ps.setString(3, name);
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "supplier information updated successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateSupplier error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void deleteSupplier(String name) {
        try {
            getConnection();

            ps = con.prepareStatement("delete from suppliers_info where name_ = ?");

            ps.setString(1, name);

            ps.execute();

            JOptionPane.showMessageDialog(null, "supplier deleted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteSupplier error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    // </editor-fold>  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // suppliers_transactions block
    // <editor-fold>

    SuppliersTransactionsObj st;
    public ArrayList getSuppliersTransactions(ArrayList arr, String from, String to) {
        getConnection();
        
        try {
            ps = con.prepareStatement("select * from suppliers_transactions where datee between '" + from + "' and '" + to + "' order by datee desc");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                st = new SuppliersTransactionsObj(
                    rs.getString("supplier_name"),
                    rs.getString("item_id"),
                    rs.getString("recieipt_number"),
                    rs.getInt("recieipt_price"),
                    rs.getInt("count"),
                    rs.getDate("datee"),
                    rs.getString("sizes"));
                
                arr.add(st);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "get all data error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public ArrayList getSuppliersTransactions(ArrayList arr, String from, String to, String recNumber, String date) {
        getConnection();
        
        try {
            ps = con.prepareStatement("select * from suppliers_transactions where datee between '" + from + "' and '" + to + "' and recieipt_number like ? or supplier_name like ? order by datee desc");
            
            ps.setString(1, recNumber);
            ps.setString(2, date);

            rs = ps.executeQuery();
            
            while (rs.next()) {
                st = new SuppliersTransactionsObj(
                    rs.getString("supplier_name"),
                    rs.getString("item_id"),
                    rs.getString("recieipt_number"),
                    rs.getInt("recieipt_price"),
                    rs.getInt("count"),
                    rs.getDate("datee"),
                    rs.getString("sizes"));
                
                arr.add(st);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "get all data error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public void insertSupplierTransaction(
            String supplier_name,
            String recieipt_number,
            int recieipt_price,
            String item_id,
            int count,
            String date,
            String sizes) throws SQLException {
        
        getConnection();
        millis = System.currentTimeMillis();
        
            sql = "insert into suppliers_transactions ("
                    + "supplier_name,"
                    + "recieipt_number,"
                    + "recieipt_price,"
                    + "datee,"
                    + "item_id,"
                    + "count,"
                    + "sizes) values (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, supplier_name);
            ps.setString(2, recieipt_number);
            ps.setInt(3, recieipt_price);
            ps.setString(4, date);
            ps.setString(5, item_id);
            ps.setInt(6, count);
            ps.setString(7, sizes);

            ps.execute();

    }
    
    public void updateSupplierTransaction(
            String recieipt_number,
            String supplier_name,
            String itemId,
            String date,
            int recieipt_price,
            int count,
            String oldRecieiptNumber) {
        
        getConnection();
        millis = System.currentTimeMillis();
        
        try {
            sql = "update suppliers_transactions set"
                    + " supplier_name=?,"
                    + " item_id=?,"
                    + " datee=?,"
                    + " recieipt_price=?,"
                    + " count=?,"
                    + " recieipt_number=?"
                    + " where recieipt_number = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, supplier_name);
            ps.setString(2, itemId);
            ps.setString(3, date);
            ps.setInt(4, recieipt_price);
            ps.setInt(5, count);
            ps.setString(6, recieipt_number);
            ps.setString(7, oldRecieiptNumber);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "transaction updated successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateSupplierTransaction error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void deleteSupplierTransaction(String recieipt_number) {
        try {
            getConnection();

            ps = con.prepareStatement("delete from suppliers_transactions where recieipt_number = ?");

            ps.setString(1, recieipt_number);

            ps.execute();

            JOptionPane.showMessageDialog(null, "transaction deleted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteSupplierTransaction error...\n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // items do dml block
    // <editor-fold>
    
    public ArrayList getItems(ArrayList arr, String status) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select id, description from items " + status + " order by id asc");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                item = new ItemsObj(rs.getString("id"), rs.getString("description"));
                
                arr.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getItems error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public ArrayList getItems(ArrayList arr, String id, String description, String status) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select id, description from items where (id like ? or description like ?) " + status + " order by id asc");
            
            ps.setString(1, id);
            ps.setString(2, description);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                item = new ItemsObj(rs.getString("id"), rs.getString("description"));
                
                arr.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getItems error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public String getItemStatus(String itemId) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select status from items where id='" + itemId + "'");
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("status");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getItems error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public void insertAnItem(String id, String description, String status) {
        getConnection();
        
        try {
            sql = "insert into items (id, description, status) values (?, ?, '" + status + "')";
            ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, description);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "item inserted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertAnItem error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void updateAnItem(String id, String description, String status, String oldId) {
        
        getConnection();
        
        try {
            sql = "update items set id=?, description=?, status='" + status + "' where id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.setString(2, description);
            ps.setString(3, oldId);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "item updated successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateAnItem error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void deleteAnItem(String id) {
        try {
            getConnection();

            ps = con.prepareStatement("delete from items where id = ?");

            ps.setString(1, id);

            ps.execute();

            JOptionPane.showMessageDialog(null, "item deleted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteAnItem error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // customers do dml block
    // <editor-fold>
    
    public ArrayList getCustomers(ArrayList arr, String status) {
        
        getConnection();
        
        try {
            ps = con.prepareStatement("select * from customers " + status + " order by name_ asc");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                customer = new CustomerObj(
                        rs.getInt("id"),
                        rs.getString("name_"),
                        rs.getString("phone_numbers"),
                        rs.getString("address"),
                        rs.getString("status"));
                
                arr.add(customer);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getCustomers error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public void insertCustomer(String name, String phoneNumbers, String address, String status) {
        getConnection();
        
        try {
            sql = "insert into customers (name_, phone_numbers, address, status) values (?, ?, ?, '" + status + "')";
            ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, phoneNumbers);
            ps.setString(3, address);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "customer inserted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertCustomer error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void updateCustomer(String name_, String phoneNumbers, String address, String status, String oldName) {
        
        getConnection();
        
        try {
            sql = "update customers set name_=?, phone_numbers=?, address=?, status='" + status + "' where name_= ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, name_);
            ps.setString(2, phoneNumbers);
            ps.setString(3, address);
            ps.setString(4, oldName);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "customer updated successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateCustomer error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void deleteCustomer(String name) {
        try {
            getConnection();

            ps = con.prepareStatement("delete from customers where name_= ?");

            ps.setString(1, name);

            ps.execute();

            JOptionPane.showMessageDialog(null, "customer deleted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteCustomer error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // calculation block
    // <editor-fold>
    
    ArrayList<Integer> sumList;
    ArrayList<String> columnsNames;
    String values = "";
    
    public void initializeColumnNamesList() {
        
        columnsNames = new ArrayList<>();
        
        columnsNames.add("s");
        columnsNames.add("m");
        columnsNames.add("l");
        columnsNames.add("xl");
        columnsNames.add("xx");
        columnsNames.add("xxx");
        columnsNames.add("xxxx");
        columnsNames.add("xxxxx");
    }
    
    public String getAvailableSizes(String itemId) {

       sumList = new ArrayList<>();
       values = "";
       

       getConnection();

       try {
           rs = con.prepareStatement("select "
                   + "sum(s) as s, "
                   + "sum(m) as m,"
                   + "sum(l) as l,"
                   + "sum(xl) as xl,"
                   + "sum(xx) as xx,"
                   + "sum(xxx) as xxx,"
                   + "sum(xxxx) as xxxx,"
                   + "sum(xxxxx) as xxxxx from sizes where item_id = '" + itemId + "'").executeQuery();

           if (rs.next()) {
               sumList.add(rs.getInt("s"));
               sumList.add(rs.getInt("m"));
               sumList.add(rs.getInt("l"));
               sumList.add(rs.getInt("xl"));
               sumList.add(rs.getInt("xx"));
               sumList.add(rs.getInt("xxx"));
               sumList.add(rs.getInt("xxxx"));
               sumList.add(rs.getInt("xxxxx"));
           }
           
           for (int i = 0; i < columnsNames.size(); i++) {
               
               rs = con.prepareStatement("select sum(count) as sum from sales where size = '" + columnsNames.get(i) + "' and item_id = '" + itemId + "'").executeQuery();
               
               if (rs.next()) {
                   sumList.set(i, sumList.get(i) - rs.getInt("sum"));
                   
                   values = values + columnsNames.get(i) + " (" + sumList.get(i) + "),      ";
               }
               
           }

       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "getSizesSum error... " + ex.getMessage());
       } finally {
           closeConnection();
       }
       
       return values;
    }
    
    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // sizes do dml block
    // <editor-fold>
    
    public void insertSizes(String itemId, String recieiptNumber, String columnsNames, String values) {
        getConnection();
        
        try {
            sql = "insert into sizes (item_id, recieipt_number, " + columnsNames + ") values (?, ?, " + values + ")";
            ps = con.prepareStatement(sql);

            ps.setString(1, itemId);
            ps.setString(2, recieiptNumber);;
            
            ps.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertSizesTTTTTT error...\n" + ex.getMessage(), "error", 0);
        } finally {
            closeConnection();
        }
    }
    
    public void deleteSizes(String recieiptNumber) {
        getConnection();
        
        try {
            sql = "delete from sizes where recieipt_number='" + recieiptNumber + "'";
            ps = con.prepareStatement(sql);
            
            ps.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertSizesTTTTTT error...\n" + ex.getMessage(), "error", 0);
        } finally {
            closeConnection();
        }
    }

    // </editor-fold>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // sales do dml block
    // <editor-fold> 

    public ArrayList getSaelsTransactions(ArrayList arr, String from, String to) {
        getConnection();
        
        try {
            ps = con.prepareStatement("select sales.*, customers.name_ from sales inner join customers on sales.customer_id=customers.id where datee between '" + from + "' and '" + to + "' order by datee desc");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                sales = new SalesObj(
                        rs.getInt("id"),
                        rs.getString("item_id"),
                        rs.getString("size"),
                        rs.getInt("price"),
                        rs.getInt("count"),
                        rs.getDate("datee"),
                        rs.getString("note"),
                        rs.getString("name_"));
                
                arr.add(sales);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getSaelsTransactions error... " + ex.getMessage());
        } finally {
            closeConnection();
        }
        
        return arr;
    }
    
    public void insertSalesT(String item_id, String size, int price, int count, String date, String note, int customerId) {
        getConnection();
        
        try { 
            
            sql = "insert into sales (item_id, size, price, count, datee, note, customer_id) values (?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, item_id);
            ps.setString(2, size);
            ps.setInt(3, price);
            ps.setInt(4, count);
            ps.setString(5, date);
            ps.setString(6, note);
            ps.setInt(7, customerId);
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "transaction inserted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "insertSalesT error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void updateSalesT(int id, String item_id, String size, int price, int count, String date, String note, int customerId) {
        
        getConnection();
        
        try {
            sql = "update sales set item_id=?, size=?, price=?, count=?, datee=?, note=?, customer_id=? where id = ?";
            ps = con.prepareStatement(sql);

            ps.setString(1, item_id);
            ps.setString(2, size);
            ps.setInt(3, price);
            ps.setInt(4, count);
            ps.setString(5, date);
            ps.setString(6, note);
            ps.setInt(7, customerId);
            ps.setInt(8, id);

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "transaction updated successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "updateSalesT error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public void deleteSalesT(int id) {
        try {
            getConnection();

            ps = con.prepareStatement("delete from sales where id = ?");

            ps.setInt(1, id);

            ps.execute();

            JOptionPane.showMessageDialog(null, "transaction deleted successfully..");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "deleteSalesT error...\n" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    // </editor-fold>
}
