/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.http.HttpServletRequest;

import to.ActionData;
import to.LoginData;


/**
 *
 * @author MSI
 */
public class ActionDataHelper {
    
    private static ActionDataHelper instance = null;
    
    private ActionDataHelper()
    {
    }
    
    public ActionData getActionData(String command, HttpServletRequest request)
    {
        ActionData actionData = null;
        switch(command)
        {
            case "login":
                actionData = getLoginData(request);
        }
        return actionData;
        }
    
    public static ActionDataHelper getInstance()
    {
        if (instance == null)
        {
            instance = new ActionDataHelper();
        }
        return instance;
    }
    
    private ActionData getLoginData(HttpServletRequest request)
    {
        String login = null;
        String password = null;
        LoginData loginData;
        
        login = request.getParameter("login");
        password = request.getParameter("password");
        loginData = new LoginData(login, password);
        
        return loginData;
    }
    }
    
    

