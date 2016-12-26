/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

/**
 *
 * @author MSI
 */
public class UserData extends ActionData {
    public String name;
    public String lastname;
    public String secondname;
    public String status;
    
    public UserData(String name, String lastname, String secondname, String status)
    {
        this.name = name;
        this.lastname = lastname;
        this.secondname = secondname;
        this.status = status;
    }
}

