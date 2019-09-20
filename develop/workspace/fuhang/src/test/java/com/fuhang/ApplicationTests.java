package com.fuhang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@ActiveProfiles("test")
@EnableAsync
public class ApplicationTests {

    public static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    public void test() {

    }
}
