package GithubRepositories;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;


public class CountAndVerifyRepositories {

    private static ChromeDriver driver;
    private static WebDriverWait wait;
    private static final String USERNAME = "Jagriti-grover20";
    private static final int EXPECTED_REPO_COUNT = 28;

    @BeforeAll
    public static void setup() {
        // Sets the system property to specify the path of the ChromeDriver executable, so Selenium can launch Chrome.
        System.setProperty("webdriver.chrome.driver", "/Users/jagriti.grover/Downloads/chromedriver-mac-x64/chromedriver");
        // Creates an instance to customize browser launch settings.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Launches the Chrome browser using the configured options.
        driver = new ChromeDriver(options);
        // Initializes an explicit wait to pause actions until elements are available (up to 15 seconds).
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void countAndVerifyRepositories() {
        String repoUrl = "https://github.com/" + USERNAME + "?tab=repositories";
        driver.get(repoUrl);

        // Wait until the repository list is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@data-filterable-for='your-repos-filter']")));

        // Get all repository list items
        List<WebElement> repos = driver.findElements(By.xpath("//ul[@data-filterable-for='your-repos-filter']//li"));

        System.out.println("Total Repositories Found: " + repos.size());

        Assertions.assertEquals(EXPECTED_REPO_COUNT, repos.size(),
                "Repository count mismatch! Expected: " + EXPECTED_REPO_COUNT + ", Found: " + repos.size());
        System.out.println(" Repository count matched successfully.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println(" Browser session closed.");
        }
    }
}
