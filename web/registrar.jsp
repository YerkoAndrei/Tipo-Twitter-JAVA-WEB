<%-- 
    Document   : registrar
    Created on : 05-jul-2015, 16:04:27
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
            <h1>Regístrese</h1>
            <form action="registrar.do">
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
                        <td>Confirme Password</td>
                        <td><input type="password" name="txtPass2" maxlength="30"/></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="txtNombre" maxlength="30"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Registrarse"/></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
