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
public class Flight {
    private Date flyDate;
    private String time;
    private String departureCity;
    private String arrivalCity;
    private Airplane airplane;

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    
    public Date getFlyDate() {
        return flyDate;
    }

    public void setFlyDate(Date flyDate) {
        this.flyDate = flyDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    
    public String toString() {
        return airplane.getModelNumber();
    }
    
}
