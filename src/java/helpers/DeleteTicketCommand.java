/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.DAOException;
import dao.TicketDAO;
import dao.TrainDAO;
import servlet.InDataWrapper;
import to.TrainList;
import to.TrainData;

/**
 *
 * @author MSI
 */
public class DeleteTicketCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show kuid");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
                
		

                String id = (String)inData.getRequestParametr("id");
                //String idTicket = "";
		
		//TrainData train;
		try {
                    System.out.println("show train 1");
			
                    TicketDAO.deleteTicket(id,inData.getSessionAttribute("loginUser").toString());
                        
                        System.out.println("yuuuuuuuu");
                        
                        Command command = new AllTicketCommand();
                        return command.execute(inData);
                        //return "/WEB-INF/jsp/error.jsp";
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		catch (Exception e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
			
                
		//System.out.println("rte");
		
	}   
}