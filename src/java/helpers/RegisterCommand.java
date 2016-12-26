/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import servlet.InDataWrapper;
import dao.DAOException;
import dao.LoginDAO;
import to.UserData;

/**
 *
 * @author MSI
 */
public class RegisterCommand implements Command{
	
	private static String loginParam = "login";
	private static String passwordParam = "password";

	@Override
	public String execute(InDataWrapper inData) throws DataException {
		
		String login;
		String password;
		
		login = inData.getRequestParametr(loginParam).toString();
		password = inData.getRequestParametr(passwordParam).toString();

		UserData userData = null;
		String page = null;
		String msg = null;
		try {
                    if (!inData.getRequestParametr("password").toString().equals(inData.getRequestParametr("password2").toString()))
                    {msg = "Неправильно повторен пароль!";
                    inData.setSessionAttribute("msg", msg);
                    page = "/index.jsp";
                    return page;
                    }
                                        
			userData = LoginDAO.registerUser(login, password, inData.getRequestParametr("name").toString(), inData.getRequestParametr("lastname").toString(), inData.getRequestParametr("secondname").toString());
			
			if (userData == null){
				msg = "Такой e-mail уже зарегистрирован!";
                                inData.setSessionAttribute("msg", msg);
                                page = "/index.jsp";
                                return page;
			}
			
			inData.setSessionAttribute("login", "OK");
                        inData.setSessionAttribute("nameUser", userData.name);
                        inData.setSessionAttribute("loginUser", login);
                        inData.setRequestAttribute("userData", userData);
			
			switch(userData.status){
			case "user":
				page = new TrainListCommand().execute(inData);
				break;
			case "admin":
				page = new TrainListAdminCommand().execute(inData); 
				break;
			}
		} catch (DAOException e) {
			msg = "Такой e-mail уже зарегистрирован!";
                                inData.setSessionAttribute("msg", msg);
                                page = "/index.jsp";
		}
				
		return page;
	}
	
	

}

