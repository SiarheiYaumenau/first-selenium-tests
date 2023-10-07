package elements.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormPage {
    public void submitForm(WebDriver driver) {
        driver.findElement(By.id("first-name")).sendKeys("Siarhei");
        driver.findElement(By.id("last-name")).sendKeys("Yaumenau");
        driver.findElement(By.id("job-title")).sendKeys("QA engineer");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='2']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("05/05/2025");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn")).click();
    }
}
