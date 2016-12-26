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
/**
 *
 * @author MSI
 */
public class EditTrainCommand implements Command{
 @Override
	public String execute(InDataWrapper inData) throws DataException {
                System.out.println("show train");
		//String login = (String)inData.getSessionAttribute("login");
		
		//if(!"OK".equals(login)){
		//	return "/index.jsp";
		//}
		
		TrainData train;
                String date = (String)inData.getRequestParametr("date");
                String id = (String)inData.getRequestParametr("id");
		try {
                    System.out.println("show train 1");
			train = TrainDAO.train(id,date);
                        System.out.println("show train 2");
		} catch (DAOException e) {
			throw new DataException("Ошибка работы с источником данных.");
		}
		
		if (train == null){
			throw new DataException("Ошибка работы с источником данных. Нет пользователей.");
		}
		
		inData.setRequestAttribute("editTrain", train);
               // inData.setRequestAttribute("id", inData.getRequestParametr("id").toString());
                
		
		return "/WEB-INF/jsp/edit_train.jsp";
	}   
}
