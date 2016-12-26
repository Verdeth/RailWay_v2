/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;


import java.io.IOException;

import servlet.InDataWrapper;
import dao.DAOException;
import dao.UserDAO;
import to.UserList;

/**
 *
 * @author MSI
 */
public class ShowUserListCommand implements Command{

	@Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show user");
		String login = (String)inData.getSessionAttribute("login");
		
		if(!"OK".equals(login)){
			return "/index.jsp";
		}
		
		UserList userList;
		try {
                    System.out.println("show user 1");
			userList = UserDAO.userList();
                        System.out.println("show user 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (userList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("userList", userList);
		
		return "/WEB-INF/jsp/all_users_show_page.jsp";
	}

}
