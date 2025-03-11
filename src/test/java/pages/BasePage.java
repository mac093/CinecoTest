package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    Actions actions = new Actions(driver);

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
 
    //Este es el constructor de BasePage que acepta un objeto WebDriver como argumento
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
 
    public static void navigateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        //driver.manage().window().maximize();
    }

    //Método estático para cerrar la instancia del driver. 
    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath, esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
 
    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void clickElementIfPresent(String locator){
        boolean isPresent = isElementPresent(locator);
        if (isPresent){
            clickElement(locator);
        }
    }

    public void write(String locator, String inputText) {
        Find(locator).clear();
        Find(locator).sendKeys(inputText);
    }

    public void selectDropDownByValue(String locator, String value){
            Select dropdown = new Select(Find(locator));
            dropdown.selectByValue(value);
    }

    public void selectDropDownByValueIfPresent(String locator, String value){
        boolean isPresent = isElementPresent(locator);
        if (isPresent){
            Select dropdown = new Select(Find(locator));
            dropdown.selectByValue(value);
        }
    }

    public boolean isElementPresent(String locator){
        boolean isPresent = !driver.findElements(By.xpath(locator)).isEmpty();
        return isPresent;
    }

    public void selectDropDownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropDownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropDownOptions = dropdown.getOptions();
        return dropDownOptions.size();
    }

    public List<String> getAllValuesDropdown(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownValues = dropdown.getOptions();
        List<String> listOfValues = new ArrayList<>();
        
        for (WebElement option : dropdownValues) {
            listOfValues.add(option.getText());
        }

        return listOfValues;
    }

    public void waitUntilElementIsClickable(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(Find(locator)));
    }

    public void waitUntilElementIsVisible(String locator) {
        wait.until(ExpectedConditions.visibilityOf(Find(locator)));
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextOfElement(String locator){
        return Find(locator).getText();
    }
    
}
