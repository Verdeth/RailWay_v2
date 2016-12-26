/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import to.UserData;
import to.UserList;


/**
 *
 * @author MSI
 */
public class UserDAO {

	public static UserList userList() throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		UserList userList = null;
	    
		try {
                    System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
                        System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    	System.out.println("2");
                st = con.createStatement();
                System.out.println("3");
	    	rs = st.executeQuery("SELECT name, lastname, secondname FROM users WHERE status='user'");
	    	
	    	List<UserData> users = new ArrayList<UserData>();
	    	UserData data = null;
	    	while (rs.next()){
	    		data = new UserData(rs.getString("name"), rs.getString("lastname"),rs.getString("secondname"), "user");
	    		users.add(data);
	    	}
	    	
	    	userList = new UserList(users);
	    	
	    } catch (ClassNotFoundException e) {
	    	System.out.println("551");
                System.out.println("10");
	    	throw new DAOException("Ошибка загрузки драйвера.");
	    } catch (SQLException e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
	    } finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    		if (con != null) con.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } 

		return userList;
	
	}
}

