package biz.Catalog;

import java.util.ArrayList;

/**
 This abstract class implements `newElement`, `removeElement`, `findElement` method.
 To make use of it, extends and override `createElement`.

 Example:

 public Person {
     private String name;

     public Person(String name) {
        this.name = name;
     }
 }

 public PersonCatalog extends AbstractCatalog<Person> {
     @Override
     public Person createElement() {
        return new Person("hezj");
     }
 }
 */
public abstract class AbstractCatalog<Element> implements CatalogInterface<Element> {
    ArrayList<Element> elementArrayList;

    public Element newElement() {
        Element e = createElement();
        this.elementArrayList.add(e);
        return e;
    }

    public ArrayList<Element> getElementArrayList() {
        return elementArrayList;
    }

    @Override
    public boolean removeElement(Element e) {
        return elementArrayList.remove(e);
    }

    public Element findElement(Finder<Element> finder) {
        for (Element e: elementArrayList) {
            if (finder.find(e)) {
                return e;
            }
        }
        return null;
    }
}
