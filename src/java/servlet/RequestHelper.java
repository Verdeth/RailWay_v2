/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.util.HashMap;

import helpers.Command;
import helpers.LoginCommand;
import helpers.RegisterCommand;
import helpers.LogoutCommand;
import helpers.ShowUserListCommand;
import helpers.TrainListCommand;
import helpers.TrainListAdminCommand;
import helpers.TrainListAdminAddCommand;
import helpers.TrainCommand;
import helpers.NewTrainCommand;
import helpers.AddTrainCommand;
import helpers.SearchCommand;
import helpers.AddTicketCommand;
import helpers.YesTicketCommand;
import helpers.NoTicketCommand;
import helpers.AllTicketCommand;
import helpers.DeleteTicketCommand;
import helpers.EditTrainCommand;
import helpers.SaveTrainCommand;
import helpers.StantionCommand;
import helpers.SaveTimeCommand;

/**
 *
 * @author MSI
 */
public class RequestHelper {

	private static RequestHelper instance = null;
	
	private HashMap<String, Command> commands;
	
	private RequestHelper(){
		commands = new HashMap<String, Command>();
		commands.put("login", new LoginCommand());
		commands.put("register", new RegisterCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("show_users", new ShowUserListCommand());
                commands.put("all_train", new TrainListCommand());
                commands.put("all_train_admin", new TrainListAdminCommand());
                commands.put("all_train_admin_add", new TrainListAdminAddCommand());
                commands.put("train", new TrainCommand());
                commands.put("newTrain", new NewTrainCommand());
                commands.put("addTrain", new AddTrainCommand());
                commands.put("editStantion", new StantionCommand());
                commands.put("editTrain", new EditTrainCommand());              
                commands.put("search", new SearchCommand());               
                commands.put("addTicket", new AddTicketCommand());         
                commands.put("yes", new YesTicketCommand());         
                commands.put("no", new NoTicketCommand());        
                commands.put("tickets", new AllTicketCommand());  
                commands.put("deleteTicket", new DeleteTicketCommand());
                commands.put("saveTicket", new SaveTrainCommand());
                commands.put("saveTime", new SaveTimeCommand());
                
                
                
                
                
	}
	
	public Command getCommand(String action){
		Command command = commands.get(action);
		return command;
	}
	
	public static RequestHelper getInstance(){
		if (instance == null){
			instance = new RequestHelper();
		}
		return instance;
	}
	
}
