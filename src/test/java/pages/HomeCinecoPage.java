package pages;

public class HomeCinecoPage extends BasePage {

    public HomeCinecoPage(){
        super(driver);
    }

    String dropdownCity = "//select[@name=\"city\"]";
    String buttonAcceptCity = "//button[@type=\"button\"][contains(text(),'Aceptar')]";
    String buttonCloseInitialMovie = "//button//*[@class=\"delete\"]";
    String buttonAcceptCookies = "//button[contains(text(),'Aceptar')]";
    private String optionHeader = "//header//*[contains(text(),'%s')]";
    String buttonMenuBar = "//a[@role=\"button\"]";
    private String optionMenuBar = "//a[contains(text(),'%s')]//parent::li";
    String searchBox = "//header//input[@name=\"query\"]";
    String movieResult = "//span[contains(text(),'%s')]//parent::a";
    String userField = "//input[@name=\"username\"]";
    String passField = "//input[@name=\"password\"]";
    String submitButton = "//button[contains(text(),'Ingresar')]";
    

    public void navigateToCinecoWebPage(){
        navigateTo("https://www.cinecolombia.com");
    }

    public void cleanAllInitialPage() {
        selectDropDownByValueIfPresent(dropdownCity, "bogota");
        clickElementIfPresent(buttonAcceptCity);
        clickElementIfPresent(buttonCloseInitialMovie);
        clickElementIfPresent(buttonAcceptCookies);
    }

    public void selectHeaderOption(String section){
        String xpathString = String.format(optionHeader, section);
        waitUntilElementIsClickable(xpathString);
        clickElement(xpathString);
    }

    public void selectTheMenuButton(){
        clickElement(buttonMenuBar);
    }

    public void selectMenuOption(String section){
        String xpathString = String.format(optionMenuBar, section);
        waitUntilElementIsClickable(xpathString);
        clickElement(xpathString);
    }

    public void searchMovieinSearchBox(String movie){
        String xpathMovie = String.format(movieResult, movie);
        waitUntilElementIsVisible(searchBox);
        write(searchBox, movie);
        waitUntilElementIsClickable(xpathMovie);
        clickElement(xpathMovie);
    }

    public void insertUsername(String username){
        waitUntilElementIsVisible(userField);
        write(userField, username);
    }

    public void insertPassword(String password){
        waitUntilElementIsVisible(passField);
        write(passField, password);
    }

    public void submitLogInForm(){
        clickElement(submitButton);
    }
    
}
