/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        
        if(null!=type)switch (type) {
            case Verification:
                enterprise=new VerificationEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            case PublicShelter:
                enterprise=new PublicShelterEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            case HouseAllocation:
                enterprise=new HouseAllocationEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            case LocalPublicAgency:
                enterprise=new LocalPublicAgencyEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            case NGO:
                enterprise=new NGOEnterprise(name);
                enterpriseList.add(enterprise);
                break;
            default:
                break;
        }
        
        return enterprise;
    }
}
