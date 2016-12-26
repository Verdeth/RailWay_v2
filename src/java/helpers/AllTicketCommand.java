/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.DAOException;
import dao.StantionDAO;
import dao.TicketDAO;
import servlet.InDataWrapper;
import to.StantionList;
import to.TicketList;

/**
 *
 * @author MSI
 */
public class AllTicketCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
               System.out.println("show message");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
		TicketList ticketList;
		try {
                    System.out.println("show train 1");
			ticketList = TicketDAO.ticketList(inData.getSessionAttribute("loginUser").toString());
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (ticketList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("ticketList", ticketList);
              //  inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		
		return "/WEB-INF/jsp/all_ticket.jsp";
	}   
}