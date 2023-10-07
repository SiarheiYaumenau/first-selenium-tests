package org.epam.first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Timeouts03 {

    public static void main(String[] args) {
        WebDriver driverFox = new FirefoxDriver();
        driverFox.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2)); //Page load
        driverFox.get("https://www.selenium.dev/");

        WebDriver driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().scriptTimeout(Duration.ofSeconds(2)); //Script
        driverChrome.get("https://www.selenium.dev/");

        WebDriver driverEdge = new EdgeDriver();
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //Implicitly wait
        driverEdge.get("https://www.selenium.dev/");

        new WebDriverWait(driverFox, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("docsearch"))); //Explicit wait

        //Waiting 30 seconds for an element to be present on the page, checking for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<>(driverChrome) //with default options
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        //with custom functions or predicates
        WebElement logo = wait.until(driver -> driverChrome.findElement(By.cssSelector("path.cls-1:nth-child(12)")));
    }
}
