/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.BackgroundCheck.getValue())) {
            organization = new BackgroundCheckOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.FinancialCheck.getValue())) {
            organization = new FinancialCheckOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Volunteer.getValue())) {
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.ShelterAllocation.getValue())) {
            organization = new ShelterAllocationOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.ShelterFacilitation.getValue())) {
            organization = new ShelterFacilitationOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.HousingOptions.getValue())) {
            organization = new HousingOptionsOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.SchemeProvision.getValue())) {
            organization = new SchemeProvisionOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.FinalizeHousing.getValue())) {
            organization = new FinalizeHousingOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.HouseAgreement.getValue())) {
            organization = new HouseAgreementOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
