package test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import test.demo.Controllers.demoController;
import static org.assertj.core.api.Assertions.*; // getting all assertions


@SpringBootTest
public class SmokeTest {
    @Autowired
    private demoController DemoController;

    @Test
    void testingsanitycheck() {
        assertThat(DemoController).isNotNull();

    }
}
