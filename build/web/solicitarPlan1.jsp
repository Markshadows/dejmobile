
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
        <div>
            <jsp:include page="indexMenu.jsp"></jsp:include>
                <form method="post" action="ServletPrincipal">
                    <h1>Arma Tu Plan::Paso 1</h1>
                    <table border="1">
                        <tr>
                            <td>
                                <table class="table table-striped">
                                    <tr>
                                    <sql:setDataSource driver="com.mysql.jdbc.Driver"
                                                       password="root" user="root"
                                                       url="jdbc:mysql://localhost/Dej Mobile"
                                                       var="bdd"/>
                                    <sql:query var="regs" dataSource="${bdd}">
                                        SELECT * FROM NAVEGACION;
                                    </sql:query>
                                    <tr>
                                    <td>Cuota:</td>
                                    <td>
                                        <select class="form-control" name="cboNavegacion">
                                            <option value="fila">Seleccione</option>
                                            <c:forEach var="fila" items="${regs.rows}">                                
                                                <option value="${fila.idNavegacion}">
                                                    <c:out value="${fila.descripcion}"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    </tr>
                                </tr>
                        </td>
                    <tr>
                        <sql:query var="regs2" dataSource="${bdd}">
                            SELECT idMinutos, substring(descripcion,1,4) descripcion FROM MINUTOS;
                        </sql:query>
                        <td>Minutos:</td> 
                        <td>
                            <c:forEach var="fila" items="${regs2.rows}">
                                <br>
                                <INPUT TYPE="radio" NAME="cboMinutos" VALUE=${fila.idMinutos} CHECKED                                       
                                       >                                
                                <c:out value="${fila.descripcion}"/>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" name="despacho"/>Entrega Chip en Domicilio
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="Menu.jsp">Volver</a>
                            <button type="submit" class="btn btn-default" name="btnAccion" value="Paso1">Enviar</button>
                        </td>
                    </tr>
                    </td>
                    </tr>
                </table>
                </table>
            </form>
            <c:choose>
                <c:when test="${mensaje == 'Cuota'}">
                    <div class="alert alert-danger  fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> Seleccione una cuota de navegación!.
                    </div>
                </c:when>
                <c:when test="${mensaje == 'MinInvalid'}">
                    <div class="alert alert-danger  fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> Error al validar los minutos!.
                    </div>
                </c:when>
                <c:when test="${mensaje == 'NavInvalid'}">
                    <div class="alert alert-danger  fade in">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> Error al validar la cuota de navegación!.
                    </div>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>
