<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clientes</title>
</head>
<body>
    <div>
        <h2 class="header">Gestion de clientes</h2>
        <div>
            <table class="content">
                <tr class="title">
                    <td>NOMBRE</td>
                    <td>CORREO ELECTRONICO</td>
                </tr>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td><a href="<c:url value='/customer/edit-${customer.id}-customer' />">${customer.name}</a></td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="action">
            <a href="<c:url value='/customer/new' />">Añadir nuevo Cliente</a>,&nbsp;
            <a href="<c:url value='/' />">Gestion de Ordenes</a>,&nbsp;
            <a href="<c:url value='/product' />">Gestion de Productos</a>
        </div>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>