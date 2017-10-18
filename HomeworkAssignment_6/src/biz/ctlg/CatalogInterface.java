package biz.ctlg;

interface CatalogInterface<Element> {
    Element createElement();

    boolean removeElement(Element e);

    Element newElement();
}
