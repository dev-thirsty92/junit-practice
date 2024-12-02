package com.junitpractice.assertion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsTest {
    private SUT systemUnderTest = new SUT("테스트 대상 시스템");

    @Test
    @DisplayName("예외가 발생하는지 검증한다")
    void testExceptedException() {
        assertThrows(NoJobException.class, systemUnderTest::run);
    }

    @Test
    void testCatchException() {
        Throwable throwable = assertThrows(NoJobException.class,
                () -> systemUnderTest.run(1 * 1000));
        assertEquals("테스트 대상 시스템은 현재 작업이 없는지 확인", throwable.getMessage());
    }
}
