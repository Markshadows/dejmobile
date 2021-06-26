<%
    HttpSession se=request.getSession();
    se.removeAttribute("usuario");
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            footer {
                background-color: #f2f2f2;
                padding: 25px;
            }
        </style>
        </head>
        <body>
            <jsp:include page="indexLogin.jsp"></jsp:include>
            <div class="container col-sm-3">
            <div class="jumbotron">
                <h3>Dej Mobile</h3>
                <h5>Acceso</h5>
                <form class="form-horizontal" method="post" action="ServletPrincipal">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="rut">Rut:</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="rut" placeholder="Rut" required="">
                        </div>
                    </div>
                    <div class="form-group">
                            <label class="control-label col-sm-3" for="clave">Clave:</label>
                        <div class="col-sm-9"> 
                            <input type="password" class="form-control" name="clave" placeholder="Clave" required="">
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="btnAccion" value="Logear">Enviar</button>
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-2 col-sm-10">
                            <a href="registrate.jsp">Regístrate</a>
                        </div>
                    </div>
                </form>
                <c:choose>
                <c:when test="${mensaje == 'Error'}">
                    <div class="alert alert-danger  fade in">
                       <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                      <strong>Error!</strong> Usuario o clave incorrectas.
                    </div>
                </c:when>
            </c:choose>
            </div>
        </div>
    </body>
</html>
