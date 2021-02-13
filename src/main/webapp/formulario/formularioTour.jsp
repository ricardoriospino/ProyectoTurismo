<%@page import="proyectoServicio.demo.jpa.entity.LugarTuristicoJPA"%>
<%@page import="proyectoServicio.demo.jpa.entity.UsuarioJPA"%>
<%@ page import = "java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat"%>
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
	<title>Formulario Tour</title>
	
	<!-- importar libreria a la clase -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
	crossorigin="anonymous">
	
	<!--ini :css -->
	<jsp:include page="../importCss.jsp"/>
	<!--fin :css -->
	
</head>
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

<%

(new java.util.Date()).toLocaleString();

%>


	<div id="wrapper">
		
		<!-- ini: Menu dinamico -->
		<jsp:include page="../menuPrincipal.jsp"/>
        <!-- fin Menu dinamico  -->
        
         <div id="content-wrapper" class="d-flex flex-column">
        
        	<div id="content">
        		<!-- ini: Navbar principal -->
	            <jsp:include page="../navbarPrincipal.jsp"/>
	        	<!-- fin:navbar principal -->
	        	
	        	<div class="col-md-8 offset-md-2">
					<span class="anchor" id="formUserEdit"></span>
					<hr class="my-5">
		
					<div class="card card-outline-secondary">
						<div class="card-header">
							<h3 class="mb-0">Ingrese datos Tour</h3>
						</div>
		
						<c:if test="${ingresado == true}">
							<div class="alert alert-success" role="alert">
								${msg}
							</div>
						</c:if>
		
						<div class="card shadow-lg p-3 mb-5 bg-white">
							<div class="card-header">
								<form class="needs-validation " role="form" autocomplete="off"
									action="ServletInsertUpdateTour" method="post" novalidate>
									
									<input type="hidden" name="hdnAccion" value="${btnAccion}"/><!-- es una variable oculta o un comodin -->
									<input type="hidden" name="hdnIdLugarTuristico" value="${idTour}"/><!-- es una variable oculta o un comodin -->
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Codigo Tour</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.codigoLugarTuristico}'/>"
												name="codigo_lugar_turistico" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo Codigo</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Nombre Tour</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.nombre}'/>"
												name="nombre"  onkeypress="return soloLetras(event)" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el nombre Tour</div>
										</div>
									</div>

									 <div class="mb-1 form-group row">
										  <label  class="form-label">Descripción Tour</label>
										  <textarea class="form-control" rows="5" id="comment"  name="descripcion" required><c:out value='${objTour.descripcion}'/></textarea>
											<div class="valid-feedback">Dato ingresado correctamente</div>
									    <div class="invalid-feedback">Escriba La Descripción</div>
									</div>
									<br>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Link Imagen 1</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.urlImagen1}'/>"
												name="url_imagen1" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo Link 1</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Link Imagen 2</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.urlImagen2}'/>"
												name="url_imagen2" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo Link 2</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Link Imagen 3</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.urlImagen3}'/>"
												name="url_imagen3" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo Link 3</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Precio Tour</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.precioXpersona}'/>"
												name="precio_x_persona" required placeholder="S/. 00.00">
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo con numeros</div>
										</div>
									</div>
									

									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label"> Calificación Estrellas</label>
										<div class="col-lg-9">
											<input class="form-control" type="number" value="<c:out value='${objTour.calificacionEstrellas}'/>"
												name="calificacion_estrellas" placeholder="numero de estrellas min 1 max 5"required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">Complete el campo con números</div>
										</div>
									</div>
									
									 	 
<!-- 										<div class="form-group row"> -->
<!-- 											<label class="col-lg-3 col-form-label form-control-label"> Habilitado o Deshabilitado </label> -->
<!-- 											  <div class="form-check form-check-inline"> -->
												  
<!-- 												  <input class="form-check-input" type="radio" -->
<!-- 												   name="habilitado_o_deshabilitado" id="inlineRadio1" value="habilitado" required> -->
<!-- 												  <label class="form-check-label" for="inlineRadio1">Habilitado</label> -->
												  
<!-- 												  <input class="form-check-input" type="radio"    -->
<!-- 												  name="habilitado_o_deshabilitado" id="inlineRadio2" value="deshabilitado" required>		  -->
<!-- 												  <label class="form-check-label" for="inlineRadio2">Deshabilitado</label> -->
												  
<!-- 												  <div class="valid-feedback">Dato ingresado correctamente</div> -->
<!-- 											    <div class="invalid-feedback">Seleccione un campo</div> -->
<!-- 											</div> -->
<!-- 									   </div> -->
								   
								   
								   <div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Clima Tour</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objTour.climaTour}'/>"
												name="clima_tour" placeholder ="Calido 15-28°C" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">Complete el campo clima</div>
										</div>
									</div>
									
		
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label"></label>
										<div class="col-lg-9">
											<input type="reset" class="btn btn-secondary" value="Cancelar">
											<input type="submit" class="btn btn-primary" value="Guardar" >
											<a href="<%=request.getContextPath()%>/ServletListarTourForGestion" class="btn btn-primary offset-lg-5"><i class="fa fa-undo"></i></a>
										</div>
									</div>
								</form>
							</div>
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
	<script src="js/validaciones.js"></script>
</html>