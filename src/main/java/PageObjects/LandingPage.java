package PageObjects;

import Utilities.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends Helpers {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/login']:nth-child(1)")
    WebElement loginBtn;

    @FindBy(css = "input#user")
    WebElement emailField;

    @FindBy(css = "input#login")
    WebElement continueBtn;

    @FindBy(css = "input#password")
    WebElement passwordField;

    @FindBy(css = "button#login-submit")
    WebElement submitBtn;


    public void openURL() {
        driver.get("https://trello.com/");
    }

    public HomePage loginToApplication(String email, String password) {

        loginBtn.click();
        emailField.sendKeys(email);
        continueBtn.click();
        waitForElementToAppear(passwordField);
        passwordField.sendKeys(password);
        submitBtn.click();

        HomePage homePage = new HomePage(driver);
        return homePage;
    }


}
