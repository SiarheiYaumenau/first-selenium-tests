package pageobject_model.page;

import org.epam.first_tests.CustomConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SeleniumHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.selenium.dev/";
    @FindBy(id = "docsearch")
    private WebElement searchField;
    @FindBy(id="docsearch-input")
    private WebElement searchInput;
    @FindBy(css=".DocSearch-Hit-source")
    private WebElement DocSearchHitSource;
    @FindBy(id="print")
    private WebElement printLink;

    public SeleniumHomePage(WebDriver driver) {
        super(driver);
    }

    public SeleniumHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SeleniumHomePage openSearchPopup() {
        searchField.click();
        return this;
    }

    public SeleniumHomePage searchForTerms(String term) {
        searchInput.sendKeys(term);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".DocSearch-Hit-source")));
//        searchInput.sendKeys(Keys.ENTER);
        searchInput.submit();
        return this;
    }

    public boolean findPrintElement() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(d -> printLink.isDisplayed());
        return printLink.isDisplayed();
    }
}
