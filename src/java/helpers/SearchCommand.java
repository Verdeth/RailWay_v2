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
public class SearchCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show ku");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
                
		System.out.println("show ku1");
		String beginStantion = (String)inData.getRequestParametr("beginStantion");
		System.out.println("show ku2");
		String endStantion = (String)inData.getRequestParametr("endStantion");                
		System.out.println("show ku3");
		String date = (String)inData.getRequestParametr("date");                
		System.out.println("show ku4");
		String type = (String)inData.getRequestParametr("type");
                System.out.println("show ku5");
		String count = (String)inData.getRequestParametr("count");
                
                
                
		System.out.println("show ku6");
		inData.setSessionAttribute("beginStantion", beginStantion);
                System.out.println("show ku7");
		inData.setSessionAttribute("endStantion", endStantion);
                System.out.println("show ku8");
		inData.setSessionAttribute("date", date);
                System.out.println("show ku9");
		inData.setSessionAttribute("type", type);
                System.out.println("show ku10");
		inData.setSessionAttribute("count", count);
                System.out.println("show ku11");
		
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
