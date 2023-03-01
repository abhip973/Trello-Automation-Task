package trello.automation;

import PageObjects.BoardPage;
import PageObjects.HomePage;
import PageObjects.LandingPage;
import org.testng.annotations.Test;
import trello.automation.TestComponents.BaseTest;

public class AutomatingTrello extends BaseTest {

    @Test
    public void trelloProcessAutomate() throws InterruptedException {
        HomePage homePage = landingPage.loginToApplication(email, password);
        BoardPage boardPage = homePage.createNewBoard();
        boardPage.createListA();
        boardPage.createListB();
        boardPage.moveCard();
        boardPage.getCoordinates();
        boardPage.logOut();

    }
}
