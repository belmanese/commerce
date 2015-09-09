<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Productos</title>
</head>
<body>
    <div>
        <h2 class="header">Gestion de productos</h2>
        <div>
            <table class="content">
                <tr class="title">
                    <td>NOMBRE</td>
                </tr>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td><a href="<c:url value='/product/edit-${product.id}-product' />">${product.name}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="action">
            <a href="<c:url value='/product/new' />">Añadir nuevo Producto</a>,&nbsp;
            <a href="<c:url value='/' />">Gestion de Ordenes</a>,&nbsp;
            <a href="<c:url value='/customer' />">Gestion de Clientes</a>
        </div>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>