package org.epam.first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverAPIBasics04 { //using explicit waits and refactor with private method
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions.jQueryAJAXsCompleted()); //custom condition
        WebElement searchButton = getWebElement(driver, By.id("docsearch")); //method with explicit wait
        searchButton.click();
        WebElement searchInput = getWebElement(driver, By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".DocSearch-Hit-source")));
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.quit();
    }

    private static WebElement getWebElement(WebDriver driver, By by) { //method with explicit wait
        return new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}