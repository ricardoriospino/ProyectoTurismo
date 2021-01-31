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

    <title>Proyecto Servicio Turistico</title>
    
    <!-- IMPORTANDO LIBRERIA JSTL CORE, FMT  -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    
    
    
 <style type="text/css">
 
 #carouselExampleSlidesOnly {
 		max-width: 100%;
        max-height: 100%;
        display: block;

 }
 
 #imagen1 , #imagen2 , #imagen3 {
	 background-color: rgba(0,0,0,0.8);
	filter:brightness(0.4);
 }

 </style>
    
</head>
<body id="page-top">
<!-- ini:validamos session -->
<%
// boolean valido = false;
// UsuarioJPA usuario = (UsuarioJPA)session.getAttribute("usuarioSession");

// if(usuario == null)valido = false;
// else {valido = true;}

// if(!valido){
// 	response.sendRedirect("login.jsp");
// }
%>
<!-- fin:validamos session -->
	<!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Proyecto Turismo </div>
            </a>
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
       		
       		<c:forEach var="menu" items="${lstMenu}">
       		
       		
			
	            <!-- Nav Item - Dashboard -->
	            
	            <li class="nav-item">
	                <a class="nav-link" href="index.html" >
	                    
	                    ${menu.descripcion}</a>
	            </li>
	
	         
	            <!-- Nav Item - Pages Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" >
	                          
	                ${menu.descripcion} </a>
	            </li>
	
	            <!-- Nav Item - Utilities Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" >
          
	                 ${menu.descripcion}</a>
	            </li>
	
	            
	            <!-- Nav Item - Pages Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" >
	                    
	                     ${menu.descripcion} </a>
	            </li>
	
	            <!-- Nav Item - Charts -->
	            <li class="nav-item">
	                <a class="nav-link" href="#">
	                    
	                     ${menu.descripcion}</a>
	            </li>
	
	            <!-- Nav Item - Tables -->
	            <li class="nav-item">
	                <a class="nav-link" href="#">
	                    
	                     ${menu.descripcion}</a>
	            </li>
            
            
            </c:forEach>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

           

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul id=topbar class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - Alerts -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                <!-- Counter - Alerts -->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                            <!-- Dropdown - Alerts -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                <!-- Counter - Messages -->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun · 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>
                    </ul>

                </nav>
                <!-- End of Topbar -->
                

                <!-- Begin Page Content -->
                <div >
                 <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel"  >
                 
  					<div class="carousel-inner" >
  					
	    				<div class="carousel-item active" >
	    				
	      					<img id="imagen1" class="d-block w-100" src="https://cutt.ly/FjlvC4P" alt="First slide" width="250" height="300" >
	    				</div>
					    <div class="carousel-item">
					      <img id="imagen2" class="d-block w-100" src="https://cutt.ly/7jlbw1c" alt="Second slide" width="250" height="300 " >
					    </div>
					    <div class="carousel-item">
					      <img  id="imagen3"class="d-block w-100" src="https://cutt.ly/MjkrzUq" alt="Third slide" width="250" height="300" >
					    </div>
					    <br><br><br>
					    <div  id ="overlay" class="overlay" >
            			<div class="d-flex justify-content-center align-items-center h-100">
              				<div class="row align-items-center h-100">
              				
                				<div class="col-md-12 offset-md-2 text-center text-md-center">
                					<div class="text-white">
	                 		 			<h1 class="mb-3">Disfruta lo mejor del Perú</h1>
	                 		 			<h4 class="mb-3">Los Mejores Precios estan aqui!!</h4>
	                  					<a class="btn btn-outline-light btn-lg" href="#!" role="button">Comprar Ya!</a >
                  					</div>
                    
                				</div>
              				</div>
            			</div>
          			</div>
  					</div>
 
				</div>          
      			</div>
			      
			    
			    <main class="mt-5">
			      <div class="container">
			        <!-- Navbar -->
			        <nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
			          <!-- Container wrapper -->
			          <div class="container-fluid">
			            <!-- Navbar brand -->
			            <a class="navbar-brand" href="#">Logo</a>
			
			            <!-- Toggle button -->
			            <button
			              class="navbar-toggler"
			              type="button"
			              data-mdb-toggle="collapse"
			              data-mdb-target="#navbarSupportedContent"
			              aria-controls="navbarSupportedContent"
			              aria-expanded="false"
			              aria-label="Toggle navigation"
			            >
			              <i class="fas fa-bars"></i>
			            </button>
			
			            <!-- Collapsible wrapper -->
			            <div class="collapse navbar-collapse" id="navbarSupportedContent">
			              <!-- Left links -->
			              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			                <li class="nav-item">
			                  <a class="nav-link active" aria-current="page" href="#"
			                    >Lugares</a
			                  >
			                </li>
			                <!-- Navbar dropdown -->
			                <li class="nav-item dropdown">
			                  <a
			                    class="nav-link dropdown-toggle"
			                    href="#"
			                    id="navbarDropdown"
			                    role="button"
			                    data-mdb-toggle="dropdown"
			                    aria-expanded="false"
			                  >
			                    Servicios
			                  </a>
			                  <!-- Dropdown menu -->
			                  <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			                    <li>
			                      <a class="dropdown-item" href="#">Boletos Incluidos</a>
			                    </li>
			                    <li>
			                      <a class="dropdown-item" href="#">Guia Tutistico</a>
			                    </li>
			                    <li><hr class="dropdown-divider" /></li>
			                    <li>
			                      <a class="dropdown-item" href="#">Servicios de Comida</a>
			                    </li>
			                  </ul>
			                </li>
			                <li class="nav-item">
			                  <a
			                    class="nav-link"
			                    href="#"
			                    tabindex="-1"
			                    aria-disabled="true"
			                    >Ofertas Exclusivas</a
			                  >
			                </li>
			              </ul>
			              <!-- Left links -->
			
			              <!-- Search form -->
			              <form class="d-flex input-group w-auto">
			                <input
			                  type="search"
			                  class="form-control"
			                  placeholder="Buscar"
			                  aria-label="Search"
			                />
			                <button
			                  class="btn btn-outline-primary"
			                  type="button"
			                  data-mdb-ripple-color="dark"
			                >
			                  Buscar
			                </button>
			              </form>
			            </div>
			            <!-- Collapsible wrapper -->
			          </div>
			          <!-- Container wrapper -->
			        </nav>
			        <!-- Catalogo de Viajes-->
			        <section class="text-center mb-4">
			          <div class="row">
			          
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/hjkeSwO" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">Machu Picchu</h5>
			                  <h6>S/. 250.50</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			            
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/MjkrzUq" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">Nevado Huscaran</h5>
			                  <h6>S/. 150.00</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/djkrXAc" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">Paracas</h5>
			                  <h6>S/. 110.00</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/FjlvC4P" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">Punta sal</h5>
			                  <h6>S/. 200.50</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/bjAHmxL" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">Pozuzo</h5>
			                  <h6>S/. 95.90</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			            <div class="col-lg-4 col-md-12 mb-4">
			              <div class="card">
			                <div
			                  class="bg-image hover-overlay ripple"
			                  data-mdb-ripple-color="light"
			                >
			                  <img src="https://cutt.ly/7jlbw1c" class="img-fluid" />
			                  <a href="#!">
			                    <div
			                      class="mask"
			                      style="background-color: rgba(251, 251, 251, 0.15)"
			                    ></div>
			                  </a>
			                </div>
			                <div class="card-body">
			                  <h5 class="card-title">kuelap</h5>
			                  <h6>S/. 270.00</h6>
			                  <p class="card-text">
			                    Some quick example text to build on the card title and make
			                    up the bulk of the card's content.
			                  </p>
			                  <a href="#!" class="btn btn-primary">Comprar</a>
			                </div>
			              </div>
			            </div>
			          </div>
			        </section>
			        <!-- Catalogo de Viajes-->
			        <!-- Navbar -->
			      </div>
			    </main>
                
                
                <!-- end Page Content -->

            </div>
            <!-- End of Main Content -->

            <!--ini :footer -->
			<jsp:include page="pages/footer.jsp"/>
			<!--fin :footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

	

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>
</html>