/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.*;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HouseAgreement.HouseAgreementWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class HouseAgreementCreatorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HouseAgreementWorkAreaJPanel(userProcessContainer, account, (HouseAgreementOrganization) organization, business, enterprise);
    }
    
    public String toString() {
        return "House Agreement Creator Role";
    }
    
}
