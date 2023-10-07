package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //Selenium WebDriver iterates through all the fields of the current
        // this object (of the AbstractPage class) and looks for annotations such as @FindBy (or other annotations)
        // that specify locators for elements on the web page.
        //As a result, after calling PageFactory.initElements(driver, this), all fields in the AbstractPage class
        // that are associated with page elements will be initialized and ready for use when interacting with the web page.
    }
}
