/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.sql.Date;

/**
 *
 * @author salah
 */
public class SuppliersTransactionsObj {
    
    String supplierName;
    String itemID;
    String recieiptNumber;
    int recieiptPrice;
    int count;
    Date date;
    String sizes;

    public SuppliersTransactionsObj(String supplierName, String itemID, String recieiptNumber, int recieiptPrice, int count, Date date, String sizes) {
        this.supplierName = supplierName;
        this.itemID = itemID;
        this.recieiptNumber = recieiptNumber;
        this.recieiptPrice = recieiptPrice;
        this.count = count;
        this.date = date;
        this.sizes = sizes;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getItemID() {
        return itemID;
    }

    public String getRecieiptNumber() {
        return recieiptNumber;
    }

    public int getRecieiptPrice() {
        return recieiptPrice;
    }

    public int getCount() {
        return count;
    }

    public Date getDate() {
        return date;
    }
    
    
}
