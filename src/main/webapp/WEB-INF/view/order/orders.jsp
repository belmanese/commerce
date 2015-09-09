<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Facturas</title>
</head>
<body>
    <div>
        <h2 class="header">Gestion de facturas</h2>
        <div>
            <table class="content">
                <tr class="title">
                    <td>ID</td>
                    <td>CLIENTE</td>
                    <td>DIRECCIÓN DE ENTREGA</td>
                    <td>CORREO ELECTRONICO</td>
                    <td>FECHA</td>
                    <td>TAZA DE CAMBIO</td>
                </tr>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td><a href="<c:url value='/edit-${order.id}-order' />">${order.id}</a></td>
                        <td>${order.customer.name}</td>
                        <td>${order.deliveryAddress}</td>
                        <td>${order.customer.email}</td>
                        <td>${order.date}</td>
                        <td>${order.currencyRate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="action">
            <a href="<c:url value='/new' />">Crear una nueva factura</a>,&nbsp;
            <a href="<c:url value='/customer/list' />">Gestion de Clientes</a>,&nbsp;
            <a href="<c:url value='/product/list' />">Gestion de Productos</a>
        </div>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>
