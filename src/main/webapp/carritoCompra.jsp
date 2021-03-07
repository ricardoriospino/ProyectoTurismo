<%@page import="proyectoServicio.demo.jpa.entity.UsuarioJPA"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Carrito Compras</title>
    
    <!-- importar libreria a la clase -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
	crossorigin="anonymous">
	
	<!--ini :css -->
	<jsp:include page="importCss.jsp"/>
	<!--fin :css -->
	
<body id="page-top">

<%
boolean valido = false;
UsuarioJPA usuario = (UsuarioJPA)session.getAttribute("usuarioSession");

if(usuario == null)valido = false;
else {valido = true;}

if(!valido){
	response.sendRedirect("login.jsp");
}
%>

<div id="wrapper">
	
		<!-- ini: Menu dinamico -->
		<jsp:include page="menuPrincipal.jsp"/>
        <!-- fin Menu dinamico  -->
        
        <div id="content-wrapper" class="d-flex flex-column">
        
        	<div id="content">
        		<!-- ini: Navbar principal -->
	            <jsp:include page="navbarPrincipal.jsp"/>
	        	<!-- fin:navbar principal -->
	        	
	        	<div class="col-md-12 ">
	        	
	        		<div class="container-fluid  ">
		        		<span class="anchor" id="formUserEdit"></span>
		        		
		        		<div class="card card-outline-secondary">
							<div class="card-header">
								<h5 class="mb-0">Datos Usuario</h5>
								<form>
									<div class="form-row">
										<div class="col-md-3 mb-3">
											<label for="validationDefault01">id Usuario</label> <input
												type="text" class="form-control text-center" id="validationDefault01"
												 disabled="disabled" value="<%=usuario.getIdUsuario() %>" required>
										</div>
										<div class="col-md-4 mb-3">
											<label for="validationDefault02">Nombre </label> <input
												type="text" class="form-control text-center" id="validationDefault02"
												 disabled="disabled" value="<%=usuario.getNombreUsuario() %>" required>
										</div>
										<div class="col-md-4 mb-3">
											<label for="validationDefault02">Apellido</label> <input
												type="text" class="form-control text-center" id="validationDefault02"
												 disabled="disabled" value="<%=usuario.getApellido() %>" required>
										</div>
										
									</div>					
								</form>				
							</div>				
						</div> 
		        	</div>
		        	<br>
	        	<!--Section: Block Content-->
					    <section>
					      <!--Grid row-->
					      <div class="row">
					        <!--Grid column-->
					        <div class="col-lg-8">
					       
						          <!-- Card -->
						          <div class="card wish-list mb-3">
						            <div class="card-body">
						              <h5 class="mb-4">Carrito de Compra</h5>
						              
									 <c:forEach var="varCompra" items="${carritoCompras}">
						              <div class="row mb-4">
						                <div class="col-md-5 col-lg-3 col-xl-3">
						                  <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
						                    <a href="#!">
						                      <div class="mask waves-effect waves-light">
						                        <img class="img-fluid w-100" src="${varCompra.imagenTour}"/>
						                        <div class="mask rgba-black-slight waves-effect waves-light"></div>
						                      </div>
						                    </a>
						                  </div>
						                </div>
						                <div class="col-md-6 col-lg-9 col-xl-9">
						                    <div class="d-flex justify-content-around">
						                    
						                      <div>
						                        <h5>${varCompra.nombreTour}</h5>
						                      </div>
						                        <div class="col-md-3 offset-md-3">
							                        <label class="form-check-label" >Cantidad</label>
							                        <input type="text" name="Cantidad" class="form-control text-center"  disabled="disabled" value="${varCompra.cantidad}">
						                        </div>
						                    </div>
						                    <div class="d-flex justify-content-between align-items-center"><div>
						                        <a type="button" class="card-link-secondary small text-uppercase mr-3" id="deleteItem" href="<%=request.getContextPath()%>/ServletEliminarItem?idTour=${varCompra.idTour}" >
						                        <i class="fas fa-trash-alt mr-1"></i> Eliminar
						                        </a>
						                      </div>
						                      <p class="mb-0">
						                        <span><strong>S/. ${varCompra.subTotal}0</strong></span>
						                      </p>
						                    </div>
						                </div>
						              </div>
						               <hr class="mb-4" />
						              </c:forEach>
						              <a href="javascript:window.history.go(-2);">SeguirComprando</a>  
						            </div>
						          </div>
						          <!-- Card -->

					          <!-- Card -->
					          <div class="card mb-3">
					            <div class="card-body">
					              <h5 class="mb-4">Aceptamos</h5>
					
					              <img
					                class="mr-2"
					                width="45px"
					                src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
					                alt="Visa"
					              />
					              <img
					                class="mr-2"
					                width="45px"
					                src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
					                alt="American Express"
					              />
					              <img
					                class="mr-2"
					                width="45px"
					                src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
					                alt="Mastercard"
					              />
					            </div>
					          </div>
					          <!-- Card -->
					        </div>
					        <!--Grid column-->
					
					        <!--Grid column-->
					        <div class="col-lg-4">
					          <!-- Card -->
					          <div class="card mb-3">
					            <div class="card-body">
					              <h5 class="mb-3">Monto Total</h5>
					
					              <ul class="list-group list-group-flush">
					                <li
					                  class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
					                >
					                  Sub Total
					                  <span>S/. ${totalSinIgv }</span>

					                  
					                </li>
					                <li
					                  class="list-group-item d-flex justify-content-between align-items-center px-0"
					                >
					                  Igv
					                  <span>S/. ${TotlIgv}</span>

					                </li>
					                <li
					                  class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3"
					                >
					                  <div>
					                    <strong>Monto Total</strong>
					                  </div>
					                  <span><strong>S/. ${totalConIgv}</strong></span>

					                </li>
					              </ul>
					
					              <button type="button" class="btn btn-primary btn-block waves-effect waves-light">Pagar</button>
					              
					            </div>
					          </div>
					          <!-- Card -->
					        </div>
					        <!--Grid column-->
					      </div>
					      <!--Grid row-->
					    </section>
					    <!--Section: Block Content-->
				</div>
        	
        	</div>
        	<footer>
        	<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
		        © 2020 Copyright:
		        <a class="text-dark" href="">Ricardo Rios</a>
		     </div>
        	</footer>
        		
		</div>
	</div>

</body>
		<!--ini:Js -->
		<jsp:include page="importJs.jsp"/>	
		<!--fin:Js --> 	
	
</html>