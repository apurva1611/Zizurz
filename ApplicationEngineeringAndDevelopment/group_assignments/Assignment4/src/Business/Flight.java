/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author 15085
 */
public class Flight implements Comparable<Flight>{

    private String flyDate;
    private String departuretime;
    private String departureCity;
    private String arrivalCity;
    private Airplane airplane;
    private String arrivaltime;
    private String airlineName;
    private Seat seat;
    private double price;

    public Flight() {
        seat = new Seat();
        populateSeats();
    }

    public Flight(Double price, String flyDate, String departuretime, String departureCity, String arrivaltime, String arrivalCity, Airplane airplane,String airlinerName) {
        seat = new Seat();
        this.airlineName = airlinerName;
        this.airplane = airplane;
        this.arrivalCity = arrivalCity;
        this.arrivaltime = arrivaltime;
        this.departureCity = departureCity;
        this.flyDate = flyDate;
        this.departuretime = departuretime;
        this.price = price;
        populateSeats();
    }

    public void populateSeats() {
        for (int i = 1; i <= 25; i++) {
            for (int j = 1; j <= 2; j++) {
                String col;
                if (j == 1) {
                    col = "A";
                } else {
                    col = "B";
                }
                seat.getSeatNumber().put(i + "" + col, 1);
            }
        }
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getFlyDate() {
        return flyDate;
    }

    public void setFlyDate(String flyDate) {
        this.flyDate = flyDate;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

    public String toString() {
        return airplane.getModelNumber();
    }
    
    @Override
    public int compareTo(Flight o) {
        return Double.compare(o.getPrice(), this.getPrice());
    }
    public static int sortByPriceLowToHigh(Flight o,Flight o1) {
        return Double.compare(o.getPrice(), o1.getPrice());
    }

}
