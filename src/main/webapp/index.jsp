<%@page import="proyectoServicio.demo.jpa.entity.UsuarioJPA"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Proyecto Servicio Turistico</title>
    
    <!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <!--ini :css -->
	<jsp:include page="importCss.jsp"/>
	<!--fin :css -->
    
</head>
<body id="page-top">
<!-- ini:validamos session -->
<%
boolean valido = false;
UsuarioJPA usuario = (UsuarioJPA)session.getAttribute("usuarioSession");

if(usuario == null)valido = false;
else {valido = true;}

if(!valido){
	response.sendRedirect("login.jsp");
}
%>
<!-- fin:validamos session -->

	<!--  Pagina Incio -->
    <div id="wrapper">

        <!-- ini: Menu dinamico -->
		<jsp:include page="menuPrincipal.jsp"/>
        <!-- fin Menu dinamico  -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
        
        	<div id="content">
        
	        	<!-- ini: Navbar principal -->
	            <jsp:include page="navbarPrincipal.jsp"/>
	        	<!-- fin:navbar principal -->
            
            <!-- pagina inicio -->
    		<div class="container"> 
                	<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel"  >
  						<div class="carousel-inner" >
		    				<div class="carousel-item active" >
		      					<img id="imagen1" class="d-block w-100" src="https://cutt.ly/FjlvC4P" alt="First slide" width="250" height="300" >
		    				</div>
		    				
						    <div class="carousel-item">
						      <img id="imagen2" class="d-block w-100" src="https://cutt.ly/7jlbw1c" alt="Second slide" width="250" height="300 " >
						    </div>
						    
						    <div class="carousel-item">
						      <img  id="imagen3"class="d-block w-100" src="https://cutt.ly/MjkrzUq" alt="Third slide" width="250" height="300" >
						    </div>
						    
						    <br><br><br>
						    <div  id ="overlay" class="overlay" >
		            			<div class="d-flex justify-content-center align-items-center h-100">
		              				<div class="row align-items-center h-100">
		                				<div class="col-md-12  text-center text-md-center">
		                					<div class="text-white">
			                 		 			<h1 class="mb-3">Disfruta lo mejor del Perú</h1>
			                 		 			<h4 class="mb-3">Los Mejores Precios estan aqui!!</h4>
			                  					<a class="btn btn-outline-light btn-lg" href="#!" role="button">Comprar Ya!</a >
		                  					</div>
		                				</div>
		              				</div>
		            			</div>
	          				</div>
  						</div>
					</div>  
                <br>
                          
			      <div class="container">
			        <!-- Navbar -->
			      	 <nav class="navbar navbar-expand-lg navbar-light bg-light">

			            <button
			              class="navbar-toggler"
			              type="button"
			              data-mdb-toggle="collapse"
			              data-mdb-target="#navbarSupportedContent"
			              aria-controls="navbarSupportedContent"
			              aria-expanded="false"
			              aria-label="Toggle navigation"
			            >
			              <i class="fas fa-bars"></i>
			            </button>
			
			            <!-- Collapsible wrapper -->
			            <div class="collapse navbar-collapse" id="navbarSupportedContent">
				              <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					                <li class="nav-item">
					                  <a class="nav-link active" aria-current="page" href="#">Lugares</a>
					                </li>
					                
					                <!-- sub menu servicios -->
					                <li class="nav-item dropdown">
								        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								          Servicios
								        </a>
								        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
								          <a class="dropdown-item" href="#">Boletos Incluidos</a>
								          <a class="dropdown-item" href="#">Guia Turistico</a>
								          <div class="dropdown-divider"></div>
								          <a class="dropdown-item" href="#">Servicios de Comida</a>
		        						</div>
		      						</li>
		     
					                <li class="nav-item">
					                  <a
					                    class="nav-link" href="#" tabindex="-1" aria-disabled="true"
					                    >Ofertas Exclusivas</a
					                  >
					                </li>
				              </ul>
	
			              		<!-- buscador secundario  -->
				              	<form class="form-inline my-2 my-lg-0">
	      							<input class="form-control mr-sm-2" id="buscar" type="search" placeholder="Buscar">
	      							<button class="btn btn-outline-success my-2 my-sm-0" id="boton" type="submit">Buscar</button>
	   							</form>
			            </div>
			        </nav>
			     </div>
			     <br>  
			        <!-- Catalogo de Viajes-->
			        <section class="text-center mb-4">
			          <div class="row">
			          
			          <c:forEach  var ="lugaresTuristicos" items="${lstLugaresTuristicos }">
				            <div class="col-lg-4 col-md-12 mb-4">
				              <div  class="card">
				                <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
				                  <img src="${lugaresTuristicos.urlImagen1 }" class="img-fluid" />
				                  <a href="#!">
				                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15)"></div>
				                  </a>
				                </div>
				                <div class="card-body">
				                  <h5 id="listaPaquetes" class="card-title">${lugaresTuristicos.nombre}</h5>
				                  <h6> S/. ${lugaresTuristicos.precioXpersona }</h6>
				                  <p class="card-text">${lugaresTuristicos.descripcion}</p>
				                  
				                
				                <a class="btn btn-primary" href=" <%=request.getContextPath()%>/ServletInfoTour?idLugarTuristico=${lugaresTuristicos.idLugarTuristico}">ver</a>
				                </div>
				              </div>
				            </div> 
			            </c:forEach>
			            
			            
			          </div>
			        </section>
			        <!--fin : Catalogo de Viajes-->
			 </div>
                <!-- end Page Content -->
            </div>
            <!-- End of Main Content -->

            <!--ini :footer -->
			<jsp:include page="pages/footer.jsp"/>
			<!--fin :footer -->
        </div>
    <!-- End of Page Wrapper -->
</div>
    <!-- Scroll Index-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

</body>
	<!--ini:Js -->
	<jsp:include page="importJs.jsp"/>	
	<!--fin:Js --> 	
	<script type="text/javascript">
	
	</script>
	
	
</html>