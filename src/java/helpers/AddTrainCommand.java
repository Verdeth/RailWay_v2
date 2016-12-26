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
public class AddTrainCommand implements Command {
    @Override
	public String execute(InDataWrapper inData) throws DataException {
            TrainData train = null;
            try
            {               
            TrainDAO.trainNew(inData.getRequestParametr("id").toString(), inData.getRequestParametr("date").toString(), inData.getRequestParametr("type1").toString(), inData.getRequestParametr("type2").toString(), inData.getRequestParametr("type3").toString(), inData.getRequestParametr("type4").toString());
            //inData.setRequestAttribute("trainForNew", train);
            }
            catch (Exception e)
                    {}
	return new TrainListAdminCommand().execute(inData); 
        }
}
