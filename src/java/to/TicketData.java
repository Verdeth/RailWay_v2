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
public class TicketData extends ActionData {
    public TrainData train;
    public int idTicket = 0;
    public String typeTicket = "";    
    public int count = 0;
    public double price = 0.0;
        
    
    public TicketData (int idTicket, int count, String typeTicket, TrainData train, double price)
    {
        this.idTicket = idTicket;
    this.train = train;
    this.count = count;
    this.typeTicket = typeTicket;
    this.price = price;
    
    }
    
}