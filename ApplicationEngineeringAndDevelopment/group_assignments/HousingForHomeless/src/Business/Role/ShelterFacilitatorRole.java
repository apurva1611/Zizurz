/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ShelterFacilitationOrganization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ShelterFacilitatorRole.ShelterFacilitatorWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class ShelterFacilitatorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ShelterFacilitatorWorkAreaJPanel(userProcessContainer, account, (ShelterFacilitationOrganization)organization, enterprise, business);
    }
    
    public String toString() {
        return "Shelter Facilitator";
    }
    
    
}
