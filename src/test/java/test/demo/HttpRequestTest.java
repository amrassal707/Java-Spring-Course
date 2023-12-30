package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // checking for connections and listening to it
public class HttpRequestTest {
    @Value(value="${local.server.port}") // getting the port number
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate; // web client mock

    @Test
    void shouldreturnmessagebody(){
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello, World");

    }
}
