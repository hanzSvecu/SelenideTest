package pages;

public abstract class TemplatePage {

HeaderMenu header = new HeaderMenu();

// footer is not implemented as it is not used in any test for this small task; there is for possible extension
//  protected Footer footer = new Footer();

    // method to override in each page - purpose is to have at least one element that verifies that correct page is open
    public abstract void isOpen();

}