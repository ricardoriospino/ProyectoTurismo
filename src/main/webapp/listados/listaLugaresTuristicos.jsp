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
    
    <title>Lista Lugares Turisticos</title>

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
	        	
	        	<div class="container-fluid ">
					<h3 class="text-center ">Listado de Paquetes Turisticos </h3>
					<hr>			
					<c:if test="${eliminado == true}">
						<div class="alert alert-success" role="alert">
							<strong>Eliminado!</strong> Eliminado Correctamente
						</div>
					</c:if>
					<div id=botonAgregar class="container text-left text-left">
						<a href="<%=request.getContextPath()%>/ServletTour" class="btn btn-success">Agregar Nuevo Paquete Turistico</a>
						<a href="<%=request.getContextPath()%>/ServletListaExportarExcel?p_reporte=REPLISTATOUR0001" class="btn btn-success">Exportar a Excel</a>
					</div>
					<br>
					<table id="tblTour" class="table table-striped table-bordered table-sm "  cellspacing="0" width="100%">
			
						<thead>
							<tr>
								<th>ID </th>
								<th>CODIGO TOUR</th>
								<th>NOMBRE</th>
								<th>PRECIO</th>
								<th>HABILITADO/DESHABILITADO</th>
								<th>EDITAR/ELIMINAR</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="varTour" items="${lstLugaresTuristicos}">
								<tr>
									<td>${varTour.idLugarTuristico}</td>
									<td>${varTour.codigoLugarTuristico}</td>
									<td>${varTour.nombre}</td>
									<td>${varTour.precioXpersona}</td>
									<td>${varTour.habilitadoODeshabilitado}</td>
									<td><a href="<%=request.getContextPath()%>/ServletGestionarLugaresTuristicos?p_accion=editar&idTour=${varTour.idLugarTuristico}">Editar</a>
									&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/ServletGestionarLugaresTuristicos?p_accion=eliminar&idTour=${varTour.idLugarTuristico}">Eliminar</a></td>
								</tr>							
							</c:forEach>
						</tbody>	
					</table>
				</div> 
					<!-- ini: configuracion DataTable -->
					<script type="text/javascript">
						//Basic example
						$(document).ready(function() {
							$('#tblTour').DataTable({
								"paging" : true // activar o desactivar paginacion 			
							});
						});
					</script>     	
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