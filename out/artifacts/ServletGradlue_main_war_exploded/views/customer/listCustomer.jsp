<%@ page import="java.util.List" %>
<%@ page import="models.Good" %>
<%@ page import="models.Customer" %>
<%@ page import="DAO.DiscountDao" %>
<%@ page import="models.Discount" %>
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
    <h3>Покупатели</h3>
    <table>
        <tr class="header"><td><p>Ай ди</p></td>
            <td><p>Имя</p></td>
            <td><p>Фамилия</p></td>
            <td><p>Размер скидки</p></td>
            <td></td>
        </tr>
        <%
            List<Customer> customers = (List<Customer>) request.getAttribute("customers");

            if  (customers != null && !customers.isEmpty()) {
                DiscountDao discountDao = new DiscountDao();
                for (Customer s : customers) {

                    Discount discount = discountDao.getById(s.getDiscountFK());

                    out.println("<tr>");
                    out.println("<td><p>" + s.getId() + "</p></td>");
                    out.println("<td><p>" + s.getName() + "</p></td>");
                    out.println("<td><p>" + s.getSurName() + "</p></td>");
                    out.println("<td><p>" + discount.getAmountDiscount() + "</p></td>");
                    out.println("<td><p><a href=" + "'/editCustomer?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                    //out.println("<td><p><a href=" + "'/deleteCustomer?id=   " + s.getId() + " ' >Удалить</a></p></td>");
                    out.println("<td><p>");
                    out.println("<form action=\"/deleteCustomer\" method=\"POST\">");
                    out.println("<div>");
                    out.println("<input type = \"hidden\" value=\""+s.getId()+"\" name=\"id\">");
                    out.println("</div>");
                    out.println("<div>");
                    out.println("<button>Delete Customer</button>");
                    out.println("</div>");
                    out.println("</form>");
                    out.println("</p></td>");
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