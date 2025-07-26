package GithubRepository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RepoLinkGoesToCorrectRepo {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String BASE_URL = "https://github.com/";
    private static final String USER = "Jagriti-grover20";
    private static final String REPO = "Snake-Mania-Game";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jagriti.grover/Downloads/chromedriver-mac-x64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--remote-allow-origins=*", "--disable-popup-blocking");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void testRepositoryLinkNavigation() {
        driver.get(BASE_URL + USER);

        By repoLinkLocator = By.linkText(REPO);
        wait.until(ExpectedConditions.elementToBeClickable(repoLinkLocator)).click();
        String expectedUrl = BASE_URL + USER + "/" + REPO;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        System.out.println("✅ Successfully navigated to: " + actualUrl);

        Assertions.assertEquals(expectedUrl, actualUrl, "Repository URL mismatch. Navigation failed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
