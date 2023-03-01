package trello.automation.TestComponents;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {


    public WebDriver driver;
    public String email, password;

    public LandingPage landingPage;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream globalFile = new FileInputStream("src/main/java/trello/automation/Resources/GlobalData.properties");
        properties.load(globalFile);

        String browserName = properties.getProperty("browser");
        email = properties.getProperty("userEmail");
        password = properties.getProperty("password");

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();

        //Applying implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.openURL();
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
        driver.close();
    }
}
