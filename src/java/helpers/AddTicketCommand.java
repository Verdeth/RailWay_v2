/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.DAOException;
import dao.TrainDAO;
import servlet.InDataWrapper;
import to.TrainList;
import to.TrainData;

/**
 *
 * @author MSI
 */
public class AddTicketCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show kuid");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
                
		//System.out.println("show ku1");
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

                String id = (String)inData.getRequestParametr("id");
                
                String idTicket = "";
		
		TrainData train;
		try {
                    System.out.println("show train 1");
			train = TrainDAO.trainForTicket(id, beginStantion,endStantion, date, type, count);
                        idTicket = TrainDAO.idForTicket(id, beginStantion,endStantion, date, type, count);
                       
                        
                        System.out.println("yuuuuuuuu");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (train == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		System.out.println("rte");
		inData.setRequestAttribute("trainForTicket", train);
                System.out.println("rte1");
                inData.setRequestAttribute("idTicket", idTicket);
                System.out.println("rte2");
              //  inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		System.out.println("rte");
		return "/WEB-INF/jsp/add_ticket.jsp";
	}   
}