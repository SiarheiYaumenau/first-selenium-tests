package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("155 Park Blvd, Palo Alto, CA");
        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
        driver.quit();
    }
}
