/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.HomelessPerson;
import java.util.List;

/**
 *
 * @author raunak
 */
public class FinalizeHouseWorkRequest extends WorkRequest{
    
    private HomelessPerson homelessPerson;
    private ShelterAllocateWorkRequest shelterAllocWorkReq;
    private List<List<String>> addressesForHomeless;
    private List<String> schemes;

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

    public List<List<String>> getAddressesForHomeless() {
        return addressesForHomeless;
    }

    public void setAddressesForHomeless(List<List<String>> addressesForHomeless) {
        this.addressesForHomeless = addressesForHomeless;
    }

    public List<String> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<String> schemes) {
        this.schemes = schemes;
    }
    
    @Override
    public String toString() {
        return getHomelessPerson()!=null? getHomelessPerson().getName(): "No name";
    }
    
}
