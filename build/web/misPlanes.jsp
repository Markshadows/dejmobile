<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="indexMenu.jsp"></jsp:include>
        <form>
            <sql:setDataSource driver="com.mysql.jdbc.Driver"
                               password="root" user="root"
                               url="jdbc:mysql://localhost/Dej Mobile"
                               var="bdd"/>
            <sql:query var="registros" dataSource="${bdd}">
                SELECT SOL.idSolicitud codigo,
                SUBSTRING(NAV.descripcion,1,2) gigas,
                SUBSTRING(MINU.descripcion,1,4) minutos,
                SOL.entrega entrega,
                CLI.telefono telefono,
                COM.comuna comuna,
                SOL.fecha_hora ingreso,
                SOL.total
                FROM 
                COMUNA COM JOIN CLIENTE CLI ON CLI.Comuna_idComuna=COM.idComuna
                JOIN SOLICITUD SOL ON SOL.Cliente_rut = CLI.rut
                JOIN NAVEGACION NAV ON SOL.Navegacion_cuota = NAV.idNavegacion
                JOIN MINUTOS MINU ON SOL.Minutos_minutos = MINU.idMinutos
                WHERE CLI.rut = '${rut}';
            </sql:query>
            <div class="col-sm-offset-1">
                <h3>Mis Planes</h3>
            </div>


            <div class="container"> 
                <div>
                    <table class="table table-stripped">
                        <tr>
                            <td>CODIGO</td>
                            <td>GIGAS</td>
                            <td>MINUTOS</td>
                            <td>ENTREGA DE CHIP</td>
                            <td>TELEFONO</td>
                            <td>COMUNA</td>
                            <td>INGRESO</td>
                            <td>TOTAL</td>
                        </tr>
                        <c:forEach var="fila" items="${registros.rows}">           
                            <tr>
                                <td><c:out value="${fila.idSolicitud}"/></td>
                                <td><c:out value="${fila.gigas}"/></td>
                                <td><c:out value="${fila.minutos}"/></td>
                                <td><c:out value="${fila.entrega}"/></td>
                                <td><c:out value="${fila.telefono}"/></td>
                                <td><c:out value="${fila.comuna}"/></td>
                                <td><c:out value="${fila.fecha_hora}"/></td>
                                <td><c:out value="$${fila.total}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div></div>
        </form>
            <div>
                <a href="javascript:history.back()">Volver</a>
            </div>
    </body>
</html>
