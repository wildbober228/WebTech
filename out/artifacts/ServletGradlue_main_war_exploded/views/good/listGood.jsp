<%@ page import="java.util.List" %>
<%@ page import="models.Good" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width" />
    <link  type="text/css" rel="stylesheet" href="/css/Site.css" />
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div>
    <h3>Товары</h3>
    <table>
        <tr class="header"><td><p>Ай ди</p></td>
            <td><p>Название</p></td>
            <td><p>Количество</p></td>
            <td><p>Цена</p></td>
            <td></td>
        </tr>
        <%
        List<Good> goods = (List<Good>) request.getAttribute("goods");

        if (goods != null && !goods.isEmpty()) {
            for (Good s : goods) {

                out.println("<tr>");
                out.println("<td><p>" + s.getId() + "</p></td>");
                out.println("<td><p>" + s.getGoodName() + "</p></td>");
                out.println("<td><p>" + s.getGoodCount() + "</p></td>");
                out.println("<td><p>" + s.getGoodPrice() + "</p></td>");
                out.println("<td><p><a href=" + "'/edit?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                out.println("<td><p>");
                out.println("<form action=\"/deleteGood\" method=\"POST\">");
                out.println("<div>");
                out.println("<input type = \"hidden\" value=\""+s.getId()+"\" name=\"id\">");
                out.println("</div>");
                out.println("<div>");
                out.println("<button>Удалить</button>");
                out.println("</div>");
                out.println("</form>");
                out.println("</p></td>");
                out.println("</tr>");

            }
        }
        %>
    </table>
</div>


<%--<div class="w3-container w3-center w3-margin-bottom w3-padding">--%>
<%--    <div class="w3-card-4">--%>
<%--        <div class="w3-container w3-light-blue">--%>
<%--            <h2>Users</h2>--%>
<%--        </div>--%>

<%--<%--%>
<%--            List<User> users = (List<User>) request.getAttribute("users");--%>

<%--            if (users != null && !users.isEmpty()) {--%>
<%--                out.println("<ul class=\"w3-ul\">");--%>
<%--                for (User s : users) {--%>
<%--                    out.println("<li class=\"w3-hover-sand\">" +"name = " + s.getName());--%>
<%--                    out.println("<button class=\"w3-btn w3-hover-green w3-round-large\" onclick=\"location.href='/edit?id=   " + s.getId()+ "'\" >edit</button>");--%>
<%--                    out.println(" </li>");--%>
<%--                }--%>

<%--                out.println(" <ul>");--%>
<%--                out.println(" TEST");--%>
<%--                out.println(" </ul>");--%>


<%--                out.println("</ul>");--%>

<%--            }--%>
<%--%>--%>
<%--                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +--%>
<%--                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +--%>
<%--                    "   <h5>There are no users yet!</h5>\n" +--%>
<%--                    "</div>");--%>
<%--        %>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>