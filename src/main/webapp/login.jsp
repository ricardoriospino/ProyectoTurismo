<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

   	<!--ini :css -->
	<jsp:include page="importCss.jsp"/>
	<!--fin :css -->

</head>
<c:if test="${error == true}" >
	<div class="alert alert-danger">
  	<strong>Error!</strong> Usuario o clave errada.
	</div>
</c:if>	

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenido!</h1>
                                    </div>
                                    <form action="ServletLogeoUsuario?listar=L" method="post">
	                                        <div class="form-group">
	                                        	<input class="form-control" type="text" placeholder="usuario" name="usuario"  id="username" autofocus>
	                                    	</div>
	                                        <div class="form-group">
	                                        	<input class="form-control" type="password"  placeholder="contrase�a" name="clave"  id="password">
	                                    	</div>
	                                        <div class="form-group">
	                                            <div class="custom-control custom-checkbox small">
	                                                <input type="checkbox" class="custom-control-input" id="customCheck">
	                                                <label class="custom-control-label" for="customCheck">Recuerdame</label>
	                                            </div>
	                                        </div>
	                                        
	                                        <div class="btn btn-primary btn-user btn-block">
	                                        	<input type="submit" name="submit" class="btn btn-primary btn-user btn-block" value="Ingresar">
	                                        </div>
	                                         
	                                         
	                                        <hr>
	                                        <a href="#" class="btn btn-google btn-user btn-block">
	                                            <i class="fab fa-google fa-fw"></i> Login with Google
	                                        </a>
	                                        <a href="#" class="btn btn-facebook btn-user btn-block">
	                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
	                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Olvidaste tu contrase�a?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Crear usuario!</a>
                                    </div>
                                </div>
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
</html>