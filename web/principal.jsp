<%-- 
    Document   : principal
    Created on : 05-jul-2015, 15:46:02
    Author     : YerkoAndrei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        #izquierda 
        {
            float:left;
        }
       </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tüiter</title>
    </head>
    <body style="background:#58ACFA">
    <div id="izquierda">
        <img src="tuiter.png" width="200" height="200">
        <h3>HashTags</h3>
        <table>
            <c:forEach var="ht" items="${sessionScope.listaHashtags}">
                <tr>
                    <td><a href="paginaHashtag.do?x=${ht}" >#${ht}</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <h3>Comentarios de ti</h3>
            <form action="verChat.do" method="post"><input type="submit" value="Ver mensajes"/></form>
        
        <h3>Usuarios</h3>  
        <form action="seguir.do" method="post">
        <select name="usuarioSelect">
            <c:forEach var="us" items="${sessionScope.listaUsuarios}">
                <option>${us.getUser()}</option>
            </c:forEach>
        </select>
            <input type="submit" value="seguir"/>
        </form>
    </div>
    <center>
        <c:forEach var="na" items="${sessionScope.nombreSesionActual}">
            <h1>Bienvenido: ${na}</h1>
        </c:forEach>
        <h3>Escribe un comentario</h3>
        <form action="anadir_mensaje.do" method="post">
            <table>
                <tr>
                    <td><textarea maxlength="140" wrap="hard" name="texto" cols="60" rows="3" style="resize:none">Escribe un comentario...</textarea></td>
                    <td><input type="submit" value="Twittear"/></td>
                </tr>
            </table>
        </form>
        <h2>Tüits</h2>
            <table>
                <c:forEach var="co" items="${sessionScope.listaComentarios}">
                    <tr>
                        <td>${co.getUser().getUser()}  -  ${co.getUser().getNombre()}</td>
                    </tr>
                    <tr>
                        <td><textarea readonly="" cols="60" rows="3" style="resize:none">${co.getTexto()}</textarea></td>
                        <td><form action="retwittear.do?completo=${co.getTexto()}-${co.getUser().getUser()}" method="post"><input type="submit" value="Retwittear"></form></td>
                    </tr>
                </c:forEach>
            </table>
   </center>
   </body>
</html>
