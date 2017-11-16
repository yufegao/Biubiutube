package biz.enterprises;

import biz.organizations.Organization;
import biz.organizations.OrganizationCatalog;



public abstract class Enterprise extends Organization{
  private EnterpriseType enterpriseType;
  private OrganizationCatalog organizationCatalog;

    public Enterprise(String name,EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        
    }
  public enum EnterpriseType{
      
  }

  public EnterpriseType getEnterpriseType(){
    return enterpriseType;
  }
}
