<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.basic.domain.member.Member" %>
<%@ page import="hello.servlet.basic.domain.member.MemberRepository" %>
<%
    //request, response는 따로 선언하지 않아도 그냥 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    // 파라미터 받기
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    // 비즈니스 로직
    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
    <ul>
        <li>id=<%=member.getId()%></li>
        <li>username=<%=member.getUsername()%></li>
        <li>age=<%=member.getAge()%></li>
    </ul>
    <a href="/index.html">메인</a>
</body>
</html>
