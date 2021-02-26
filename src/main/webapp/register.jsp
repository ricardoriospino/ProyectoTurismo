<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Register</title>
	
	<!--ini :css -->
	<jsp:include page="importCss.jsp"/>
	<!--fin :css -->
</head>

<c:if test="${error == true}" >
	<div class="alert alert-danger">
  	<strong>Error!</strong> Usuario ya existe.
	</div>
</c:if>	
<c:if test="${ingresado == true}">
	<div class="alert alert-success" role="alert">
		${msg}
	</div>
</c:if>

<body  class="bg-gradient-primary">
	<div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Crear cuenta</h1>
                            </div>
                            <form class="user" role="form" autocomplete="off" action="ServletRegistrarUsuario" method="post" novalidate>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="nombre_personal" id="Nombre" 
                                        placeholder="Nombre" onkeypress="return soloLetras(event)" required>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" name="apellido" id="Apellido"
                                          onkeypress="return soloLetras(event)"   placeholder="Apellido" required>
                                    </div>
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="usuario" id="Usuario" placeholder="Usuario" required>
                                    </div>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" name="clave" id="exampleInputPassword" placeholder="Contraseña" required>
                                    </div>
                                    
                                </div>
                                <input type="submit" class="btn btn-primary btn-user btn-block" value="Crear Cuenta" >
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Olvido su Contraseña?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="<%=request.getContextPath()%>/login.jsp"> Ya tiene una cuenta? Acesso!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--ini:Js -->
	<jsp:include page="importJs.jsp"/>	
	<!--fin:Js -->

</body>
<script src="js/validaciones.js"></script>
</html>