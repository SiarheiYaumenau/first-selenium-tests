package org.epam.first_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebDriverAPIBasics02 {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        By searchBtnSelector = By.id("docsearch");
//        WebElement searchButton = driver.findElement(searchBtnSelector); //find one element
//        searchButton.click();
        List<WebElement> searchButtons = driver.findElements(searchBtnSelector); //find some elements
        searchButtons.get(0).click();
        WebElement searchInput = driver.findElement(By.id("docsearch-input"));
        searchInput.sendKeys("selenium java");
        Thread.sleep(1000);
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
}
