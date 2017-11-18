package biz.person;

import biz.org.Organization;

public class Person {
    private String firstName;
    private String lastName;
    private Organization org;
    private String email;

    Person(String firstName, String lastName, Organization org) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.org = org;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Organization getOrg() {
        return org;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
