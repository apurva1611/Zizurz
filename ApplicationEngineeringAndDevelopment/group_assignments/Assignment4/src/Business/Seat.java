/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Seat {
    
    private HashMap<String,Integer> seatNumber;
    private int rowNumber;
    private int colNumber;
    
    public Seat(){
        this.seatNumber = new HashMap<String, Integer>();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public HashMap<String, Integer> getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(HashMap<String, Integer> seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }
}
