<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ini: Menu dinamico -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar" >

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=request.getContextPath()%>/ServletListarLugaresTuristicos">
                <div class="sidebar-brand-icon">
	                <img src="img/logo.png" class="img-fluid" height="100px" width="100px" >
                </div>
                <div class="sidebar-brand-text mx-2">Menú </div>
            </a>
            
           
            <!-- lista menu-->	
       		<c:forEach var="menu" items="${lstMenu}">
		        <!-- Item Menu-->   
		        <li class="nav-item">
		             <a class="nav-link" href="<%=request.getContextPath()%>${menu.urlMenu}">${menu.menu}</a>            
	                 <!-- Divider -->
            	     <hr class="sidebar-divider d-none d-md-block">          
	            </li>
            </c:forEach>

            <!-- Esconder Menu -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>   
        <!-- fin Menu dinamico  -->