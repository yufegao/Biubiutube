package biz.enterprises;

import biz.organizations.Organization;



public abstract class Enterprise extends Organization{
  private EnterpriseType enterpriseType;
  public enum EnterpriseType{

  }

  public EnterpriseType getEnterpriseType(){
    return enterpriseType;
  }
}
