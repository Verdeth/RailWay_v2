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
import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat; 
import java.util.Date;
import java.text.SimpleDateFormat;
import to.TrainData;
import to.TrainList;
/**
 *
 * @author MSI
 */
public class TrainDAO {
 public static TrainList trainList() throws DAOException{
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
	    	rs = st.executeQuery("SELECT trains.idTrain, trains.idType, tickets.Date FROM trains INNER JOIN tickets ON trains.idTrain = tickets.idTrain GROUP BY tickets.Date");
	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        String str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        //System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");

                        
                        
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
  
 public static TrainList trainAdminList() throws DAOException{
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
	    	rs = st.executeQuery("SELECT trains.idTrain, trains.idType FROM trains");
	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        String str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        //System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                       

                        
                        
	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end);                                          
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
  
 public static TrainList trainListSearch(String beginSearch, String endSearch, String date, String type, String count) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TrainList trainList = null;
                beginSearch = beginSearch.toLowerCase();
                endSearch = endSearch.toLowerCase();
                int typeInt = Integer.parseInt(type);
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "SELECT trains.idTrain, trains.idType, tickets.Date, typeticket.TypeTicket, tickets.Count, stantions.NameStantion, Time(stantiontrain.Time)  "
                        + "FROM trains INNER JOIN tickets ON trains.idTrain = tickets.idTrain INNER JOIN typeticket ON typeticket.idTypeTicket = tickets.idTypeTicket "
                        + "INNER JOIN stantiontrain ON stantiontrain.idTrain = trains.idTrain inner join stantions on stantions.idStantion = stantiontrain.idStantion "
                        + "where tickets.Date = '" + date + "' AND tickets.idTypeTicket = " + type + " AND tickets.Count >= " + count + " GROUP BY tickets.Date, trains.idTrain ORDER BY stantiontrain.Time ASC";
	    System.out.println(str);	
              rs = st.executeQuery(str);
	    	String begin = "", end = "";
                System.out.println(str);
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                            System.out.println("sqleeeee");
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");
                        
                        
                        boolean first = false;
                        String stOne = "";
                        String stTwo = "";
                        String timeOne = "";
                        String timeTwo = "";
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion, Time(stantiontrain.Time) FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        String nameStantion = "";
                        while (rs2.next())
                        {
                                nameStantion = rs2.getString("stantions.NameStantion").toLowerCase();
                                if (!first)
                                {
                                    if(nameStantion.indexOf(beginSearch) != -1)
                                    {
                                        first = true;
                                        stOne = rs2.getString("stantions.NameStantion");
                                        timeOne = rs2.getString("Time(stantiontrain.Time)").substring(0, 5);                                    
                                    }
                                }                                
                                else
                                {
                                    if(nameStantion.indexOf(endSearch) != -1)
                                    {
                                        stTwo = rs2.getString("stantions.NameStantion");
                                        timeTwo = rs2.getString("Time(stantiontrain.Time)").substring(0, 5);
                                        
                                         TimeZone tz = TimeZone.getTimeZone("Europe/Minsk");

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Date moment1 = dateFormat.parse(timeOne);
        Date moment2 = dateFormat.parse(timeTwo);
        long interval = moment2.getTime() - moment1.getTime(); 
        if (typeInt == 4) {typeInt = 2;}                                
                                       // int price = rs.getInt("trains.idTrain")*typeInt*(int)interval;
                                        train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket, stOne, stTwo, timeOne, timeTwo, Math.round(((1 + 0.1*(rs.getInt("trains.idType"))*typeInt*(int)interval)/1000000.0*0.5)*100.0) / 100.0);    
                                        trains.add(train);
                                        break;
                                    }
                                }
                                
                        }
	    		
	    	}
	    	
	    	trainList = new TrainList(trains);
	    	
	    } catch (ClassNotFoundException e) {
	    	System.out.println("551");
                System.out.println("10");
	    	throw new DAOException("Ошибка загрузки драйвера.");
	    } catch (SQLException e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
	    } 
                catch (Exception e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
                }finally {
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

 public static TrainData trainForTicket(String id, String beginSearch, String endSearch, String date, String type, String count) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
                beginSearch = beginSearch.toLowerCase();
                endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
              int typeInt = Integer.parseInt(type);
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "SELECT trains.idTrain, trains.idType, tickets.Date, typeticket.TypeTicket, tickets.Count, stantions.NameStantion, stantiontrain.Time  "
                        + "FROM trains INNER JOIN tickets ON trains.idTrain = tickets.idTrain INNER JOIN typeticket ON typeticket.idTypeTicket = tickets.idTypeTicket "
                        + "INNER JOIN stantiontrain ON stantiontrain.idTrain = trains.idTrain inner join stantions on stantions.idStantion = stantiontrain.idStantion "
                        + "where tickets.Date = '" + date + "' AND tickets.idTypeTicket = " + type + " AND tickets.Count >= " + count + " AND trains.idTrain = " + id + " GROUP BY tickets.Date, trains.idTrain ORDER BY stantiontrain.Time ASC";
	    System.out.println(str);	
              rs = st.executeQuery(str);
	    	String begin = "", end = "";
                System.out.println(str);
   // public int[] tickets;
	    //	List<TrainData> trains = new ArrayList<TrainData>();
	    	
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                            System.out.println("sql77777");
                        while (rs2.next()){
                            System.out.println("sql77777");
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");
                        
                        
                        boolean first = false;
                        String stOne = "";
                        String stTwo = "";
                        String timeOne = "";
                        String timeTwo = "";
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion, Time(stantiontrain.Time) FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        String nameStantion = "";
                        while (rs2.next())
                        {
                                nameStantion = rs2.getString("stantions.NameStantion").toLowerCase();
                                if (!first)
                                {
                                    if(nameStantion.indexOf(beginSearch) != -1)
                                    {
                                        first = true;
                                        stOne = rs2.getString("stantions.NameStantion");
                                        timeOne = rs2.getString("Time(stantiontrain.Time)").substring(0, 5);                                    
                                    }
                                }                                
                                else
                                {
                                    if(nameStantion.indexOf(endSearch) != -1)
                                    {
                                        stTwo = rs2.getString("stantions.NameStantion");
                                        timeTwo = rs2.getString("Time(stantiontrain.Time)").substring(0, 5);                                        
                                        break;
                                    }
                                }
                                
                        }
                        TimeZone tz = TimeZone.getTimeZone("Europe/Minsk");

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Date moment1 = dateFormat.parse(timeOne);
        Date moment2 = dateFormat.parse(timeTwo);
        long interval = moment2.getTime() - moment1.getTime(); 
        if (typeInt == 4) {typeInt = 2;}                                
                                       // int price = rs.getInt("trains.idTrain")*typeInt*(int)interval;
                                        train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket, stOne, stTwo, timeOne, timeTwo, Math.round(((1 + 0.1*(rs.getInt("trains.idType"))*typeInt*(int)interval)/1000000.0*0.5)*100.0) / 100.0);    
                                        
	    	}
	    	
	    	
	    } catch (ClassNotFoundException e) {
	    	System.out.println("551");
                System.out.println("10");
	    	throw new DAOException("Ошибка загрузки драйвера.");
	    } catch (SQLException e) {
	    	System.out.println("66");
	    	throw new DAOException("Ошибка работы с источником данных.");
	    }catch (Exception e) {
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

		return train;
	}  

 public static String idForTicket(String id, String beginSearch, String endSearch, String date, String type, String count) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
                beginSearch = beginSearch.toLowerCase();
                endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
            String idTicket ="";
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "SELECT tickets.idTickets, trains.idTrain, trains.idType, tickets.Date, typeticket.TypeTicket, tickets.Count, stantions.NameStantion, stantiontrain.Time  "
                        + "FROM trains INNER JOIN tickets ON trains.idTrain = tickets.idTrain INNER JOIN typeticket ON typeticket.idTypeTicket = tickets.idTypeTicket "
                        + "INNER JOIN stantiontrain ON stantiontrain.idTrain = trains.idTrain inner join stantions on stantions.idStantion = stantiontrain.idStantion "
                        + "where tickets.Date = '" + date + "' AND tickets.idTypeTicket = " + type + " AND tickets.Count >= " + count + " AND trains.idTrain = " + id + " GROUP BY tickets.Date, trains.idTrain ORDER BY stantiontrain.Time ASC";
	    System.out.println(str);	
              rs = st.executeQuery(str);
	    	String begin = "", end = "";
                System.out.println(str);
   // public int[] tickets;
	    //	List<TrainData> trains = new ArrayList<TrainData>();
	    	
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");
                        
                        
                        boolean first = false;
                        String stOne = "";
                        String stTwo = "";
                        String timeOne = "";
                        String timeTwo = "";
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion, stantiontrain.Time FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        String nameStantion = "";
                        while (rs2.next())
                        {
                                nameStantion = rs2.getString("stantions.NameStantion").toLowerCase();
                                if (!first)
                                {
                                    if(nameStantion.indexOf(beginSearch) != -1)
                                    {
                                        first = true;
                                        stOne = rs2.getString("stantions.NameStantion");
                                        timeOne = rs2.getString("stantiontrain.Time");                                    
                                    }
                                }                                
                                else
                                {
                                    if(nameStantion.indexOf(endSearch) != -1)
                                    {
                                        stTwo = rs2.getString("stantions.NameStantion");
                                        timeTwo = rs2.getString("stantiontrain.Time");
                                        idTicket = rs.getString("tickets.idTickets");                                        
                                        break;
                                    }
                                }
                                
                        }
                       // train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket, stOne, stTwo, timeOne, timeTwo);   
	    		
	    	}
	    	
	    	
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

		return idTicket;
	}  

 public static TrainData trainforNew(String id) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TrainList trainList = null;
                TrainData train = null;

	    
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
                str = "SELECT trains.idTrain, trains.idType FROM trains WHERE idTrain = " + id;
	    	rs = st.executeQuery(str);
	    	String begin = "", end = "";
   // public int[] tickets;
	    	//List<TrainData> trains = new ArrayList<TrainData>();
	    	                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                      
                        int idTrain = rs.getInt("trains.idTrain");
                        //System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                       

                        
                        
	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end);                                          
	    		//trains.add(train);
	    	}
	    	
	    	//trainList = new TrainList(trains);
	    	
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

		return train;
	}  
  
 public static TrainData train(String id) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
              //  beginSearch = beginSearch.toLowerCase();
               // endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "SELECT trains.idTrain, trains.idType, tickets.Date, typeticket.TypeTicket, tickets.Count, stantions.NameStantion, stantiontrain.Time  "
                        + "FROM trains INNER JOIN tickets ON trains.idTrain = tickets.idTrain INNER JOIN typeticket ON typeticket.idTypeTicket = tickets.idTypeTicket "
                        + "INNER JOIN stantiontrain ON stantiontrain.idTrain = trains.idTrain inner join stantions on stantions.idStantion = stantiontrain.idStantion "
                        + "where trains.idTrain = " + id + " GROUP BY tickets.Date, trains.idTrain ORDER BY stantiontrain.Time ASC";
	    System.out.println(str);	
              rs = st.executeQuery(str);
	    	String begin = "", end = "";
                System.out.println(str);
   // public int[] tickets;
	    //	List<TrainData> trains = new ArrayList<TrainData>();
	    	
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");
                        
                        /*
                        boolean first = false;
                        String stOne = "";
                        String stTwo = "";
                        String timeOne = "";
                        String timeTwo = "";
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion, stantiontrain.Time FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        String nameStantion = "";
                        while (rs2.next())
                        {
                                nameStantion = rs2.getString("stantions.NameStantion").toLowerCase();
                                if (!first)
                                {
                                    if(nameStantion.indexOf(beginSearch) != -1)
                                    {
                                        first = true;
                                        stOne = rs2.getString("stantions.NameStantion");
                                        timeOne = rs2.getString("stantiontrain.Time");                                    
                                    }
                                }                                
                                else
                                {
                                    if(nameStantion.indexOf(endSearch) != -1)
                                    {
                                        stTwo = rs2.getString("stantions.NameStantion");
                                        timeTwo = rs2.getString("stantiontrain.Time");                                        
                                        break;
                                    }
                                }
                                
                        }
*/
                        train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);   
	    		
	    	}
	    	
	    	
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

		return train;
	}  
    
 public static TrainData train(String id, String date) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
              //  beginSearch = beginSearch.toLowerCase();
               // endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "SELECT trains.idTrain, trains.idType, tickets.Date FROM trains " +
"INNER JOIN tickets ON trains.idTrain = tickets.idTrain  " +
"where trains.idTrain = " + id + " and tickets.Date = '" + date + "' GROUP BY tickets.Date, trains.idTrain";
	    System.out.println(str);	
              rs = st.executeQuery(str);
	    	String begin = "", end = "";
                System.out.println(str);
   // public int[] tickets;
	    //	List<TrainData> trains = new ArrayList<TrainData>();
	    	
                ResultSet rs2 = null;
                Statement st2 = null;
                st2 = con.createStatement();
	    	while (rs.next()){
                    begin = ""; end = "";
                        int ticket[] = {0,0,0,0}; 
                        str = "";
                        int idTrain = rs.getInt("trains.idTrain");
                        System.out.println(idTrain);
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        //System.out.println(str);
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        //System.out.println(str);
                        if (rs2.next())
                        {
                            begin = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql3");
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time DESC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        if (rs2.next())
                        {
                        end = rs2.getString("stantions.NameStantion");
                        }
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                           ticket[rs2.getInt("idTypeTicket")-1] = rs2.getInt("count");
                        }
                        System.out.println("sql7");
                        
                        /*
                        boolean first = false;
                        String stOne = "";
                        String stTwo = "";
                        String timeOne = "";
                        String timeTwo = "";
                        str = "SELECT stantions.NameStantion, stantiontrain.idStantion, stantiontrain.Time FROM stantions INNER JOIN stantiontrain ON stantions.idStantion = stantiontrain.idStantion WHERE stantiontrain.idTrain = " +
                                idTrain + " ORDER BY stantiontrain.Time ASC";
                        System.out.println(str);
                        rs2 = st2.executeQuery(str);
                        String nameStantion = "";
                        while (rs2.next())
                        {
                                nameStantion = rs2.getString("stantions.NameStantion").toLowerCase();
                                if (!first)
                                {
                                    if(nameStantion.indexOf(beginSearch) != -1)
                                    {
                                        first = true;
                                        stOne = rs2.getString("stantions.NameStantion");
                                        timeOne = rs2.getString("stantiontrain.Time");                                    
                                    }
                                }                                
                                else
                                {
                                    if(nameStantion.indexOf(endSearch) != -1)
                                    {
                                        stTwo = rs2.getString("stantions.NameStantion");
                                        timeTwo = rs2.getString("stantiontrain.Time");                                        
                                        break;
                                    }
                                }
                                
                        }
*/
                        train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);   
	    		
	    	}
	    	
	    	
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

		return train;
	}  
     
 public static void trainTicketEdit(String id, String date, String c1, String c2, String c3, String c4) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
              //  beginSearch = beginSearch.toLowerCase();
               // endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str = "UPDATE tickets SET Count = Count + " + c1 + " WHERE Date = '" +
                      date + "' AND idTrain = " + id + " AND idTypeTicket = 1";
              System.out.println(str);
              st.executeUpdate(str);
              str = "UPDATE tickets SET Count = Count + " + c2 + " WHERE Date = '" +
                      date + "' AND idTrain = " + id + " AND idTypeTicket = 2";
             System.out.println(str);
              st.executeUpdate(str);
              str = "UPDATE tickets SET Count = Count + " + c3 + " WHERE Date = '" +
                      date + "' AND idTrain = " + id + " AND idTypeTicket = 3";
             System.out.println(str);
              st.executeUpdate(str);
              str = "UPDATE tickets SET Count = Count + " + c4 + " WHERE Date = '" +
                      date + "' AND idTrain = " + id + " AND idTypeTicket = 4";             
              System.out.println(str);
              st.executeUpdate(str);
	    	
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
	}  
   
 public static void trainNew(String id, String date, String c1, String c2, String c3, String c4) throws DAOException{
                Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
              //  beginSearch = beginSearch.toLowerCase();
               // endSearch = endSearch.toLowerCase();
	    TrainData train = new TrainData();
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String str ="";
              str ="INSERT INTO tickets (Date, Count, idTypeTicket, idTrain) VALUES ('" + date + "', " + c1 + ", 1, " + id + ")";
              System.out.println(str);
              st.executeUpdate(str);
              str ="INSERT INTO tickets (Date, Count, idTypeTicket, idTrain) VALUES ('" + date + "', " + c2 + ", 2, " + id + ")";
             System.out.println(str);
              st.executeUpdate(str);
              str ="INSERT INTO tickets (Date, Count, idTypeTicket, idTrain) VALUES ('" + date + "', " + c3 + ", 3, " + id + ")";
             System.out.println(str);
              st.executeUpdate(str);
              str ="INSERT INTO tickets (Date, Count, idTypeTicket, idTrain) VALUES ('" + date + "', " + c4 + ", 4, " + id + ")";
              System.out.println(str);
              st.executeUpdate(str);
	    	
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
	}  
}
