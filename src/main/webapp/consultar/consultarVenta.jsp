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
    
	<title>Consultar Venta</title>
	<!-- importar libreria a la clase -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
	crossorigin="anonymous">
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">

	<!--ini :css -->
	<jsp:include page="../importCss.jsp"/>
	<!--fin :css -->
	
	<!-- ini:calendar -->
	<jsp:include page="../calendar.jsp" />
	<!-- fin:calendar -->
	
	<!-- ini:dataTable -->
<%-- 	<jsp:include page="../dataTableTienda.jsp" /> --%>
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
	        		<h3 class="text-center ">Consulta de ventas </h3>
						<hr>
						<c:if test="${info == true}">
								<div class="alert alert-warning" role="alert">
									${msg}
								</div>
						</c:if>
	        		<div class="container-fluid  border-left-primary">
		        		<span class="anchor" id="formUserEdit"></span>
		        		
		        		<div class="card card-outline-secondary">
							<div class="card-header">
								<h5 class="mb-0">Seleccionar ventas: </h5>
								<br>
								
								<form autocomplete="off" action="ServletConsultarVentas"  method="post" novalidate >
									<div class="form-group row">
										<div class="col-md-4 mb-4">
											<label for="validationDefault01">Paquete Turistico :</label> 
											<select class="form-control" name="codigo_paquete" >
														<option value="TDP"  selected="">Todos Los paquetes</option>
												<c:forEach var="nombrePaquete" items="${lstNombrePaquete}"> 	
												 		<option value="${nombrePaquete.codigoLugarTuristico }">${nombrePaquete.nombre}</option>					
												</c:forEach>
											</select>
										</div>
										<div class="col-md-6 mb-4">
											<a href="<%=request.getContextPath()%>/" class="btn btn-primary offset-lg-6">Exportar a Excel  </a>
										</div>
									</div>
									<div class="form-group row" >
										<div class="col-md-6 mb-4">
											<label for="validationDefault02">Fecha Inicio :</label> 
											<input class="form-control" id="datepickerIni" width="276" 
												name="fecha_inicio" value=""  >
	
											<script>
							                  $('#datepickerIni').datepicker({
							                    datepicker: true,
							                    uiLibrary : 'bootstrap4',
							                    locale: 'es-es',
							                    format:'yyyy-mm-dd'
							                  });
									  		</script>
										</div>
										
										<div class="col-md-6 mb-4">
											<label for="validationDefault02">Fecha Fin :</label>
											<input class="form-control" id="datepickerFin" width="276" 
												name="fecha_fin" value=""  >
											
											<script>
							                  $('#datepickerFin').datepicker({
							                    datepicker: true,
							                    uiLibrary : 'bootstrap4',
							                    locale: 'es-es',
							                    format:'yyyy-mm-dd'
							                  });
									  		</script>
										</div>
									</div>	
									<div id=botonSiguiente class="container col-md-5 ">	
										<input type="reset" class="btn btn-secondary" value="cancelar">
										
										<input type="submit" class="btn btn-primary" value="Consultar" >
										
									</div>				
								</form>				
							</div>				
						</div> 
		        	</div> 
		        	<br>
		        	
		        	<c:if test="${not empty lstVentas}">
		        	<div class="container-fluid  border-left-primary ">
		        		<div class="card card-outline-secondary">	
		        			<br>
							<h5 class="text-center">Lista de Paquetes Vendidos</h5>
							<br>
							<table   id="tblVentas" class="table table-striped table-bordered table-sm "  cellspacing="0" width="100%">
				
							<thead>
								<tr>
									<th>CODIGO TOUR </th>
									<th>NOMBRE TOUR</th>
									<th>USUARIO</th>
									<th>NOMBRE CLIENTE</th>	
									<th>FECHA SALIDA</th>
									<th>SUB TOTAL</th>		
								</tr>
							</thead>
							<tbody>
								<c:forEach var="varVenta" items="${lstVentas}">
									<tr>
										<td>${varVenta.codigoTour}</td>
										<td>${varVenta.nombreTour}</td>
										<td>${varVenta.usuario}</td>
										<td>${varVenta.nombreUsuario}</td>
										<td>${varVenta.fechaSalida}</td>
										<td>${varVenta.subTotal}</td>
										
									</tr>							
								</c:forEach>
							</tbody>	
							</table>
		        		</div>	
		        		<br><br>
		        		<script type="text/javascript">
							//Basic example
							$(document).ready(function() {
								$('#tblVentas').DataTable({
									"paging" : true ,// activar o desactivar paginacion 	
									"pageLength": 5,
									"columnDefs": [
									       {"className": "dt-center", "targets": "_all"}
								]
								});
							});
						</script>  
		        	</div>
		        </c:if>
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
		<jsp:include page="../importJs.jsp"/>	
		<!--fin:Js --> 	
		
		<script src = "http://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js" defer ></script>

</html>