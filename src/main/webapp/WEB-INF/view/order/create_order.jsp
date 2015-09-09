<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Facturas</title>
</head>
<body>
    <div>
        <h2 class="header">Formulario para gestion de facturas </h2>
        <div>
            <form:form method="POST" modelAttribute="orderDto">
                <table class="content">
                    <tr>
                        <td><label for="order.deliveryAddress">Dirección de entrega: </label> </td>
                        <td><form:input path="order.deliveryAddress" id="order.deliveryAddress"/></td>
                        <td>
                    </tr>
                    <tr>
                        <td><label for="customers">Clientes: </label> </td>
                        <td><form:select path="customers">
                            <c:forEach items="${customers}" var="customer">
                                <form:option value="${customer.id}">${customer.name}</form:option>
                            </c:forEach>
                        </form:select></td>
                        <td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <c:choose>
                                <c:when test="${edit}">
                                    <input type="submit" value="Actualizar"/>
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="Registrar"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div class="action">
            Volver a <a href="<c:url value='/list' />">lista de facturas</a>
        </div>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>
