/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

/**
 *
 * @author MSI
 */
public class TrainData extends ActionData {
    public int idTrain = 0;
    public int idType = 0;
    public String beginStantion = "";
    public String endStantion = "";
    public String date = "";
    public int[] tickets = null;
    public String nameStantionOne = "";
    public String nameStantionTwo = "";
    public String timeOne = "";
    public String timeTwo = "";
    public double price = 0.0;
    
    public TrainData ()
    {
    }
    
    public TrainData (int idTrain, int idType, String beginStantion, String endStantion)
    {
    this.idTrain = idTrain;
    this.idType = idType;
    this.beginStantion = beginStantion;
    this.endStantion = endStantion;    
    }
    
    
    public TrainData (int idTrain, int idType, String beginStantion, String endStantion, String date, int[] tickets)
    {
    this.idTrain = idTrain;
    this.idType = idType;
    this.beginStantion = beginStantion;
    this.endStantion = endStantion;
    this.date = date;
    this.tickets = new int[tickets.length];
    for (int i = 0; i < tickets.length; ++i)
    {
        this.tickets[i] = tickets[i];
    }    
    }
    
    public TrainData (int idTrain, int idType, String beginStantion, String endStantion, String date, int[] tickets, String nameStantionOne,String nameStantionTwo, String timeOne, String timeTwo)
    {
    this.idTrain = idTrain;
    this.idType = idType;
    this.beginStantion = beginStantion;
    this.endStantion = endStantion;
    this.date = date;
    this.tickets = new int[tickets.length];
    for (int i = 0; i < tickets.length; ++i)
    {
        this.tickets[i] = tickets[i];
    }    
    this.nameStantionOne = nameStantionOne;
    this.nameStantionTwo = nameStantionTwo;
    this.timeOne = timeOne;
    this.timeTwo = timeTwo;
    }
    
    public TrainData (int idTrain, int idType, String beginStantion, String endStantion, String date, int[] tickets, String nameStantionOne,String nameStantionTwo, String timeOne, String timeTwo, double price)
    {
    this.idTrain = idTrain;
    this.idType = idType;
    this.beginStantion = beginStantion;
    this.endStantion = endStantion;
    this.date = date;
    this.tickets = new int[tickets.length];
    for (int i = 0; i < tickets.length; ++i)
    {
        this.tickets[i] = tickets[i];
    }    
    this.nameStantionOne = nameStantionOne;
    this.nameStantionTwo = nameStantionTwo;
    this.timeOne = timeOne;
    this.timeTwo = timeTwo;
    this.price = price;
    }
    
    
    
}
