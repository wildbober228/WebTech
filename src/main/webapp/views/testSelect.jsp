<%@ page import="java.util.HashMap" %>
<%@ page import="models.Discount" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: wildbober
  Date: 16.03.2021
  Time: 5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="test" method="post">
<select name="listDiscount">
<% List<Discount> listDiscount = (List<Discount>) request.getAttribute("listDiscount");

   for(int i =0; i < listDiscount.size(); i ++){


       int id = listDiscount.get(i).getId();
%>
            <option value="<%=id%>"> <%=listDiscount.get(i).getAmountDiscount()%> </option>
   <%
   }
%>
</select>
    <br/><br/>
<input type="submit" value="Submit" />
</form>
<%--<select name="questionid" id="questionids" >--%>
<%--    <c:forEach items="${map}">--%>
<%--        <option value="${key}">${value}</option>--%>
<%--    </c:forEach>--%>
<%--</select>--%>

<%--<form action="list" method="post">--%>
<%--    Select a Discount:&nbsp;--%>
<%--    <select name="discount">--%>
<%--        <c:forEach items="${listDiscount}" var="id" varStatus="loop" >--%>
<%--            <option value="${loop.index}">${1}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <br/><br/>--%>
<%--    <input type="submit" value="Submit" />--%>
<%--</form>--%>
</body>
</html>
