/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.DAOException;
import dao.StantionDAO;
import servlet.InDataWrapper;
import to.StantionList;

/**
 *
 * @author MSI
 */
public class StantionCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show train");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
		StantionList stantionList;
		try {
                    System.out.println("show train 1");
			stantionList = StantionDAO.stantionList(inData.getRequestParametr("id").toString());
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (stantionList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("stantionList", stantionList);
                inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		
		return "/WEB-INF/jsp/edit_stantion.jsp";
	}   
}

