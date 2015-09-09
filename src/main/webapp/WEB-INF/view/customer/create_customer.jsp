<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clientes</title>
</head>
<body>
    <div>
        <h2 class="header">Formulario para gestion de clientes </h2>
        <div>
            <form:form method="POST" modelAttribute="customer">
                <form:input type="hidden" path="id" id="id"/>
                <table class="content">
                    <tr>
                        <td><label for="name">Name: </label> </td>
                        <td><form:input path="name" id="name"/></td>
                    </tr>

                    <tr>
                        <td><label for="email">email: </label> </td>
                        <td><form:input path="email" id="email"/></td>
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
            <a href="<c:url value='/customer/new' />">Gestionar sus productos</a>,&nbsp;
            Volver a <a href="<c:url value='/customer/list' />">Lista de Clientes</a>
        </div>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>