package biz.Catalog;
import java.util.ArrayList;
public abstract class AbstractCatalog<Element> implements CatalogInterface<Element> {
    public ArrayList<Element> elementArrayList;

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

    public ArrayList<Element> findElements(Finder<Element> finder) {
        ArrayList<Element> result = new ArrayList<>();
        for (Element e: elementArrayList) {
            if (finder.find(e)) {
                result.add(e);
            }
        } 
        return result;
    }
    
    public Element findElement(Finder<Element> finder) {
        for (Element e: elementArrayList) {
            if (finder.find(e)) {
                return e;
            }
        }
        return null;
    }
    
    public boolean addElement(Element e) {
        return this.elementArrayList.add(e);
    }
}
