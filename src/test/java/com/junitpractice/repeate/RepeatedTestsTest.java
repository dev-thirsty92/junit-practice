package com.junitpractice.repeate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class RepeatedTestsTest {

    private static Set<Integer> integerSet = new HashSet<>();
    private static List<Integer> integerList = new ArrayList<>();

    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
    @DisplayName("Test add operation")
    void testTheOperation() {
      log.info("test Operation");
    }

    @RepeatedTest(value = 5, name = "the lisr contains {currentRepetition} elements(s)")
    void testAddingToCollections(TestReporter testReporter,
                                 RepetitionInfo repetitionInfo) {
        integerSet.add(1);
        integerList.add(repetitionInfo.getCurrentRepetition());

        testReporter.publishEntry("Repetition number", String.valueOf(repetitionInfo.getCurrentRepetition()));
        assertEquals(1, integerSet.size());
        assertEquals(repetitionInfo.getCurrentRepetition(), integerList.size());
    }
}
