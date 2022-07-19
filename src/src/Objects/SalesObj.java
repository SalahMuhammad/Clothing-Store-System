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
public class SalesObj {
    
    int id;
    String itemId;
    String size;
    int price;
    int count;
    Date date;
    String note;
    String customer_name;

    public SalesObj(int id, String itemId, String size, int price, int count, Date date, String note, String customer_name) {
        this.id = id;
        this.itemId = itemId;
        this.size = size;
        this.price = price;
        this.count = count;
        this.date = date;
        this.note = note;
        this.customer_name = customer_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public Date getDate() {
        return date;
    }
    
}
