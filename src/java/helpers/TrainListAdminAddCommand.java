/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;



import java.io.IOException;

import servlet.InDataWrapper;
import dao.DAOException;
import dao.TrainDAO;
import to.TrainList;
/**
 *
 * @author MSI
 */
public class TrainListAdminAddCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show train");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
		TrainList trainList;
		try {
                    System.out.println("show train 1");
			trainList = TrainDAO.trainAdminList();
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (trainList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("trainList", trainList);
		
		return "/WEB-INF/jsp/all_trains_admin_foradd.jsp";
	}   
}
