package elements;
import elements.pages.ConfirmationPage;
import elements.pages.FormPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Form {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        new FormPage().submitForm(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);
        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));
        driver.quit();
    }

}
