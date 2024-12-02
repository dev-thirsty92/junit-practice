package com.junitpractice.assumption;

import com.junitpractice.assertion.Job;
import com.junitpractice.assertion.NoJobException;
import com.junitpractice.assertion.SUT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {

    private final static String EXPECTED_JAVA_VERSION = "17";

    private TestEnvironment environment = new TestEnvironment(
            new JavaSpecification(System.getProperty("java.vm.specification.version")),
            new OperationSystem(
                    System.getProperty("os.name"),
                    System.getProperty("os.arch")
            )
    );

    private SUT systemUnderTest = new SUT();

    @BeforeEach
    void setUp() {
        assumeTrue(environment.isWindow());
    }

    @Test
    void testNoJobToRun() {
        System.out.println("테스트 메서드가 실행되었습니다.");
        assumingThat(
                ()-> environment.getJavaVersion()
                        .equals(EXPECTED_JAVA_VERSION),
                ()-> assertFalse(systemUnderTest.hasJobToRun())
        );
    }

    @Test
    void testJobToRun() throws NoJobException {
        assumeTrue(environment.isAmd64Architecture());
        systemUnderTest.run(new Job());
        assertTrue(systemUnderTest.hasJobToRun());
    }
}
