<%@ page import="servlets.tt1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<h1>Test</h1>
<h2>
    <%
        tt1 ss=new tt1();
        ss.check();
    %>
</h2>
</body>
</html>