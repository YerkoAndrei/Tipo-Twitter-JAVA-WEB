<%-- 
    Document   : chat
    Created on : 08-jul-2015, 20:13:04
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
    <center>
        <h1>Comentarios</h1>
        <h3>Escribe un comentario</h3>
        <form action="anadir_mensaje.do" method="post">
            <table>
                <tr>
                    <td><textarea maxlength="140" wrap="hard" name="texto" cols="60" rows="3" style="resize:none">Escribe un comentario...</textarea></td>
                    <td><input type="submit" value="Twittear"/></td
                </tr>
            </table>
        </form>
        <h2>Comentarios de ti</h2>
        <table>
            <c:forEach var="co" items="${sessionScope.comentariosDeTi}">
                <tr>
                    <td>${co.getUser().getUser()}  -  ${co.getUser().getNombre()}</td>
                </tr>
                <tr>
                    <td><textarea readonly="" cols="60" rows="3" style="resize:none" name="com">${co.getTexto()}</textarea></td>
                    <td><form action="retwittear.do?completo=${co.getTexto()}-${co.getUser().getUser()}" method="post"><input type="submit" value="Retwittear"></form></td>
                </tr>
            </c:forEach>
        </table>
        <a href="actualizarPagina.do">volver</a>
    </center>
    </body>
</html>
