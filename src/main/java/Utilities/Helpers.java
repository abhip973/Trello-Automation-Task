package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helpers {

    WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.OUdAuicP657Tka")
    WebElement accountBtn;

    @FindBy(xpath = "//span[text()='Log out']/..")
    WebElement logOutBtn;

    public void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void moveElement(WebElement initial, WebElement target) {
        Actions a = new Actions(driver);
        a.moveToElement(initial);
        a.clickAndHold();
        a.moveToElement(target);
        a.release().build().perform();
    }

    public void logOut() {
        accountBtn.click();
        logOutBtn.click();
        waitForElementToAppear(logOutBtn);
        logOutBtn.click();

    }

}
