<%@ page import="java.util.List" %>
<%@ page import="models.Good" %>
<%@ page import="models.Order" %>
<%@ page import="DAO.OrderDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width" />
    <link  type="text/css" rel="stylesheet" href="/css/Site.css" />
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div>
    <h3>Заказы</h3>
    <table>
        <tr class="header"><td><p>Ай ди</p></td>
            <td><p>Покупатель</p></td>
            <td><p>Товар</p></td>
            <td><p>Дата</p></td>
            <td></td>
        </tr>
        <%
            List<Order> orders = (List<Order>) request.getAttribute("orders");

            if (orders != null && !orders.isEmpty()) {
                OrderDao orderDao = new OrderDao();
                for (Order s : orders) {

                    out.println("<tr>");
                    out.println("<td><p>" + s.getId() + "</p></td>");
                    out.println("<td><p>" + s.getDate() + "</p></td>");
                    out.println("<td><p>" + orderDao.getCustomer(s.getId()).getSurName() + "</p></td>");
                    out.println("<td><p>" + orderDao.getCustomer(s.getId()).getName()  + "</p></td>");
                    out.println("<td><p><a href=" + "'/edit?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                    out.println("</tr>");

                }
            }
        %>
    </table>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='../..'">Back to main</button>
</div>
</body>
</html>