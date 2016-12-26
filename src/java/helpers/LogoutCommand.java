/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import servlet.InDataWrapper;

/**
 *
 * @author MSI
 */
public class LogoutCommand implements Command {

	@Override
	public String execute(InDataWrapper inData) throws Exception {
		inData.sessionInvalidate();
		return "/index.jsp";
	}

}
