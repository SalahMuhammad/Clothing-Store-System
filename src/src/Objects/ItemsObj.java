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
public class ItemsObj {
    
    String id;
    String description;

    public ItemsObj(String id) {
        this.id = id;
    }

    public ItemsObj(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
}
