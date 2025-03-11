package pages;

public class CarteleraPage extends BasePage {
    public CarteleraPage(){
        super(driver);
    }

    String titleElement = "//*[contains(@class, 'title is-4') or contains(@class, 'title section')]";

    public String returnTextOfTitle(){
        waitUntilElementIsVisible(titleElement);
        return getTextOfElement(titleElement);
    }
    
}
