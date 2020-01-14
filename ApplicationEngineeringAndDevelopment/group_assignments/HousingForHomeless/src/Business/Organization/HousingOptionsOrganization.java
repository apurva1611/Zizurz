/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FinancialCheckerRole;
import Business.Role.HousingOptionsProviderRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HousingOptionsOrganization extends Organization{

    public HousingOptionsOrganization() {
        super(Organization.Type.HousingOptions.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HousingOptionsProviderRole());
        return roles;
    }
}
