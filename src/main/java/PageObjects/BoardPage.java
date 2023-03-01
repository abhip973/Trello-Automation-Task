package PageObjects;

import Utilities.Helpers;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardPage extends Helpers {

    WebDriver driver;

    public BoardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.open-add-list.js-open-add-list")
    WebElement addListOption;

    @FindBy(css = "input.list-name-input")
    WebElement addListInputField;

    @FindBy(css = "input[type='submit']")
    WebElement submitListBtn;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    WebElement addListBtn;

    @FindBy(css = "span.js-add-a-card")
    WebElement addCardBtn;

    @FindBy(css = "textarea.list-card-composer-textarea.js-card-title")
    WebElement cardInputField;

    @FindBy(css = "span.list-card-title.js-card-name")
    WebElement listACard;

    @FindBy(xpath = "//h2[text()='List B']/..")
    WebElement listBHeader;


    public void createListA() throws InterruptedException {

        Thread.sleep(3000);
        waitForElementToAppear(addListInputField);
        addListInputField.sendKeys("List A");
        submitListBtn.click();
        addCardBtn.click();
        cardInputField.sendKeys("Card A");
        submitListBtn.click();
    }

    public void createListB() {
        addListInputField.sendKeys("List B");
        waitForElementToAppear(submitListBtn);
        addListBtn.click();
    }

    public void moveCard()  {
        moveElement(listACard, listBHeader);
    }

    public void getCoordinates() {
        Point point = listACard.getLocation();
        int x_Axis = point.getX();
        int y_Axis = point.getY();
        System.out.println("X-Axis: " + x_Axis + "Y-Axis: " + y_Axis);
    }
}
