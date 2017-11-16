/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.person;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class PersonCatalog {
    private ArrayList<Person> personList;
    
    public PersonCatalog(){
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    public Person createAndAddPerson(String name){
        Person person = new Person();
        person.setName(name);
        personList.add(person);
        return person;
    }
}
