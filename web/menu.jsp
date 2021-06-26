
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Menú</title>

        <style>
            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #1da8dc;
                padding: 25px;
            }

            .carousel-inner img {
                width: 100%; /* Set width to 100% */
                min-height: 200px;
            }

            /* Hide the carousel text when the screen is less than 600 pixels wide */
            @media (max-width: 600px) {
                .carousel-caption {
                    display: none; 
                }
            }
            .logo-small {
                color: #1da8dc;
                font-size: 50px;
            }
            .well{
                background-color: #1da8dc;
            }
        </style>

    </head>
    <body>

        <jsp:include page="indexMenu.jsp"></jsp:include>

        <div class="container" bg>
            <div class="row">
                <div class="col-sm-8">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="img/smartphone-1446817653953.jpg" alt="Image">
                                <div class="carousel-caption">
                                </div>      
                            </div>

                            <div class="item">
                                <img src="img/celulares-en-la-educacion.jpg" alt="Image">
                                <div class="carousel-caption">
                                </div>      
                            </div>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previo</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Siguiente</span>
                        </a>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <p>Contamos con los mejores planes del mercado,
                        disponibles en sucursales y ahora en nuestra página</p>
                    </div>
                    <div class="well">
                        <p>Tarifas bajas a todo destino, incluyendo internacionales,
                        como nunca lo habrás imaginado!!</p>
                    </div>
                    <div class="well">
                        <p>Redes sociales gratis, incluyendo acceso a links adjuntos
                        dentro de las mismas!!</p>
                    </div>
                </div>
            </div>
            <hr>
        </div>

        <div class="container text-center">    
            <h3>Ofrecemos..</h3>
            <br>
                <div class="row">
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-signal logo-small"></span>
                    <h4>Red 4G</h4>
                    <p>En toda la región</p>
                </div>
                    <div class="col-sm-4">
                    <span class="glyphicon glyphicon-refresh logo-small"></span>
                    <h4>Portabilidad</h4>
                    <p>Desde cualquier compañía</p>
                </div>
                <div class="col-sm-4">
                    <span class="glyphicon glyphicon-usd logo-small"></span>
                    <h4>Valor</h4>
                    <p>Acorde al mercado</p>
                </div>
            </div>
            <hr>
        </div>

        <div class="container text-center">    
            <h3>Portabilidad desde..</h3>
            <br>
            <div class="row">
                <div class="col-sm-2">
                    <img src="img/Entel-logo.png" class="img-responsive" style="width:100%" alt="Image">

                </div>
                <div class="col-sm-2"> 
                    <img src="img/Movistar-logo-old.png" class="img-responsive" style="width:100%" alt="Image">
                       
                </div>
                <div class="col-sm-2"> 
                    <img src="img/WOM_Chile_logo_(fondo_violeta).svg.png" class="img-responsive" style="width:100%" alt="Image">
                   
                </div>
                <div class="col-sm-2"> 
                    <img src="img/vm-logo-fb.png" class="img-responsive" style="width:100%" alt="Image">
                    
                </div> 
                <div class="col-sm-2"> 
                    <img src="img/Q93cOIuR_400x400.png" class="img-responsive" style="width:100%" alt="Image">
                    
                </div>     
                <div class="col-sm-2"> 
                    <img src="img/claro_thumb.png" class="img-responsive" style="width:100%" alt="Image">
                    
                </div> 
            </div>
        </div><br>

        <footer class="container-fluid text-center">
            <p>Dej Mobile derechos reservados</p>
        </footer>

    </body>
</html>
