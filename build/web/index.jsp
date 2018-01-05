<%-- 
    Document   : index
    Created on : 05-jul-2015, 15:45:54
    Author     : YerkoAndrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tüiter</title>
    </head>
    <body style="background:#58ACFA">
        <center>
            <img src="tuiter.png" width="200" height="200">
            <h1>Ingreso</h1>
            <form action="validar.do">
                <table>
                    <tr>
                        <td>User</td>
                        <td><input type="text" name="txtUser" maxlength="30"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="txtPass" maxlength="30"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Ingresar"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="registrar.jsp">¿No tienes una cuenta?</a></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
