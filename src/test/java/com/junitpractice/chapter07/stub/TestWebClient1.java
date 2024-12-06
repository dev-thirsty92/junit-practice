package com.junitpractice.chapter07.stub;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClient1 {

    @BeforeAll
    static void beforeAll() {
        URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());
    }

    private static class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private static class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            return new StubHttpURLConnection(url);
        }
    }

    @Test
//    @Disabled("단순한 테스트 스켈레톤이므로 현재 이 테스트를 실행하면 실패한다.")
    void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String workingContent = client.getContent(new URL(
                "http://localhost:8081/testGetContentOk"));
        assertEquals("It Works", workingContent);

    }
}
