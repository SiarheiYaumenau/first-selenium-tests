package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.SeleniumHomePage;

public class WebDriverSeleniumTest {
    private WebDriver driver;
    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Just the first test, JIRA binding can be here")
    public void commonSearchTermResultExists() {

        boolean printLinkExists = new SeleniumHomePage(driver)
                .openPage().openSearchPopup().searchForTerms("selenium java").findPrintElement();
        Assert.assertTrue(printLinkExists, "Print link is not displayed on the page");
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
