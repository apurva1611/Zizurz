/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FinalizeHousingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FinalizeHousing.FinalizeHousingWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class HousingFinalizerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new FinalizeHousingWorkAreaJPanel(userProcessContainer, account, (FinalizeHousingOrganization) organization, business, enterprise);
    }
    
    public String toString() {
        return "Housing Finalizer";
    }
    
}
