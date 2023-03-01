package PageObjects;

import Utilities.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helpers {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.rCD_pjrvLRI_B_")
    WebElement createBtn;

    @FindBy(xpath = "(//button[@class='yTThzZMDkelhke'])[1]")
    WebElement createOption;

    @FindBy(xpath = "//input[contains(@class,'nch-textfield__input')]")
    WebElement boardNameField;

    @FindBy(xpath = "//button[contains(@class,'ijFumaLuInvBrL')]")
    WebElement createBtn1;

    @FindBy(xpath = "(//div[@class='board-tile-details is-badged'])[1]")
    WebElement boardTile;

    public BoardPage createNewBoard()  {
        createBtn.click();
        createOption.click();
        boardNameField.sendKeys("Test Board");
        createBtn1.click();
        boardTile.click();

        BoardPage boardPage = new BoardPage(driver);
        return boardPage;
    }

}
