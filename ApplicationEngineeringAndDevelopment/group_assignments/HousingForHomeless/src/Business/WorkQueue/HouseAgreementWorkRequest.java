/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.HomelessPerson;
import java.util.List;

/**
 *
 * @author TILAK PARMAR
 */
public class HouseAgreementWorkRequest extends WorkRequest {

    private HomelessPerson homelessPerson;
    private ShelterAllocateWorkRequest shelterAllocWorkReq;
    private List<String> addressForHomeless;
    private String scheme;

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

    public List<String> getAddressForHomeless() {
        return addressForHomeless;
    }

    public void setAddressForHomeless(List<String> addressForHomeless) {
        this.addressForHomeless = addressForHomeless;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public String toString() {
        return getHomelessPerson() != null ? getHomelessPerson().getName() : "No name";
    }

}
