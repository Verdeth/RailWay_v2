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
import to.StantionList;
import to.StantionData;

/**
 *
 * @author MSI
 */
public class StantionDAO {
    public static StantionList stantionList(String idTrain) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		StantionList stantionList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str = "";
              str = "SELECT Time(stantiontrain.Time), stantions.NameStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " + idTrain +
                      " ORDER BY stantiontrain.Time";
	    
              System.out.println(str);
              rs = st.executeQuery(str);
	    //	String begin = "", end = "";
   // public int[] tickets;
	    	List<StantionData> stantions = new ArrayList<StantionData>();
	    	StantionData stantion = null;
               // ResultSet rs2 = null;
              //  Statement st2 = null;
              //  st2 = con.createStatement();
	    	while (rs.next()){

              System.out.println("sql2");
	    		stantion = new StantionData(rs.getString("Time(stantiontrain.Time)").substring(0, 5), rs.getString("stantions.NameStantion"));                                          
	    		stantions.add(stantion);
                        
              System.out.println("sql3");
	    	}
	    	
	    	stantionList = new StantionList(stantions);
	    	
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

		return stantionList;
	
	} 
    
    
    public static void stantionEdit(String idTrain, String[] newTime) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		StantionList stantionList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str = "";
              str = "SELECT stantiontrain.Time, stantions.NameStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " + idTrain +
                      " ORDER BY stantiontrain.Time";
	    	System.out.println(str);
              rs = st.executeQuery(str);
              System.out.println(str);
	    //	String begin = "", end = "";
   // public int[] tickets;
	    	List<StantionData> stantions = new ArrayList<StantionData>();
	    	StantionData stantion = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                int i = 0; 
                System.out.println(str);
                st2 = con.createStatement();
                String t = newTime[0];
                    System.out.println("1");
	    	while (rs.next()){
                       str = "UPDATE stantiontrain INNER JOIN stantions ON stantions.idStantion = stantiontrain.idStantion SET stantiontrain.Time = '0000-00-00 " + newTime[i] + "' WHERE stantiontrain.idTrain = " + idTrain + " AND stantions.NameStantion = '" + rs.getString("stantions.NameStantion") + "'";
                        System.out.println(str);
                       st2.executeUpdate(str);
                       i++;
//              System.out.println("sql2");
//	    		
//              stantion = new StantionData(rs.getString("stantiontrain.Time"), rs.getString("stantions.NameStantion"));                                          
//	    		stantions.add(stantion);
                        
              System.out.println("sql3");
	    	}
	    	
	    	stantionList = new StantionList(stantions);
	    	
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

	}  
  
    
    public static int stantionCount(String idTrain) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
				try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str = "";
              str = "SELECT Count(stantions.idStantion) FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " + idTrain;
	    	System.out.println(str);
              rs = st.executeQuery(str);
              System.out.println(str);
              while (rs.next()){
                return rs.getInt("Count(stantions.idStantion)");
              }
              }           
	     catch (ClassNotFoundException e) {
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
return 0;
}
}
