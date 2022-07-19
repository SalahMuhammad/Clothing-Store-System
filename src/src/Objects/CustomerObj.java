/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author salah
 */
public class CustomerObj {
    
    int id;
    String name;
    String phoneNumbers;
    String address;
    String status;

    public CustomerObj(String name, String phoneNumbers, String address) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }

    public CustomerObj(int id, String name, String phoneNumbers, String address, String status) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getAddress() {
        return address;
    }
}
