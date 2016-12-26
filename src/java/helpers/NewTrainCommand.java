/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.StantionDAO;
import dao.TrainDAO;
import to.TrainData;
import servlet.InDataWrapper;

/**
 *
 * @author MSI
 */
public class NewTrainCommand implements Command {
    @Override
	public String execute(InDataWrapper inData) throws DataException {
            TrainData train = null;
            try
            {               
            train = TrainDAO.trainforNew(inData.getRequestParametr("id").toString());
            inData.setRequestAttribute("trainForNew", train);
            }
            catch (Exception e)
                    {}
	return "/WEB-INF/jsp/add_train.jsp"; 
        }
}
