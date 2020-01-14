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
public class Fleet {
    private ArrayList<Airplane> airplanes;
    public Fleet(){
        airplanes = new ArrayList<>();
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(ArrayList<Airplane> airplanes) {
        this.airplanes = airplanes;
    }
    
    public Airplane findAirplaneByModelNumber(String modelnum){
        for(Airplane airplane: airplanes){
            if(airplane.getModelNumber().equals(modelnum)){
                return airplane;
            }
        }
        return null;
    }
    
}
