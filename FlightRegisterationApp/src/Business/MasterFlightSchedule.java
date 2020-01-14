/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author 15085
 */
public class MasterFlightSchedule {
    private HashMap<String,FlightSchedule> flightSchedules;
    public MasterFlightSchedule() {
        this.flightSchedules = new HashMap<>();
    }

    public HashMap<String,FlightSchedule> getFlightSchedules() {
        return flightSchedules;
    }

//    public void setFlightSchedules(FlightSchedule flightSchedules) {
//        this.flightSchedules = flightSchedules;
//    }    
}
