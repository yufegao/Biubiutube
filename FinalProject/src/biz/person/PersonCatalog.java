/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.person;

import biz.org.Organization;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class PersonCatalog {
    private Organization org;
    private ArrayList<Person> personList;
    
    public PersonCatalog(Organization org){
        this.org = org;
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public Person newPerson(String firstName, String lastName){
        Person person = new Person(firstName, lastName, this.org);
        personList.add(person);
        return person;
    }
}
