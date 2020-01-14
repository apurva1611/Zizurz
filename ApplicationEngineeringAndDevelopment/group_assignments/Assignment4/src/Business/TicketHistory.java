/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TicketHistory {
    
    private ArrayList<Ticket> bookingHistory;
    
    public TicketHistory(){
        this.bookingHistory = new ArrayList<Ticket>();
    }

    public ArrayList<Ticket> getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(ArrayList<Ticket> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
}
