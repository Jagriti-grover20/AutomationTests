package WebAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VerifyAPIHeaderResponse {

    private static final String BASE_URL = "https://api.github.com/";

    /**
     * Validates that the GitHub API responds with the expected JSON content type.
     */
    @Test
    public void shouldReturnContentTypeJson() throws IOException, InterruptedException {
        // Arrange
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Test-Agent") // Required by GitHub API
                .build();

        // Act
        HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
        String contentType = response.headers().firstValue("Content-Type").orElse("Not Found");

        // Message
        System.out.println("Received Content-Type header: " + contentType);

        // Assert
        Assertions.assertEquals("application/json; charset=utf-8", contentType, "Content-Type header mismatch");
    }

    /**
     * Verifies that the GitHub API enforces a rate limit of 60 requests for unauthenticated users.
     */
    @Test
    public void shouldReturnRateLimitForUnauthenticatedUser() throws IOException, InterruptedException {
        // Arrange
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Test-Agent") // Required header
                .build();

        // Act
        HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
        String rateLimit = response.headers().firstValue("x-ratelimit-limit").orElse("Not Found");

        // Message
        System.out.println("Received X-RateLimit-Limit header: " + rateLimit);

        // Assert
        Assertions.assertEquals("60", rateLimit, "Rate limit header mismatch for unauthenticated access");
    }
}