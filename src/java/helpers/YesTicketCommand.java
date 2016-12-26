/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author MSI
 */



import java.io.IOException;

import servlet.InDataWrapper;
import dao.DAOException;
import dao.TrainDAO;
import to.TrainList;
import dao.TicketDAO;
//import to.TicketList;
/**
 *
 * @author MSI
 */
public class YesTicketCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show train");
                
                String id = (String)inData.getRequestParametr("id");
                String count = (String)inData.getSessionAttribute("count");
                String email = (String)inData.getSessionAttribute("loginUser");
                String price = (String)inData.getRequestParametr("price");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
		//TrainList trainList;
		try {
                //    System.out.println("show train 1");
			TicketDAO.yesTicket(id, count, email, price);
                        System.out.println("show train 2");
                        Command command = new TrainListCommand();
                        return command.execute(inData);
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
                catch (Exception e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		/*if (trainList == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}*/
		
		//inData.setRequestAttribute("trainList", trainList);
		
	}   
}

