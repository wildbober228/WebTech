<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>Super app!</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
  <h1>Shop!</h1>
</div>

<div class="w3-container w3-center">
  <div class="w3-bar w3-padding-large w3-padding-24">
    <table>
      <tr class="header">
        <tr><p><button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/list'">Просмотреть Товары</button></p></tr>
        <tr><p><button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/add'">Добавить товар</button></p></tr>
        <tr><p> <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/addCustomer'">Добавить покупателя</button></p></tr>
        <tr><p><button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/listCustomer'">Просмотреть покупателей</button></p></tr>
        <tr><p><button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/listOrder'">Просмотреть заказы</button></p></tr>
        <tr><p> <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/addOrder'">Добавить заказ</button></p></tr>
      </tr>
    </table>
  </div>
</div>
</body>
</html>