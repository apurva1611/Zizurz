/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.BackgroundCheckOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Verification.BackgroundCheckWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class BackgroundCheckerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new BackgroundCheckWorkAreaJPanel(userProcessContainer, account, (BackgroundCheckOrganization)organization, enterprise, business);
    }
    
    public String toString() {
        return "Background Checker";
    }
    
    
}
