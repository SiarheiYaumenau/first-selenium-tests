package org.epam.first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class WebDriverSeleniumTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
    }

    @Test (description = "Just the first test, JIRA binding can be here")
    public void commonSearchTermResultExists() {
        driver.get("https://www.selenium.dev/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted()); //custom condition
        WebElement searchButton = getWebElement(driver, By.id("docsearch")); //method with explicit wait
        searchButton.click();
        WebElement searchInput = getWebElement(driver, By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".DocSearch-Hit-source")));
        searchInput.sendKeys(Keys.ENTER);
        WebElement printLink = getWebElement(driver, By.id("print"));
        Assert.assertTrue(printLink.isDisplayed(), "Print link is not displayed on the page");
        driver.quit();
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private static WebElement getWebElement(WebDriver driver, By by) { //method with explicit wait
        return new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
