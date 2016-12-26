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
import to.TrainData;
import to.TrainList;

/**
 *
 * @author MSI
 */
public class RequestDAO {
   /* public static RequestList requestList() throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TrainList trainList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
	    	rs = st.executeQuery("SELECT trains.idTrain, trains.idType, tickets.Date FROM trains, tickets GROUP BY tickets.Date");
	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                        int ticket[] = {0,0,0,0}; 
                        String str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println("sql2");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = " + rs.getString("tickets.Date");
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        while (rs2.next()){
                            ticket[rs2.getInt("idTicket")] = rs2.getInt("count");
                        }
                        

	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);                                          
	    		trains.add(train);
	    	}
	    	
	    	trainList = new TrainList(trains);
	    	
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

		return trainList;
	
	}  
    
    public static bool confirmRequest() throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TrainList trainList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
	    	rs = st.executeQuery("SELECT trains.idTrain, trains.idType, tickets.Date FROM trains, tickets GROUP BY tickets.Date");
	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                        int ticket[] = {0,0,0,0}; 
                        String str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println("sql2");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = " + rs.getString("tickets.Date");
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        while (rs2.next()){
                            ticket[rs2.getInt("idTicket")] = rs2.getInt("count");
                        }
                        

	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);                                          
	    		trains.add(train);
	    	}
	    	
	    	trainList = new TrainList(trains);
	    	
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

		return trainList;
	
	}  
        
    public static bool refuseRequest() throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TrainList trainList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
	    	rs = st.executeQuery("SELECT trains.idTrain, trains.idType, tickets.Date FROM trains, tickets GROUP BY tickets.Date");
	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                        int ticket[] = {0,0,0,0}; 
                        String str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println("sql2");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions, stantiontrain WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantions.NameStantion DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = " + rs.getString("tickets.Date");
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        while (rs2.next()){
                            ticket[rs2.getInt("idTicket")] = rs2.getInt("count");
                        }
                        

	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);                                          
	    		trains.add(train);
	    	}
	    	
	    	trainList = new TrainList(trains);
	    	
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

		return trainList;
	
	}  */
}
