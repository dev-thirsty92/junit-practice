package com.junitpractice.resolver;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestInfoTest {

    TestInfoTest(TestInfo testInfo) {
        log.info("TestInfo: {}", testInfo);
        assertEquals("TestInfoTest", testInfo.getDisplayName());
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        log.info(displayName);
        assertTrue(displayName.equals("display name of the method")
                || displayName.equals("testGetNameOfTheMethod(TestInfo)"));
    }

    @Test
    void testGetNameOfTheMethod(TestInfo testInfo) {
        log.info("testGetNameOfTheMethod");
        assertEquals("testGetNameOfTheMethod(TestInfo)", testInfo.getDisplayName());
    }

    @Test
    @DisplayName("display name of the method")
    void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
        log.info("testGetNameOfTheMethodWithDisplayNameAnnotation");
        assertEquals("display name of the method", testInfo.getDisplayName());
    }
}
