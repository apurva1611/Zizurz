/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ShelterAllocationOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ShelterAllocatorRole.ShelterAllocatorWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class ShelterAllocaterRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ShelterAllocatorWorkAreaJPanel(userProcessContainer, account, (ShelterAllocationOrganization)organization, enterprise, business);
    }
    
    public String toString() {
        return "Shelter Allocator";
    }
    
    
}
