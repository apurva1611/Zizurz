/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FinancialCheckOrganization;
import Business.Organization.HousingOptionsOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HousingOptions.HousingOptionsWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class HousingOptionsProviderRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HousingOptionsWorkAreaJPanel(userProcessContainer, account, (HousingOptionsOrganization) organization, business, enterprise);
    }
    
    public String toString() {
        return "Housing Options Provider";
    }
    
}
