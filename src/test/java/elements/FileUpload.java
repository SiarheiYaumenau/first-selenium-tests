package elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys("DEV_SRMPORTAL-47336.csv");
        driver.quit();
    }
}
