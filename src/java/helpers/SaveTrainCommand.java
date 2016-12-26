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
import dao.StantionDAO;
import to.TrainData;
import to.StantionData;
import to.StantionList;
import to.TrainList;
/**
 *
 * @author MSI
 */
public class SaveTrainCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show train");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
              
                String date = (String)inData.getRequestParametr("date");
                String id = (String)inData.getRequestParametr("id");
                
                String count1 = (String)inData.getRequestParametr("type1");   
                String count2 = (String)inData.getRequestParametr("type2");
                String count3 = (String)inData.getRequestParametr("type3");
                String count4 = (String)inData.getRequestParametr("type4");    
                
                TrainList trainList;
		
                    
		try {
                    System.out.println("show train 1");
			TrainDAO.trainTicketEdit(id,date,count1,count2,count3,count4);
                       try {
                    System.out.println("show train 1");
			trainList = TrainDAO.trainList();
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (trainList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("trainList", trainList);
		try {
                    System.out.println("show train 1");
			trainList = TrainDAO.trainList();
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (trainList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		
               // inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		
		return "/WEB-INF/jsp/all_trains_admin.jsp";
	}   
}
