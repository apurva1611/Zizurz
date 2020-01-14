/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Collection;
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
    public ArrayList<Flight> searchByAirlineName(String AirlineName){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        for(String key :flightSchedules.keySet()){
            if(key.equalsIgnoreCase(AirlineName)){
                tempFlights = flightSchedules.get(key).getFlights();
                return tempFlights;
            }
        }       
        return null;
}
public ArrayList<Flight> searchByDepartureCity(ArrayList<Flight> flights,String departureCity){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        for(Flight flight:flights){
            if(flight.getDepartureCity().equalsIgnoreCase(departureCity)){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByArrivialCity(ArrayList<Flight> flights,String arrivialCity){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        for(Flight flight:flights){
            if(flight.getArrivalCity().equalsIgnoreCase(arrivialCity)){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}

public ArrayList<Flight> searchByDepartureTimeEarlyMorning(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getDeparturetime().indexOf(":");
            int number = Integer.parseInt(flight.getDeparturetime().substring(0, indexOfDecimal));
            if((number>=0 && number<5 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByDepartureTimeMorning(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getDeparturetime().indexOf(":");
            int number = Integer.parseInt(flight.getDeparturetime().substring(0, indexOfDecimal));
            if((number>=5 && number <12 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByDepartureTimeAfternoon(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getDeparturetime().indexOf(":");
            int number = Integer.parseInt(flight.getDeparturetime().substring(0, indexOfDecimal));
            if((number>=12 && number <18 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByDepartureTimeEvening(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getDeparturetime().indexOf(":");
            int number = Integer.parseInt(flight.getDeparturetime().substring(0, indexOfDecimal));
            if((number>=18 && number <=23 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByArrivialTimeEarlyMorning(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getArrivaltime().indexOf(":");
            int number = Integer.parseInt(flight.getArrivaltime().substring(0, indexOfDecimal));
            if((number>=0 && number<5 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByArrivialTimeMorning(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getArrivaltime().indexOf(":");
            int number = Integer.parseInt(flight.getArrivaltime().substring(0, indexOfDecimal));
            if((number>=5 && number <12 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByArrivialTimeAfternoon(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getArrivaltime().indexOf(":");
            int number = Integer.parseInt(flight.getArrivaltime().substring(0, indexOfDecimal));
            if((number>=12 && number <18 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByArrivialTimeEvening(ArrayList<Flight> flights){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            int indexOfDecimal = flight.getArrivaltime().indexOf(":");
            int number = Integer.parseInt(flight.getArrivaltime().substring(0, indexOfDecimal));
            if((number>=18 && number <=23 )){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
public ArrayList<Flight> searchByDate(ArrayList<Flight> flights,String date){
        ArrayList<Flight> tempFlights= new ArrayList<>();
        
        for(Flight flight:flights){
            if((flight.getFlyDate().equals(date))){
                tempFlights.add(flight);
            }
        }
        return tempFlights;
}
    
    public HashMap<String,FlightSchedule> getFlightSchedules() {
        return flightSchedules;
    }

}