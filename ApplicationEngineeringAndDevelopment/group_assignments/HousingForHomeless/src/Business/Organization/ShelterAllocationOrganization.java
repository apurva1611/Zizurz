/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BackgroundCheckerRole;
import Business.Role.Role;
import Business.Role.ShelterAllocaterRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ShelterAllocationOrganization extends Organization{

    public ShelterAllocationOrganization() {
        super(Organization.Type.ShelterAllocation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ShelterAllocaterRole());
        return roles;
    }
     
}