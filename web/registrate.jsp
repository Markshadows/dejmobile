<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }
        </style>
        <title>Regístrate</title>
    </head>
    <body>
        <jsp:include page="indexLogin.jsp"></jsp:include>
            <div class="col-sm-offset-1">
                <h3>Dej Mobile : Registro</h3>
            </div>
            <form class="form-horizontal" method="post" action="ServletPrincipal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="rut">Rut</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="rut" placeholder="Rut" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="clave">Clave:</label>
                    <div class="col-sm-2"> 
                        <input type="password" class="form-control" name="clave" placeholder="Clave" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="confirmarClave">Confirmar Clave:</label>
                    <div class="col-sm-2"> 
                        <input type="password" class="form-control" name="confirmarClave" placeholder="Confirmar Clave" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                    <div class="col-sm-2"> 
                        <input type="text" class="form-control" name="nombre" placeholder="Nombre" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="appaterno">Apellido Paterno:</label>
                    <div class="col-sm-2"> 
                        <input type="text" class="form-control" name="appaterno" placeholder="Apellido Paterno" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="apmaterno">Apellido Materno:</label>
                    <div class="col-sm-2"> 
                        <input type="text" class="form-control" name="apmaterno" placeholder="Apellido Materno" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="direccion">Dirección:</label>
                    <div class="col-sm-2"> 
                        <input type="text" class="form-control" name="direccion" placeholder="Dirección" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="numeracion">Numeración:</label>
                    <div class="col-sm-2"> 
                        <input type="text" class="form-control" name="numeracion" placeholder="Numeración" required="">
                    </div>
                </div>
            <sql:setDataSource driver="com.mysql.jdbc.Driver"
                               password="root" user="root"
                               url="jdbc:mysql://localhost/Dej Mobile"
                               var="bdd"/>
            <sql:query var="regs" dataSource="${bdd}">
                SELECT * FROM COMUNA;
            </sql:query>
            <div class="form-group">
                <label class="control-label col-sm-2" for="comuna">Comuna:</label>
                <div class="col-sm-3">
                    <select class="form-control" name="Cbocomuna">
                        <option value="fila">Seleccione</option>
                        <c:forEach var="fila" items="${regs.rows}">                                
                            <option value="${fila.idComuna}">
                                <c:out value="${fila.comuna}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="telefono">Teléfono:</label>
                <div class="col-sm-2"> 
                    <input type="text" class="form-control" name="telefono" placeholder="Teléfono" required=""> 
                </div>
            </div>
            <div class="form-group"> 
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" name="btnAccion" value="GuardarCliente">Enviar</button>
                    <a href="login.jsp">Volver</a>
                </div>
            </div>
        </form>
        <c:choose>
            <c:when test="${mensaje == 'Exito'}">
                <div class="alert alert-success  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Exito!</strong> Registro exitoso!
                </div>
            </c:when>
            <c:when test="${mensaje == 'Grabar'}">
                <div class="alert alert-danger  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Error!</strong> Error al grabar!.
                </div>
            </c:when>
            <c:when test="${mensaje == 'Clave'}">
                <div class="alert alert-danger  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Error!</strong> Las claves no coinciden!.
                </div>
            </c:when>
            <c:when test="${mensaje == 'Rut'}">
                <div class="alert alert-danger  fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Error!</strong> Rut inválido!.
                </div>
            </c:when>
        </c:choose><br>
        <footer class="container-fluid text-center">
            <p>Dej Mobile derechos reservados</p>
        </footer>
    </body>
</html>


