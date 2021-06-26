<%-- 
    Document   : solicitarPlan2
    Created on : 08-dic-2016, 18:58:41
    Author     : scarecrow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="indexMenu.jsp"></jsp:include>
            <form method="post" action="ServletPrincipal">
                <h1>Solicitar Plan :: Paso 2</h1>
                <table border="1">
                    <tr>
                        <td>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Confirmar Plan</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${descripcionNav}</td>
                        </tr>
                        <tr>
                            <td>${descripcionMin}</td>
                        </tr>
                        <tr>
                            <td>Entrega del chip: ${entrega}</td>
                        </tr>
                        <tr>
                            <td>Total: $${total} Mensuales</td>
                        </tr>
                        <tr>
                            <td>
                                <a href="javascript:history.back()">Volver</a>
                                <button type="submit" class="btn btn-default" name="btnAccion" value="Paso2">Enviar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                    </td>
        </tr>
            </table>
            <a href="menu.jsp">Ir al menu</a>
    </body>
</html>
