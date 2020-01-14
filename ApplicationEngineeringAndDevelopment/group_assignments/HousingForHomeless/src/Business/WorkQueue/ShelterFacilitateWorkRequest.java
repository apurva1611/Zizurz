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
public class ShelterFacilitateWorkRequest extends WorkRequest {
    private HomelessPerson homelessPerson;
    private String addressToBePlaced;
    private ShelterAllocateWorkRequest shelterAllocWorkReq;

    public HomelessPerson getHomelessPerson() {
        return homelessPerson;
    }

    public void setHomelessPerson(HomelessPerson homelessPerson) {
        this.homelessPerson = homelessPerson;
    }

    public String getAddressToBePlaced() {
        return addressToBePlaced;
    }

    public void setAddressToBePlaced(String addressToBePlaced) {
        this.addressToBePlaced = addressToBePlaced;
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
