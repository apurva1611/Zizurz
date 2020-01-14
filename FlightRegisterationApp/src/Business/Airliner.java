/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Airliner {
 
    private String airLinerName;
    private Date operatingSince;
    private Fleet fleet;
    private FlightSchedule flights;
    
    public Airliner(){
        operatingSince = new Date();
        fleet =  new Fleet();
        flights = new FlightSchedule();
    }
    
    public Airliner(String airLinerName){
        operatingSince = new Date();
        fleet =  new Fleet();
        flights = new FlightSchedule();
    }

    public String getAirLinerName() {
        return airLinerName;
    }

    public void setAirLinerName(String airLinerName) {
        this.airLinerName = airLinerName;
    }

    public Date getOperatingSince() {
        return operatingSince;
    } 
    public  void setOperatingSince() {
        operatingSince = new Date();
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public FlightSchedule getFlights() {
        return flights;
    }

    public void setFlights(FlightSchedule flights) {
        this.flights = flights;
    }
    
    
    
    @Override
    public String toString(){
        return airLinerName;
    }
}
