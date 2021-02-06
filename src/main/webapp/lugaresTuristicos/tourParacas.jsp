<%@page import="proyectoServicio.demo.jpa.entity.UsuarioJPA"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="ISO-8859-1">
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Tour Paracas</title>
	
	<!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!--ini :css -->
	<jsp:include page="../importCss.jsp"/>
	<!--fin :css -->
	
	<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
      crossorigin="anonymous"/>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    
    <link href="css/cssProductService.css" rel="stylesheet" />
</head>
<body id="page-tourParacas">
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
	<div id="wrapper">
		<!-- ini: Menu dinamico -->
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" >

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                <div class="sidebar-brand-icon">
	                <img src="img/logo.png" class="img-fluid" height="100px" width="100px" >
                </div>
                <div class="sidebar-brand-text mx-2">Menú </div>
            </a>
            
			<!-- lista menu	 -->
       		<c:forEach var="menu" items="${lstMenu}">
			<!--Item Menu -->
		        <li class="nav-item">
		             <a class="nav-link"  href="${menu.urlMenu}" >${menu.menu}</a>            
			<!-- Divider -->
            	     <hr class="sidebar-divider d-none d-md-block">          
	            </li>
            </c:forEach>

            <!-- Esconder Menu -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul> 
        <!-- fin Menu dinamico  -->
        <div id="content-wrapper" class="d-flex flex-column">
        
        	<div id="content">
        		<!-- ini: Navbar principal -->
	            <jsp:include page="../navbarPrincipal.jsp"/>
	        	<!-- fin:navbar principal -->
	        	<div class="container">
			      <div class="row justify-content-md-center">
			        <div class="col-md-5">
			          <div
			            id="carouselExampleControls"
			            class="carousel slide"
			            data-bs-ride="carousel"
			          >
			            <div class="carousel-inner">
			              <div class="carousel-item active">
			                <img
			                  src="https://cutt.ly/Pkdph5m"
			                  class="d-block w-100"
			                  alt="..."
			                  width="200px"
			                  height="400px"
			                />
			              </div>
			              <div class="carousel-item">
			                <img
			                  src="https://cutt.ly/kkdpvoc"
			                  class="d-block w-100"
			                  alt="..."
			                  width="200px"
			                  height="400px"
			                />
			              </div>
			              <div class="carousel-item">
			                <img
			                  src="https://cutt.ly/ZkdpAke"
			                  class="d-block w-100"
			                  alt="..."
			                  width="200px"
			                  height="400px"
			                />
			              </div>
			            </div>
			            <a
			              class="carousel-control-prev"
			              href="#carouselExampleControls"
			              role="button"
			              data-bs-slide="prev"
			            >
			              <span
			                class="carousel-control-prev-icon"
			                aria-hidden="true"
			              ></span>
			              <span class="visually-hidden">Previous</span>
			            </a>
			            <a
			              class="carousel-control-next"
			              href="#carouselExampleControls"
			              role="button"
			              data-bs-slide="next"
			            >
			              <span
			                class="carousel-control-next-icon"
			                aria-hidden="true"
			              ></span>
			              <span class="visually-hidden">Next</span>
			            </a>
			          </div>
			        </div>
			        <div class="col-md-5">
				          <p class="tour text-center">Free</p>
				          <h2>Tour Paracas</h2>
				          <p>Servicio codigo:003</p>
				          <span class="fa fa-star checked"></span>
				          <span class="fa fa-star checked"></span>
				          <span class="fa fa-star checked"></span>
				          <span class="fa fa-star checked"></span>
				          <span class="fa fa-star"></span>
				          <p class="precio">S/. 110.00</p>
				          <p><b>Habilitado: </b>Cantidad ilimitada</p>
				          <p><b>Clima: </b>Caluroso 20-30°C</p>
				          <p><b>Servicios: </b></p>
				          <ul class="list-group list-group-flush">
				            <li class="list-group-item">Cras justo odio</li>
				            <li class="list-group-item">Dapibus ac facilisis in</li>
				            <li class="list-group-item">Morbi leo risus</li>
				          </ul>
				          <br />
				          <label>Cantidad: </label>
				          <select name="cars" id="cars">
				            <option value="volvo">1</option>
				            <option value="saab">2</option>
				            <option value="mercedes">3</option>
				            <option value="audi">4</option>
				            <option value="volvo">5</option>
				            <option value="saab">6</option>
				            <option value="mercedes">7</option>
				            <option value="audi">8</option>
				            <option value="volvo">9</option>
				            <option value="saab">10</option>
				          </select>
				          <button type="button" class="btn btn-success">
				            Agregar al carrito
				          </button>
			        </div>
			      </div>
			    </div>
        	</div>
        		<!--ini :footer -->
				<jsp:include page="../pages/footer.jsp"/>
				<!--fin :footer --> 
        </div>
	</div>

</body>
	<!--ini:Js -->
	<jsp:include page="../importJs.jsp"/>	
	<!--fin:Js --> 
</html>