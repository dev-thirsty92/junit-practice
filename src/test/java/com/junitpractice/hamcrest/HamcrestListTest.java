package com.junitpractice.hamcrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestListTest {

    private List<String> values;

    @BeforeEach
    void setUp() {
        values = new ArrayList<String>();
        values.add("one");
        values.add("two");
        values.add("three");
    }


    @Test
    @DisplayName("Hamcrest를 사용하지 않은 테스트")
    void testWithoutHamcrest() {
        assertEquals(3, values.size());
        assertTrue(values.contains("six")
        || values.contains("four")
        || values.contains("five"));
    }


    @Test
    @DisplayName("Hamcrest를 사용해서 자세한 실패 정보를 나타내는 테스트")
    void testListWithHamcrest() {
        assertThat(values, hasSize(3));
        assertThat(values, hasItem(
                anyOf(
                        equalTo("four"),
                        equalTo("five"),
                        equalTo("six")
                )
        ));
    }
}
