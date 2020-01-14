/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.ShelterFacilitatorRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ShelterFacilitationOrganization extends Organization{

    public ShelterFacilitationOrganization() {
        super(Organization.Type.ShelterFacilitation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ShelterFacilitatorRole());
        return roles;
    }
     
}