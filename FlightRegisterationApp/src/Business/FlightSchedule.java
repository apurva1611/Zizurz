/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author 15085
 */
public class FlightSchedule {
    private ArrayList<Flight> flights;

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    public FlightSchedule(){
        this.flights = new ArrayList<>();
    }
       
}
