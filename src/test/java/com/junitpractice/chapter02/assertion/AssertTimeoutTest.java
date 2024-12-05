package com.junitpractice.chapter02.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class AssertTimeoutTest {

    private SUT systemUnderTest = new SUT("테스트 대상 시스템");

    @Test
    @DisplayName("작업을 마칠 때 까지 기다리는 assertTimeout 메서드")
    void testTimeOut() {
        systemUnderTest.addJob(new Job("Job_1"));
        assertTimeout(Duration.ofMillis(500),
                ()-> systemUnderTest.run(200)
        );
    }

    @Test
    @DisplayName("시간이 지나면 작업을 중지시키는 assertTimeoutPreemptively 메서드")
    void testTimeoutPreemptively() {
        systemUnderTest.addJob(new Job("Job_1"));
        assertTimeoutPreemptively(Duration.ofMillis(500),
                ()-> systemUnderTest.run(200)
        );
    }


}
