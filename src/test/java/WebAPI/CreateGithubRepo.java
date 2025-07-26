package WebAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This test verifies that creating a GitHub repository without authentication
 * results in an HTTP 401 Unauthorized response, as expected.
 */
public class CreateGithubRepo {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    public void shouldReturnUnauthorizedWhenCreatingRepoWithoutAuth() throws IOException, InterruptedException {
        // Arrange: Create an HTTP client and a POST request without authentication
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .header("User-Agent", "Test-Agent")  // Required by GitHub API
                .POST(HttpRequest.BodyPublishers.noBody()) // No body and no auth
                .build();

        // Act: Send the request
        HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
        int actualStatusCode = response.statusCode();

        // Assert: Expect 401 Unauthorized due to missing credentials
        Assertions.assertEquals(
                401,
                actualStatusCode,
                "Expected 401 Unauthorized when creating a GitHub repo without authentication"
        );

        // Optional: Print for visibility during test runs
        System.out.println("Verified: GitHub API blocks repo creation without authentication (401 Unauthorized)");
    }
}
