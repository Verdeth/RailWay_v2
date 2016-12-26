/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import servlet.InDataWrapper;
import dao.DAOException;
import dao.TrainDAO;
import to.TrainList;
/**
 *
 * @author MSI
 */
public class NoTicketCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show ku");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
                
		String beginStantion = (String)inData.getSessionAttribute("beginStantion");
		System.out.println("show ku2");
		String endStantion = (String)inData.getSessionAttribute("endStantion");                
		System.out.println("show ku3");
		String date = (String)inData.getSessionAttribute("date");                
		System.out.println("show ku4");
		String type = (String)inData.getSessionAttribute("type");
                System.out.println("show ku5");
		String count = (String)inData.getSessionAttribute("count");
                System.out.println("rte000");
		
		TrainList trainList;
		try {
                    System.out.println("show train 1");
			trainList = TrainDAO.trainListSearch(beginStantion,endStantion, date, type, count);
                        System.out.println("yuuuuuuuu");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (trainList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("trainListSearch", trainList);
              //  inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		
		return "/WEB-INF/jsp/search_trains.jsp";
	}   
}
