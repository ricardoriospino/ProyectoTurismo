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
	<title>Formulario Usuario</title>
	
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
							<h3 class="mb-0">Ingrese datos Usuario</h3>
						</div>
		
						<c:if test="${ingresado == true}">
							<div class="alert alert-success" role="alert">
								${msg}
							</div>
						</c:if>
		
						<div class="card shadow-lg p-3 mb-5 bg-white">
							<div class="card-header">
								<form class="needs-validation" role="form" autocomplete="off"
									action="ServletInsertUpdateUsuario" method="post" novalidate>
									
									<input type="hidden" name="hdnAccion" value="${btnAccion}"/><!-- es una variable oculta o un comodin -->
									<input type="hidden" name="hdnIdUsuario" value="${idUsuario}"/><!-- es una variable oculta o un comodin -->
		
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Nombre Personal</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objUsuario.nombreUsuario}'/>"
												name="nombre_usuario"  onkeypress="return soloLetras(event)" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el nombre Personal</div>
										</div>
									</div>
		
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Apellido Personal</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objUsuario.apellido}'/>"
												name="apellido"  onkeypress="return soloLetras(event)" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo del Apellido</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Nombre Usuario </label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objUsuario.usuario}'/>"
												name="usuario" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo del Usuario</div>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Clave Usuario</label>
										<div class="col-lg-9">
											<input class="form-control" type="text" value="<c:out value='${objUsuario.clave}'/>"
												name="clave" required>
											<div class="valid-feedback">Dato ingresado correctamente</div>
											<div class="invalid-feedback">complete el campo clave</div>
										</div>
									</div>
									
									
		
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label">Tipo Rol</label>
										<div class="col-lg-9">
											<select class="form-control" name="id_rol" required>
												<c:forEach var="tipoRol" items="${lstRoles}">
													<c:choose>
														<c:when test="${tipoRol.idRol == objUsuario.rol.idRol }">
															<option value="${tipoRol.idRol}" selected="selected">${tipoRol.descripcion}</option>
														</c:when>
														<c:otherwise>
															<option value="${tipoRol.idRol}">${tipoRol.descripcion}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</div>
		
									<div class="form-group row">
										<label class="col-lg-3 col-form-label form-control-label"></label>
										<div class="col-lg-9">
											<input type="reset" class="btn btn-secondary" value="Cancelar">
											<input type="submit" class="btn btn-primary" value="Enviar" >
											<a href="<%=request.getContextPath()%>/ServletListarUsuarioForGestion" class="btn btn-primary offset-lg-5"><i class="fa fa-undo"></i></a>
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