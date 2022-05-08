package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeader(request);
        printHeaderUtils(request);
        printEtc(request);

    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("------ Start Line 조회 시작 ------");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocal() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-test
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https사용 유무
        System.out.println("------ Start Line 조회 종료 ------");
        System.out.println();
    }

    // Header 모든 정보
    private void printHeader(HttpServletRequest request) {
        System.out.println("------ 모든 헤더 정보 출력 시작 ------");

        // 과거 스타일
/*        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + " : " + headerName);
        }*/

        // 요즘 스타일
        request.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName + " = " + request.getHeader(headerName)));

        // 헤더 정보를 하나만 조회하고 싶을 때 - 헤더 네임을 매개변수로 주면 된다
        // request.getHeader("");

        System.out.println("------ 모든 헤더 정보 출력 종료 ------");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("------ 서버 정보 조회 시작 ------");
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println("------ 서버 정보 조회 종료 ------");
        System.out.println();

        System.out.println("------ 수용 가능 언어 정보 조회 시작 ------");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale)); // 모든 언어 표시
        System.out.println("request.getLocale() = " + request.getLocale()); // 우선순위가 가장 높은 언어
        System.out.println("------ 수용 가능 언어 정보 조회 종료 ------");
        System.out.println();

        System.out.println("------ 쿠키 정보 조회 시작 ------");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println("------ 쿠키 정보 조회 종료 ------");
        System.out.println();

        System.out.println("------ 콘텐츠 정보 조회 시작 ------");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " +request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("------ 콘텐츠 정보 조회 종료 ------");
        System.out.println();

    }

    private void printEtc(HttpServletRequest request) {

        System.out.println("------ 기타 정보 조회 시작 ------");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
        System.out.println();
        System.out.println("------ 기타 정보 조회 종료 ------");
        System.out.println();

    }

}
