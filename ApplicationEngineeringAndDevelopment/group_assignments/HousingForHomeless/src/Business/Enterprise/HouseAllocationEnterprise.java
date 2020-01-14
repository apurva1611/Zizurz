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
public class HouseAllocationEnterprise extends Enterprise {
    
    public HouseAllocationEnterprise(String name){
        super(name,EnterpriseType.HouseAllocation);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    public ArrayList<Type> getSupportedOrganizationType() {
        
         ArrayList<Type> types = new ArrayList<>();
         types.add(Type.HousingOptions);
         types.add(Type.SchemeProvision);
         return types;
    }
    
}
