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
public class LoginData extends ActionData {
    public String login;
    public String password;
    
    public LoginData(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
}
