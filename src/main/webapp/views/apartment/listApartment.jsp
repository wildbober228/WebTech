<%--
  Created by IntelliJ IDEA.
  User: wildbober
  Date: 26.11.2021
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="models.Apartment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>APARTMENT LIST</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="viewport" content="width=device-width" />
    <link  type="text/css" rel="stylesheet" href="/css/Site.css" />
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Super app!</h1>
</div>

<div>
    <h3>Список свободных комнат</h3>
    <table>
        <tr class="header"><td><p>Ай ди</p></td>
            <td><p>Название</p></td>
            <td><p>Количество комнат</p></td>
            <td><p>Стоимость</p></td>
            <td></td>
        </tr>
        <%
            HttpSession session1 = request.getSession();
            String role = (String) session.getAttribute("session_role");
            out.println("Авторизован клиент " + request.getAttribute("session") + " Роль "+role);
            List<Apartment> apartments = (List<Apartment>) request.getAttribute("apartments");

            if  (apartments != null && !apartments.isEmpty()) {

                for (Apartment s : apartments) {
                    if(s.getIsBooked() == 0 && role != "Administrator") {
                        out.println("<tr>");
                        out.println("<td><p>" + s.getId() + "</p></td>");
                        out.println("<td><p>" + s.getApartmentName() + "</p></td>");
                        out.println("<td><p>" + s.getRoomCount() + "</p></td>");
                        out.println("<td><p>" + s.getRoomPrice() + "</p></td>");
                        out.println("<td><p>");
                        if (role == "Administrator") {
                            out.println("<td><p><a href=" + "'/editApartment?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                        } else {
                            out.println("<form action=\"/bookApartment\" method=\"POST\">");
                            out.println("<div>");
                            out.println("<input type = \"hidden\" value=\"" + s.getId() + "\" name=\"id\">");
                            out.println("<input type = \"hidden\" value=\"" + request.getAttribute("session") + "\" name=\"session\">");
                            out.println("</div>");
                            out.println("<div>");
                            out.println("<button>Book Apartment</button>");
                            out.println("</div>");
                            out.println("</form>");
                        }
                        out.println("</p></td>");
                        out.println("</tr>");
                    }
                    if(role == "Administrator") {
                        out.println("<tr>");
                        out.println("<td><p>" + s.getId() + "</p></td>");
                        out.println("<td><p>" + s.getApartmentName() + "</p></td>");
                        out.println("<td><p>" + s.getRoomCount() + "</p></td>");
                        out.println("<td><p>" + s.getRoomPrice() + "</p></td>");
                        out.println("<td><p>");
                        if (role == "Administrator") {
                            out.println("<td><p><a href=" + "'/editApartment?id=   " + s.getId() + " ' >Редактировать</a></p></td>");
                        } else {
                            out.println("<form action=\"/bookApartment\" method=\"POST\">");
                            out.println("<div>");
                            out.println("<input type = \"hidden\" value=\"" + s.getId() + "\" name=\"id\">");
                            out.println("<input type = \"hidden\" value=\"" + request.getAttribute("session") + "\" name=\"session\">");
                            out.println("</div>");
                            out.println("<div>");
                            out.println("<button>Book Apartment</button>");
                            out.println("</div>");
                            out.println("</form>");
                        }
                        out.println("</p></td>");
                        out.println("</tr>");
                    }
                }
            }
        %>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <%
                if(request.getAttribute("apartment") != null) {
                    Apartment apartment = (Apartment) request.getAttribute("apartment");
                    if (apartment != null) {
                        out.println("Забронированный номер " + apartment.getApartmentName());
                    }
                }
            %>
        </div>
    </table>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/closeSession'">Close Session</button>
    <button class="w3-btn w3-round-large" onclick="location.href='/listApartment'">Back to main</button>
</div>
</body>
</html>
