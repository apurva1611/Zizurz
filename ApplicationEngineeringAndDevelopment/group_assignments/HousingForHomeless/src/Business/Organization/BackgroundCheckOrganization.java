/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.BackgroundCheckerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class BackgroundCheckOrganization extends Organization{

    public BackgroundCheckOrganization() {
        super(Organization.Type.BackgroundCheck.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new BackgroundCheckerRole());
        return roles;
    }
     
}