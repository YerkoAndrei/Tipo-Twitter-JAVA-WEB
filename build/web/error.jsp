<%-- 
    Document   : error
    Created on : 05-jul-2015, 16:29:16
    Author     : YerkoAndrei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tüiter</title>
    </head>
    <body style="background:#58ACFA">
        <h1>¡Error!</h1>
        <c:forEach var="error" items="${sessionScope.error}">
            <h2>${error}</h2>
        </c:forEach>
        <a href="index.jsp">Volver</a>
    </body>
</html>
