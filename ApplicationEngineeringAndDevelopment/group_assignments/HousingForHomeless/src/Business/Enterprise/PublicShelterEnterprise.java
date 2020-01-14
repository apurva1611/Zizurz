/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class PublicShelterEnterprise extends Enterprise {
    
    public PublicShelterEnterprise(String name){
        super(name,EnterpriseType.PublicShelter);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    public ArrayList<Type> getSupportedOrganizationType() {
        
         ArrayList<Type> types = new ArrayList<>();
         types.add(Type.ShelterAllocation);
         types.add(Type.ShelterFacilitation);
         return types;
    }
    
}
