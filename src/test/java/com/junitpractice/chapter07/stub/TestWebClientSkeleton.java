package com.junitpractice.chapter07.stub;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientSkeleton {

    @BeforeEach
    void setUp() {
        //Jetty 서버를 시작한다.
        // http://localhost:8081/testGetContentOk 경로로 접근
        // "It Works" 를 반환하도록 설정
    }

    @AfterAll
    static void afterAll() {
        // Jetty 서버를 중지
    }

    @Test
    @Disabled("단순한 테스트 스켈레톤이므로 현재 이 테스트를 실행하면 실패한다.")
    void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String workingContent = client.getContent(new URL("http://localhost:8081/testGetContentOk"));
        assertEquals("It Works", workingContent);

    }
}
