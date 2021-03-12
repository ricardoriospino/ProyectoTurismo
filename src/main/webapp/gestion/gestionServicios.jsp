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
	<title>Gestionar Servicio de Paquete Turistico</title>
	
	<!-- importar libreria a la clase -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
	crossorigin="anonymous">
	
	<!--ini :css -->
	<jsp:include page="../importCss.jsp"/>
	<!--fin :css -->
	
	<!-- ini:dataTable -->
	<jsp:include page="../dataTableTienda.jsp" />
	<!-- fin:dataTable -->
	
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
	<div id="wrapper">
		
		<!-- ini: Menu dinamico -->
		<jsp:include page="../menuPrincipal.jsp"/>
        <!-- fin Menu dinamico  -->
        
        <div id="content-wrapper" class="d-flex flex-column">
        
        	<div id="content">
        		<!-- ini: Navbar principal -->
	            <jsp:include page="../navbarPrincipal.jsp"/>
	        	<!-- fin:navbar principal -->
	        	
	        	<div class="col-md-12 ">
					<span class="anchor" id="formUserEdit"></span>
	        	
		        	<div class="container-fluid  border-left-primary ">
						<h3 class="text-center ">Gestión Servicio de Paquete Turistico </h3>
						<hr>
						
						<c:if test="${ingresado == true}">
								<div class="alert alert-success" role="alert">
									${msg}
								</div>
						</c:if>
						<table id="tblTour" class="table table-striped table-bordered table-sm "  cellspacing="0" width="100%">
				
							<thead>
								<tr>
									<th>ID </th>
									<th>CODIGO TOUR</th>
									<th>NOMBRE</th>
									<th>SELECCIONAR</th>	
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="varTour" items="${lstLugaresTuristicos}">
									<tr>
										<td>${varTour.idLugarTuristico}</td>
										<td>${varTour.codigoLugarTuristico}</td>
										<td>${varTour.nombre}</td>
										<td><a href="<%=request.getContextPath()%>/ServletGestionServicios?p_accion=seleccionar&idTour=${varTour.idLugarTuristico}"> 
											<button type="button" class="btn btn-dataTable "><i class="fa fa-check-square"></i></button></a>
										</td>
									</tr>							
								</c:forEach>
							</tbody>	
						</table>
					</div> 
					<br><br>
		        	<div class="container-fluid  border-left-primary">
		        		<span class="anchor" id="formUserEdit"></span>
		        		
		        		<div class="card card-outline-secondary">
							<div class="card-header">
								<h5 class="mb-0">Datos seleccionados Paquete Turistico</h5>
								<form>
									<div class="form-row">
										<div class="col-md-2 mb-3">
											<label for="validationDefault01">id Tour</label> <input
												type="text" class="form-control" id="validationDefault01"
												 disabled="disabled" value="${tourSeleccionado.idLugarTuristico}" required>
										</div>
										<div class="col-md-2 mb-3">
											<label for="validationDefault02">Codigo Tour</label> <input
												type="text" class="form-control" id="validationDefault02"
												 disabled="disabled" value="${tourSeleccionado.codigoLugarTuristico}" required>
										</div>
										<div class="col-md-5 mb-3">
											<label for="validationDefault02">Nombre Paquete Tour</label> <input
												type="text" class="form-control" id="validationDefault02"
												 disabled="disabled" value="${tourSeleccionado.nombre}" required>
										</div>
										<div class="col-md-3 mb-3">
											<label for="validationDefault02">Precio S/.</label> <input
												type="text" class="form-control" id="validationDefault02"
												 disabled="disabled"   value= "${tourSeleccionado.precioXpersona}" required>
										</div>
									</div>					
								</form>				
							</div>				
						</div> 
		        	</div> 	
	        		<br>
		        	<div class="container-fluid  border-left-primary ">
		        		
		        		<div class="card card-outline-secondary">
		        		
		        			<form  autocomplete="off"
									action="ServletGestionServicios" method="post" novalidate>
									
								<c:if test="${not empty lstServicios}">
									<div class="card-header">
										<h5 class="mb-0">Servicios Incluidos Paquete Turistico</h5>
										<br>
											
												<%int contador=0;%>
												
													<c:forEach var="lstServicios" items="${lstServicios}">
													<%++contador;%>
													<div class="container">
														<div class="row ">
															<div class="col-md-4">
														        <div class="form-check checkbox-xl">
																  <input class="top-checkbox"  type="checkbox" id="idCheck<%=contador%>" value="<c:out value='${lstServicios.idServicio}'/>" name="chkServicio" /> 
																  <label class="form-check-label" for="flexCheckDefault"> ${lstServicios.nombreServicio} </label>
																</div>
															</div>
	
																<div class="col-md-4 offset-md-1 form-inline">
																	<div class="input-group mb-3">
																		<div class="input-group-prepend">
																			 <span class="input-group-text">Costo S/.</span>
																		</div>
																		<input type="text" id="cajaCosto<%=contador%>" class="form-control"   name="costoServicio"  disabled="disabled" value="<c:out value='${lstServicios.costo}'/>" >
							
																		
																	</div>		
															    </div>
															    <script type="text/javascript" >
															    
															    var costo=document.getElementById("cajaCosto<%=contador%>").value; 
															    // no check
														        if(costo==""){
														        	 document.getElementById("idCheck<%=contador%>").checked=false;
														        	 document.getElementById("cajaCosto<%=contador%>").disabled = true;
														        	 // check
														        }else{
														        	// marcas check
														        	 document.getElementById("idCheck<%=contador%>").checked=true;
														        	// habilitar
														        	 document.getElementById("cajaCosto<%=contador%>").disabled = false;
														        }
																	// check y no check
																document.getElementById("idCheck<%=contador%>").onchange = function() {
																    document.getElementById("cajaCosto<%=contador%>").disabled = !this.checked;
																    document.getElementById("cajaCosto<%=contador%>").value = "";
																};
																
																</script>
														</div>
													</div>	
										
											        </c:forEach>
											     
										        <br>
												<div id=botonSiguiente class="container col-md-5 ">	
													<input type="reset" class="btn btn-secondary" value="cancelar">
													<input type="submit" class="btn btn-primary" value="Guardar" >
												</div>
												<br><br><br>
											
				        			</div>
			        			</c:if>
		        			</form>
		        		</div>
		        	</div>
        		</div>
	        	<br><br>
	        		<!--ini :footer -->
					<jsp:include page="../pages/footer.jsp"/>
					<!--fin :footer -->
			</div>
		</div>
	</div>
		<!--ini:Js -->
		<jsp:include page="../importJs.jsp"/>	
		<!--fin:Js --> 	
	
</body>
<script type="text/javascript">
	//Basic example
	$(document).ready(function() {
		$('#tblTour').DataTable({
			"paging" : true, // activar o desactivar paginacion 
			"pageLength": 5,
			"columnDefs": [
			       {"className": "dt-center", "targets": "_all"}
		]
			    
		});
	});

</script> 

</html>

				    	