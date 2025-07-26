package WebAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetHeaderText {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    @DisplayName("Verify GitHub API base URL returns HTTP 200")
    public void verifyGitHubApiIsReachable() throws IOException, InterruptedException {
        // Arrange
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET() //optional as GET is default
                .build();

        // Act
        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());

        System.out.println("Requested URL: " + BASE_URL);
        System.out.println("Received Status Code: " + response.statusCode());

        // Assert
        Assertions.assertEquals(200, response.statusCode(), "Expected status 200, but received: " + response.statusCode());
    }
}
