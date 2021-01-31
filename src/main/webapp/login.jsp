<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
 		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 		
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>
        
         <!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" 
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" 
		crossorigin="anonymous">

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

        <!-- MetisMenu CSS -->
        <link href="css/metisMenu.min.css" rel="stylesheet" type="text/css">

        <!-- Custom CSS -->
        <link href="css/startmin.css" rel="stylesheet" type="text/css">

        <!-- Custom Fonts -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<c:if test="${error == true}" >
	<div class="alert alert-danger">
  	<strong>Error!</strong> Usuario y clave errada.
	</div>
</c:if>	
<body class="login">
	<form  action="ServletLogeoUsuario" method="post">
		<div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Login</h3>
                        </div>
                        <div class="panel-body">
                            
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" type="text" placeholder="usuario" name="usuario"  id="username" autofocus>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" type="password"  placeholder="contraseña" name="clave"  id="password">
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Recuerdeme
                                        </label>
                                    </div>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <input type="submit" name="submit" class="btn btn-lg btn-success btn-block" value="Enviar">
                                </fieldset>
                            
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
	</form>
        <!-- jQuery -->
        <script src="../js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="../js/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="../js/startmin.js"></script>

</body>
</html>