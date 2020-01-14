/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.HomelessPerson;

/**
 *
 * @author raunak
 */
public class ShelterAllocateWorkRequest extends WorkRequest{
    private HomelessPerson homelessPerson;
    //private String testResult;

    public HomelessPerson getHomelessPerson() {
        return homelessPerson;
    }

    public void setHomelessPerson(HomelessPerson homelessPerson) {
        this.homelessPerson = homelessPerson;
    }
   
    
   
   @Override
    public String toString() {
        return getHomelessPerson()!=null? getHomelessPerson().getName(): "No name";
    }
}
