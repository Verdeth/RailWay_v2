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
import to.TicketData;
import to.TicketList;
/**
 *
 * @author MSI
 */




public class TicketDAO {
    
    public static TicketList ticketList(String id) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		TicketList ticketList = null;
	    
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
              str = "SELECT ticketuser.idTicket, ticketuser.Count, ticketuser.price, typeticket.TypeTicket, tickets.idTrain  FROM ticketuser INNER JOIN users ON ticketuser.idUser = users.idUser inner join tickets ON tickets.idTickets = ticketuser.idTicket " +
"inner join typeticket on typeticket.idTypeTicket = tickets.idTypeTicket" +
" WHERE email = '" + id + "'"; 
              System.out.println(str);
	    	rs = st.executeQuery(str);
	    	//String begin = "", end = "";
   // public int[] tickets;
	    	List<TicketData> tickets = new ArrayList<TicketData>();
	    	TicketData ticket = null;
                        TrainData train = null;
                
                //ResultSet rs2 = null;
               // Statement st2 = null;
               // st2 = con.createStatement();
	    	while (rs.next()){
                    
                        train = TrainDAO.train(rs.getString("tickets.idTrain"));
                    
	    		ticket = new TicketData(rs.getInt("ticketuser.idTicket"), rs.getInt("ticketuser.Count"), rs.getString("typeticket.TypeTicket"), train, rs.getDouble("ticketuser.price"));                                          
	    		tickets.add(ticket);
	    	}
	    	
	    	ticketList = new TicketList(tickets);
	    	
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

		return ticketList;
	
	}  

  
    
    
    
  public static void yesTicket(String id, String count, String email, String price) throws DAOException{
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
              String str = "";
              str = "UPDATE tickets SET count = count - " + count + " WHERE idTickets = " + id;
              System.out.println(str);
	    	st.executeUpdate(str);
                String user = "";
                str = "SELECT idUser FROM users WHERE email = '" + email + "'";
                System.out.println(str);
	    	rs = st.executeQuery(str);
                if (rs.next())
                        {
                        user = rs.getString("idUser");
                        }
                
                 str = "INSERT INTO ticketuser (idUser, idTicket, Count, price) VALUES (" + user + ", " + id + ", " + count + ", " + price + ")";
	    	System.out.println(str);
                 st.executeUpdate(str);
/*	    	String begin = "", end = "";
   // public int[] tickets;
	    	List<TrainData> trains = new ArrayList<TrainData>();
	    	TrainData train = null;
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
                        
                        System.out.println("sql4");
                        str = "SELECT count, idTypeTicket FROM tickets WHERE idTrain = " +
                                idTrain + " AND Date = '" + rs.getString("tickets.Date") + "'";
                        System.out.println(str);
                        System.out.println("sql5");
                        rs2 = st2.executeQuery(str);
                        System.out.println("sql6");
                        while (rs2.next()){
                           ticket[rs2.getInt("idTypeTicket")] = rs2.getInt("count");
                        }
                        System.out.println("sql7");

                        
                        
	    		train = new TrainData(rs.getInt("trains.idTrain"), rs.getInt("trains.idType"), begin, end, rs.getString("tickets.Date"), ticket);                                          
	    		trains.add(train);
	    	}
	    	
	    	trainList = new TrainList(trains);
	    */	
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

	//	return trainList;
	
	}  
 
  public static void deleteTicket(String id, String email) throws DAOException{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//TrainList trainList = null;
	    
		try {
              //      System.out.println("0");
			Class.forName("com.mysql.jdbc.Driver");
               //         System.out.println("1");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway?zeroDateTimeBehavior=convertToNull", "root", "root");
	    //	System.out.println("2");
                st = con.createStatement();
              //  System.out.println("3");
              System.out.println("sql1");
              String count = "";
              String str = "";
              str = "SELECT count FROM ticketuser INNER JOIN users ON ticketuser.idUser = users.idUser WHERE email = '" + email + "' AND ticketuser.idTicket = " + id;
              System.out.println(str);
              rs = st.executeQuery(str);
              if (rs.next())
              {
                  count = rs.getString("count");
              }
              str = "UPDATE tickets SET count = count + " + count + " WHERE idTickets = " + id;
              System.out.println(str);
	    	st.executeUpdate(str);
                String user = "";
                str = "SELECT idUser FROM users WHERE email = '" + email + "'";
                System.out.println(str);
	    	rs = st.executeQuery(str);
                if (rs.next())
                        {
                        user = rs.getString("idUser");
                        }
                
                 str = "DELETE FROM ticketuser WHERE idUser = " + user + " AND idTicket = " + id;
	    	System.out.println(str);
                 st.executeUpdate(str);
	    
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

	//	return trainList;
	
	}  
   
  
}
