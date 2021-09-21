package com.wei.sjwt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
class SecurityJwtApplicationTests {

    @Test
    void contextLoads() {
        Duration duration = Duration.ofDays(0);
        Duration minutes = Duration.ofMinutes(10);
        System.out.println(minutes.getSeconds());
    }

}
