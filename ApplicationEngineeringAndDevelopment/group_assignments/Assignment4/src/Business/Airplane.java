/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author 15085
 */
public class Airplane {
    private String modelNumber;
    private double fuelCapacity;
    private int serialNumber;
    private int seatCapacity=50;
    
    public Airplane() {
       
    }
    public Airplane(String modelNumber, int serialNumber) {
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
        this.fuelCapacity = 150.00;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    
    
    public String toString() {
        return getModelNumber();
    }
    
}
