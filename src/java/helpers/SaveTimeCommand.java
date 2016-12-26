/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import dao.StantionDAO;
import servlet.InDataWrapper;

/**
 *
 * @author MSI
 */
public class SaveTimeCommand implements Command {
    @Override
	public String execute(InDataWrapper inData) throws DataException {
            String par = "";
            try
            {
                int count = StantionDAO.stantionCount(inData.getRequestParametr("id").toString());
                String[] time = new String[count];
                
                        for (int i=0; i<time.length; ++i)
                        {
                            par = "DateStantion" + i;
                        time[i]=(String)inData.getRequestParametr(par);
                        }
            StantionDAO.stantionEdit(inData.getRequestParametr("id").toString(), time);
           
            Command command = new TrainListAdminAddCommand();
	return command.execute(inData); 
            }
            catch (Exception e)
                    {}
        return par;
        }
}
