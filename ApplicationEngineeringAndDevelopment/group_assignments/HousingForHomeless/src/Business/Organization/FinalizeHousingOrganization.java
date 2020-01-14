/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.*;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class FinalizeHousingOrganization extends Organization{

    public FinalizeHousingOrganization() {
        super(Organization.Type.FinalizeHousing.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HousingFinalizerRole());
        return roles;
    }
}
