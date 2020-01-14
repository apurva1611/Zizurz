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
public class AirlinerDirectory {
    
    private ArrayList<Airliner> airlinerList;
    private MasterFlightSchedule flightSchedules;
    
    public AirlinerDirectory(MasterFlightSchedule flightSchedules){
        this.airlinerList = new ArrayList<Airliner>();
        this.flightSchedules= flightSchedules;
        Airliner a1 = new Airliner("Air Asia");
        Airplane ap10 = new Airplane("AA001", 1);
        Flight fa1 = new Flight(1111.00, "10/20/2019", "0:00", "Boston", "5:00", "Austin", ap10,a1.getAirLinerName());
        Flight fa2 = new Flight(1000.00, "10/22/2019", "0:30", "Boston", "6:00", "Austin", ap10,a1.getAirLinerName());
        Airplane ap20 = new Airplane("AA002", 2);
        Flight fa3 = new Flight(1000.00, "10/21/2019", "5:00", "Phoenix", "9:00", "New York", ap20,a1.getAirLinerName());
        Flight fa4 = new Flight(300.00, "10/23/2019", "09:00", "Boston", "11:00", "New York", ap20,a1.getAirLinerName());
        Airplane ap30 = new Airplane("AA003", 3);
        Flight fa5 = new Flight(600.00, "10/20/2019", "07:00", "San Francisco", "19:00", "New York", ap30,a1.getAirLinerName());
        Flight fa6 = new Flight(499.99, "10/21/2019", "11:00", "Chicago", "13:00", "New York", ap30,a1.getAirLinerName());
        Airplane ap40 = new Airplane("AA004", 4);
        Flight fa7 = new Flight(100.00, "10/23/2019", "19:00", "New York", "21:00", "Boston", ap40,a1.getAirLinerName());
        Airplane ap50 = new Airplane("AA005", 5);
        a1.getFleet().getAirplanes().add(ap10);
        a1.getFleet().getAirplanes().add(ap20);
        a1.getFleet().getAirplanes().add(ap30);
        a1.getFleet().getAirplanes().add(ap40);
        a1.getFleet().getAirplanes().add(ap50);
        a1.getFlights().getFlights().add(fa1);
        a1.getFlights().getFlights().add(fa2);
        a1.getFlights().getFlights().add(fa3);
        a1.getFlights().getFlights().add(fa4);
        a1.getFlights().getFlights().add(fa5);
        a1.getFlights().getFlights().add(fa6);
        a1.getFlights().getFlights().add(fa7);
        
        Airliner a2 = new Airliner("Air Canada");
        Airplane ap11 = new Airplane("AC001", 1);
        Flight fc1 = new Flight(1000.00, "10/19/2019", "19:00", "Dallas", "20:00", "Austin", ap11,a2.getAirLinerName());
        Flight fc2 = new Flight(120.00, "10/24/2019", "08:00", "San Jose", "18:00", "Houston", ap11,a2.getAirLinerName());
        Airplane ap21 = new Airplane("AC002", 2);
        Flight fc3 = new Flight(237.00, "10/28/2019", "08:00", "Boston", "18:00", "Houston", ap21,a2.getAirLinerName());
        Airplane ap31 = new Airplane("AC003", 3);
        Flight fc4 = new Flight(357.00, "10/30/2019", "08:00", "San Jose", "18:00", "Dallas", ap31,a2.getAirLinerName());
        Airplane ap41 = new Airplane("AC004", 4);
        Airplane ap51 = new Airplane("AC005", 5);
        Flight fc5 = new Flight(299.20, "10/29/2019", "08:00", "San Jose", "18:00", "Chicago", ap51,a2.getAirLinerName());
        a2.getFleet().getAirplanes().add(ap11);
        a2.getFleet().getAirplanes().add(ap21);
        a2.getFleet().getAirplanes().add(ap31);
        a2.getFleet().getAirplanes().add(ap41);
        a2.getFleet().getAirplanes().add(ap51);
        a2.getFlights().getFlights().add(fc1);
        a2.getFlights().getFlights().add(fc2);
        a2.getFlights().getFlights().add(fc3);
        a2.getFlights().getFlights().add(fc4);
        a2.getFlights().getFlights().add(fc5);
        
        Airliner a3 = new Airliner("Indigo");
        Airplane ap12 = new Airplane("I001", 1);
        Flight fi1 = new Flight(1000.00, "10/23/2019", "06:00", "Boston", "10:00", "New York", ap12,a3.getAirLinerName());
        Airplane ap22 = new Airplane("I002", 2);
        Flight fi2 = new Flight(1000.00, "10/20/2019", "12:00", "Chicago", "20:00", "Austin", ap22,a3.getAirLinerName());
        Flight fi3 = new Flight(1000.00, "10/21/2019", "04:00", "San Jose", "16:00", "Boston", ap22,a3.getAirLinerName());
        Airplane ap32 = new Airplane("I003", 3);
        Flight fi4 = new Flight(1000.00, "10/21/2019", "04:00", "San Jose", "16:00", "Ohio", ap32,a3.getAirLinerName());
        Airplane ap42 = new Airplane("I004", 4);
        Flight fi5 = new Flight(1000.00, "10/21/2019", "12:00", "Boston", "16:00", "New York", ap42,a3.getAirLinerName());
        Airplane ap52 = new Airplane("I005", 5);
        Flight fi6 = new Flight(1000.00, "10/28/2019", "0:00", "Boston", "18:00", "Houston", ap52,a3.getAirLinerName());
        a3.getFleet().getAirplanes().add(ap12);
        a3.getFleet().getAirplanes().add(ap22);
        a3.getFleet().getAirplanes().add(ap32);
        a3.getFleet().getAirplanes().add(ap42);
        a3.getFleet().getAirplanes().add(ap52);
        a3.getFlights().getFlights().add(fi1);
        a3.getFlights().getFlights().add(fi2);
        a3.getFlights().getFlights().add(fi3);
        a3.getFlights().getFlights().add(fi4);
        a3.getFlights().getFlights().add(fi5);
        a3.getFlights().getFlights().add(fi6);
        
        Airliner a4 = new Airliner("Air India");
        Airplane ap13 = new Airplane("AI001", 1);
        Flight ai1 = new Flight(1000.00, "10/20/2019", "12:00", "Boston", "3:00", "New York", ap13,a4.getAirLinerName());
        Airplane ap23 = new Airplane("AI002", 2);
        Flight ai2 = new Flight(1000.00, "10/23/2019", "07:00", "Boston", "4:00", "New York", ap23,a4.getAirLinerName());
        Airplane ap33 = new Airplane("AI003", 3);
        Flight ai3 = new Flight(1000.00, "10/21/2019", "06:00", "San Jose", "11:30", "Ohio", ap33,a4.getAirLinerName());
        Airplane ap43 = new Airplane("AI004", 4);
        Flight ai4 = new Flight(1000.00, "10/21/2019", "06:00", "San Jose", "11:30", "Ohio", ap43,a4.getAirLinerName());
        Airplane ap53 = new Airplane("AI005", 5);
        Flight ai5 = new Flight(1000.00, "10/20/2019", "10:30", "Boston", "18:00", "Austin", ap53,a4.getAirLinerName());
        a4.getFleet().getAirplanes().add(ap13);
        a4.getFleet().getAirplanes().add(ap23);
        a4.getFleet().getAirplanes().add(ap33);
        a4.getFleet().getAirplanes().add(ap43);
        a4.getFleet().getAirplanes().add(ap53);
        a4.getFlights().getFlights().add(ai1);
        a4.getFlights().getFlights().add(ai2);
        a4.getFlights().getFlights().add(ai3);
        a4.getFlights().getFlights().add(ai4);
        a4.getFlights().getFlights().add(ai5);
        
        Airliner a5 = new Airliner("Qatar");
        Airplane ap14 = new Airplane("Q001", 1);
        Flight fq1 = new Flight(1000.00, "10/19/2019", "18:30", "Dallas", "20:30", "Austin", ap14,a5.getAirLinerName());
        Flight fq2 = new Flight(1000.00, "10/24/2019", "08:30", "San Jose", "17:00", "Houston", ap14,a5.getAirLinerName());
        Airplane ap24 = new Airplane("Q002", 2);
        Flight fq3 = new Flight(1000.00, "10/20/2019", "07:00", "San Francisco", "19:00", "New York", ap24,a5.getAirLinerName());
        Flight fq4 = new Flight(1000.00, "10/21/2019", "11:00", "Chicago", "13:00", "New York", ap24,a5.getAirLinerName());
        Airplane ap34 = new Airplane("Q003", 3);
        Flight fq5 = new Flight(1000.00, "10/20/2019", "12:00", "Chicago", "20:00", "Austin", ap34,a5.getAirLinerName());
        Flight fq6 = new Flight(1000.00, "10/21/2019", "04:00", "San Jose", "16:00", "Boston", ap34,a5.getAirLinerName());
        Airplane ap44 = new Airplane("Q004", 4);
        Flight fq7 = new Flight(1000.00, "10/23/2019", "19:00", "New York", "21:00", "Boston", ap44,a5.getAirLinerName());
        Airplane ap54 = new Airplane("Q005", 5);
        Flight fq8 = new Flight(1000.00, "10/21/2019", "14:00", "Phoenix", "16:30", "New York", ap54,a5.getAirLinerName());
        Flight fq9 = new Flight(1000.00, "10/23/2019", "12:15", "Boston", "16:15", "New York", ap54,a5.getAirLinerName());
        a5.getFleet().getAirplanes().add(ap14);
        a5.getFleet().getAirplanes().add(ap24);
        a5.getFleet().getAirplanes().add(ap34);
        a5.getFleet().getAirplanes().add(ap44);
        a5.getFleet().getAirplanes().add(ap54);
        a5.getFlights().getFlights().add(fq1);
        a5.getFlights().getFlights().add(fq2);
        a5.getFlights().getFlights().add(fq3);
        a5.getFlights().getFlights().add(fq4);
        a5.getFlights().getFlights().add(fq5);
        a5.getFlights().getFlights().add(fq6);
        a5.getFlights().getFlights().add(fq7);
        a5.getFlights().getFlights().add(fq8);
        a5.getFlights().getFlights().add(fq9);

        airlinerList.add(a1);
        airlinerList.add(a2);
        airlinerList.add(a3);
        airlinerList.add(a4);
        airlinerList.add(a5);
       this.flightSchedules.getFlightSchedules().put(a1.getAirLinerName(), a1.getFlights());
       this.flightSchedules.getFlightSchedules().put(a2.getAirLinerName(), a2.getFlights());
       this.flightSchedules.getFlightSchedules().put(a3.getAirLinerName(), a3.getFlights());
       this.flightSchedules.getFlightSchedules().put(a4.getAirLinerName(), a4.getFlights());
       this.flightSchedules.getFlightSchedules().put(a5.getAirLinerName(), a5.getFlights());
    }

    public ArrayList<Airliner> getAirlinerList() {
        return airlinerList;
    }

    public void setAirlinerList(ArrayList<Airliner> airlinerList) {
        this.airlinerList = airlinerList;
    }
    public Airliner registerAirlines(){
        Airliner al = new Airliner();
        airlinerList.add(al);
        return al;
        
    }
    public void deleteAirline(Airliner airline){
        airline.getFleet().getAirplanes().removeAll(airline.getFleet().getAirplanes());
        airline.getFlights().getFlights().removeAll(airline.getFlights().getFlights());
        this.airlinerList.remove(airline);
        
    }
    public void deleteAirplane(Airplane airplane, Airliner airline){
        ArrayList<Flight> flights = new ArrayList<>();
        if(!airline.getFlights().getFlights().isEmpty()){
           for(Flight flight : airline.getFlights().getFlights()) {
                if(flight.getAirplane().getModelNumber().equals(airplane.getModelNumber())) {
                    flights.add(flight);
                }
            } 
        }
       for(Flight fl: flights){
           airline.getFlights().getFlights().remove(fl);
       }
       airline.getFleet().getAirplanes().remove(airplane);
    }
}

