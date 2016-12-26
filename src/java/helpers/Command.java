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
public interface Command {
	public String execute(InDataWrapper inData) throws Exception;
}
