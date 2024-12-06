package com.junitpractice.chapter07.stub;

import org.junit.jupiter.api.*;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClient {
    private WebClient client = new WebClient();

    @BeforeAll
    public static void setUp() throws Exception {
        //Jetty 서버를 시작한다.
        Server server = new Server(8081);

        // http://localhost:8081/testGetContentOk 경로로 접근
        Context contextOkContext = new Context(server,"/testGetContentOk");
        contextOkContext.setHandler(new TestGetContentOkHandler());

        server.setStopAtShutdown(true);
        server.start();
        // "It Works" 를 반환하도록 설정
    }

    @AfterAll
    static void afterAll() {
        // Jetty 서버를 중지
    }

    private static class TestGetContentOkHandler extends AbstractHandler{

        @Override
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
            ServletOutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It Works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    @Test
//    @Disabled("단순한 테스트 스켈레톤이므로 현재 이 테스트를 실행하면 실패한다.")
    void testGetContentOk() throws MalformedURLException {
        String workingContent = client.getContent(new URL(
                "http://localhost:8081/testGetContentOk"));
        assertEquals("It Works", workingContent);

    }

}
