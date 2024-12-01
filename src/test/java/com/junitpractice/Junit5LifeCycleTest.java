package com.junitpractice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class Junit5LifeCycleTest {

    @BeforeAll
    static void beforeAll() {
        String beforeAll = "beforeAll";
        log.info("{}: 전체 테스트가 실행되기 전에 한 번 실행",beforeAll);
    }

    @AfterAll
    static void afterAll() {
        String afterAll = "afterAll";
        log.info("{}: 전체 테스트가 실행된 후 한 번 실행", afterAll);
    }

    @BeforeEach
    void setUp() {
        String beforeEach = "beforeEach";
        log.info("{}: 각 테스트가 실행되기 전에 실행", beforeEach);
    }

    @AfterEach
    void tearDown() {
        String tearDown = "tearDown";
        log.info("{}: 각 테스트가 실행되기 전에 실행", tearDown);
    }

    @Test
    void name1() {
        String name = "test1";
        log.info("{}: 테스트메서드1", name);
    }

    @Test
    void name2() {
        String name = "test2";
        log.info("{}: 테스트메서드2", name);
    }
}
