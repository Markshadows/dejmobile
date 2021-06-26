
<%
    HttpSession se = request.getSession();
    if (se.getAttribute("usuario") == null) {
        request.setAttribute("mensaje", "Ingreso no Valido");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <script src="bootstrap/js/jqueryMio.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <style>
            .navbar-inverse{
                background-color: #1da8dc;
                border: #fefefe;
            }
            .navbar-nav{
                background-color: #1da8dc;
            }
            .navbar li a, .navbar .navbar-brand {
                color: #fff !important;
            }
            .navbar-nav li a:hover, .navbar-nav li.active a {
                color: #fff !important;
                background-color: #0033cc !important;
            }
            .well{
                background-color: #1da8dc;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="menu.jsp"><img src="img/personal-logo-apllicacion.jpg" width="75" height="30"></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="misPlanes.jsp">Ver mis planes</a></li>
                        <li><a href="solicitarPlan1.jsp">Solicitar un plan</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>Bienvenido(a) ${usuario}</a></li>
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
