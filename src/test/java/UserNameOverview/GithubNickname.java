package UserNameOverview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class GithubNickname {

    private final String DRIVER_PATH = "/Users/jagriti.grover/Downloads/chromedriver-mac-x64/chromedriver";

    @Test
    @DisplayName("Validate GitHub nickname matches profile URL handle")
    public void validateGitHubNicknameAgainstHandle() {
        // ----- Setup -----
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Action
        String userHandle = System.getProperty("username", "Jagriti-grover20");
        String profileUrl = "https://github.com/" + userHandle;

        try {
            // ----- Navigate to GitHub Profile -----
            System.out.println("Navigating to: " + profileUrl);
            driver.get(profileUrl);

            // ----- Wait for the nickname element to be visible -----
            WebElement nicknameElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("p-nickname"))
            );

            String actualNickname = nicknameElement.getText().trim();

            // ----- Assertion -----
            Assertions.assertEquals(
                    userHandle,
                    actualNickname,
                    "Mismatch: Expected GitHub handle to match displayed nickname!"
            );

            System.out.println("✅ Test Passed: GitHub nickname matches profile handle.");

        }
        catch (TimeoutException te) {
            Assertions.fail("Timed out waiting for GitHub profile to load nickname element.");
        }
        catch (Exception e) {
            Assertions.fail("Unexpected error during test execution: " + e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
