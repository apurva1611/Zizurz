/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.HomelessPerson;

/**
 *
 * @author TILAK PARMAR
 */
public class BackgroundCheckWorkRequest extends WorkRequest{
    private HomelessPerson homelessPerson;
    private ShelterAllocateWorkRequest shelterAllocWorkReq;

    public HomelessPerson getHomelessPerson() {
        return homelessPerson;
    }

    public void setHomelessPerson(HomelessPerson homelessPerson) {
        this.homelessPerson = homelessPerson;
    }

    public ShelterAllocateWorkRequest getShelterAllocWorkReq() {
        return shelterAllocWorkReq;
    }

    public void setShelterAllocWorkReq(ShelterAllocateWorkRequest shelterAllocWorkReq) {
        this.shelterAllocWorkReq = shelterAllocWorkReq;
    }
    
    @Override
    public String toString() {
        return getHomelessPerson()!=null? getHomelessPerson().getName(): "No name";
    }
 
}
