<%@page import="proyectoServicio.demo.jpa.entity.UsuarioJPA"%>

<!-- ini:validamos session -->
<%
boolean valido = false;
UsuarioJPA usuario = (UsuarioJPA)session.getAttribute("usuarioSession");

if(usuario == null)valido = false;
else {valido = true;}

if(!valido){
	response.sendRedirect("login.jsp");
}
%>
<!-- fin:validamos session -->

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

                        <!-- Nav Item - Messages -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link " href="<%=request.getContextPath()%>/ServletDatosVentaPaquete" >
                                <i class="fa fa-shopping-cart fa"></i>
                                
                                <!-- Contador de carrito-->
                                <span class="badge badge-danger badge-counter">${contadorCarrito}</span>
                            </a>    
                        </li>
                        
                        <li class="nav-item dropdown no-arrow">    
                        	<a class="nav-link text-dark  font-weight-bold " aria-haspopup="true" href="register.jsp" role="button">Registrate</a>
                        </li>

                        <!-- Usuario Info -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                 
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=usuario.getNombreUsuario() %></span>
                                <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                            </a>
                            
                            <!-- sub menu usuario -->
                            
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
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/ServletLogout" >
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Cerrar sesión 
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>

        
        