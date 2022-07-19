/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author salah
 */
public class SupplierInformationObj {
    
    private String name;
    private String phoneNumber;
    private String address;
    private String status;

    public String getStatus() {
        return status;
    }

    public SupplierInformationObj(String name) {
        this.name = name;
    }

    public SupplierInformationObj(String name, String phoneNumber, String officeLocation, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = officeLocation;
        this.status = status;
    }
    
    public SupplierInformationObj(String phoneNumber, String officeLocation, String status) {
        this.phoneNumber = phoneNumber;
        this.address = officeLocation;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }
    
}
