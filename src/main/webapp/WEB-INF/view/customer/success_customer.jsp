<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clientes</title>
</head>
<body>
    <h2 class="header">${successCustomerTransaction}</h2>
    <div class="action">
        Volver a <a href="<c:url value='/customer/list' />"> lista de Clientes.</a>
    </div>
    <link rel="stylesheet" href="/resources/css/shared.css">
</body>
</html>
