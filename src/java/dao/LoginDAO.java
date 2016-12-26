/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import to.UserData;

/**
 *
 * @author MSI
 */
public class LoginDAO{
	
	public static UserData checkUser(String login, String password) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		UserData data = null;
	    
		try {
		    System.out.println("0");
                    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
                        System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    	System.out.println("2");
                st = con.createStatement();
                System.out.println("3");
	    	rs = st.executeQuery("SELECT name, lastname, secondname, status FROM users WHERE email='"+login+"'AND password='"+password+"'");

	    	if (rs.next()){
	    		data = new UserData(rs.getString("name"), rs.getString("lastname"),rs.getString("secondname"), rs.getString("status"));
	    	}
	    	
	    } 
                catch (ClassNotFoundException e) {
	    	System.out.println("55log");
	    	throw new DAOException("Ошибка загрузки драйвера."); 
            } catch (InstantiationException e) {
	    	System.out.println("44log");
	    	throw new DAOException("Ошибка загрузки драйвера.");
	    } catch (SQLException e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
            } 
                catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	throw new DAOException("Ошибка работы с источником данных.");
	    }
                finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    		if (con != null) con.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } 

		return data;
	}
        
        public static UserData registerUser(String login, String password, String name, String lastname, String secondname) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		UserData data = null;
	    
		try {
		    System.out.println("0");
                    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
                        System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    	System.out.println("2");
                st = con.createStatement();
                System.out.println("3");
                
                String str = "";
                
                str = "INSERT INTO users (email, password, name, lastname, secondname) VALUES ('" + login + "', '" + password + 
                        "', '" + name + "', '" + lastname + "', '" + secondname + "')";
                System.out.println(str);
                st.executeUpdate(str);
	    	rs = st.executeQuery("SELECT name, lastname, secondname, status FROM users WHERE email='"+login+"'AND password='"+password+"'");

	    	if (rs.next()){
	    		data = new UserData(rs.getString("name"), rs.getString("lastname"),rs.getString("secondname"), rs.getString("status"));
	    	}
	    	
	    } 
                catch (ClassNotFoundException e) {
	    	System.out.println("55log");
	    	throw new DAOException("Ошибка загрузки драйвера."); 
            } catch (InstantiationException e) {
	    	System.out.println("44log");
	    	throw new DAOException("Ошибка загрузки драйвера.");
	    } catch (SQLException e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
            } 
                catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	throw new DAOException("Ошибка работы с источником данных.");
	    }
                finally {
	    	try {
	    		if (rs != null) rs.close();
	    		if (st != null) st.close();
	    		if (con != null) con.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    } 

		return data;
	}


}

