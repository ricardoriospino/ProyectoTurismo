package demo.test.proyecto;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.IncluyeJPA;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.MenuJPA;
import proyectoServicio.demo.jpa.entity.PermisoJPA;
import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.jpa.entity.RolMenuJPA;
import proyectoServicio.demo.jpa.entity.RolPermisoJPA;
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.MenuService;
import proyectoServicio.demo.service.PermisoService;
import proyectoServicio.demo.service.RolService;
import proyectoServicio.demo.service.ServicioService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.MenuServiceImpl;
import proyectoServicio.demo.service.impl.PermisoServiceImpl;
import proyectoServicio.demo.service.impl.RolServiceImpl;
import proyectoServicio.demo.service.impl.ServicioServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;

// ETIQUETA PARA PONER JUNIT ORDENADAMENTE 
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class JunitCreacionJPA {
	
	private static final Logger log= LogManager.getLogger(JunitCreacionJPA.class);

	
	@Test
	
	public void ju1crearRolPermiso() {
		
		log.info("ini : ju1crearRolPermiso()");
		
		try {
			
			RolService rolService = new RolServiceImpl();
			PermisoService permisoService = new PermisoServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			// administrador
			RolJPA administrador = rolService.getRolByDescripcion("Administrador");
			PermisoJPA permisoFullAccess= permisoService.getPermisoById(5);
			RolPermisoJPA rolPermiso1 = new RolPermisoJPA();
			rolPermiso1.setRol(administrador);
			rolPermiso1.setPermiso(permisoFullAccess);
			
			// trabajador
			RolJPA trabajador = rolService.getRolByDescripcion("Trabajador");
			PermisoJPA permisoInsertar= permisoService.getPermisoById(1);
			PermisoJPA permisoConsultar = permisoService.getPermisoById(3);
			
			RolPermisoJPA rolPermiso2 = new RolPermisoJPA();
			rolPermiso2.setRol(trabajador);
			rolPermiso2.setPermiso(permisoInsertar);
			
			RolPermisoJPA rolPermiso3 = new RolPermisoJPA();
			rolPermiso3.setRol(trabajador);
			rolPermiso3.setPermiso(permisoConsultar);
			
			// Usuario
			
			RolJPA usuario = rolService.getRolByDescripcion("Usuario");
			RolPermisoJPA rolPermiso4 = new RolPermisoJPA();
			rolPermiso4.setRol(usuario);
			rolPermiso4.setPermiso(permisoInsertar);
			
			RolPermisoJPA rolPermiso5 = new RolPermisoJPA();
			rolPermiso5.setRol(trabajador);
			rolPermiso5.setPermiso(permisoConsultar);
			
			//invitado
			RolJPA invitado = rolService.getRolByDescripcion("Invitado");
			RolPermisoJPA rolPermiso6 = new RolPermisoJPA();
			rolPermiso6.setRol(invitado);
			rolPermiso6.setPermiso(permisoConsultar);
			
			
			crudService.insertar(rolPermiso1);
			crudService.insertar(rolPermiso2);
			crudService.insertar(rolPermiso3);
			crudService.insertar(rolPermiso4);
			crudService.insertar(rolPermiso5);
			crudService.insertar(rolPermiso6);
			
			Assert.assertTrue(true); // indicamos al JUNIT prueba exitosa 
			
		} catch (Exception e) {
			Assert.assertTrue(false);// indicamos al JUNIT que es prueba erronea
			e.printStackTrace();
		}
		
		
		log.info("fin : ju1crearRolPermiso()");
		
	}
	
	
	@Test
	
	public void ju2crearRolMenu() {
		log.info("ini : ju2crearRolMenu()");
		
		try {
			RolService rolService = new RolServiceImpl();
			MenuService menuService = new MenuServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			// administrador
			RolJPA administrador = rolService.getRolByDescripcion("Administrador");
			
			MenuJPA menuAdministrador1 = menuService.getMenuByCodigo("001");
			RolMenuJPA rolMenuAdmin1 = new RolMenuJPA();
			rolMenuAdmin1.setRol(administrador);
			rolMenuAdmin1.setMenu(menuAdministrador1);
			
			MenuJPA menuAdministrador2 = menuService.getMenuByCodigo("002");
			RolMenuJPA rolMenuAdmin2 = new RolMenuJPA();
			rolMenuAdmin2.setRol(administrador);
			rolMenuAdmin2.setMenu(menuAdministrador2);
			
			MenuJPA menuAdministrador3 = menuService.getMenuByCodigo("003");
			RolMenuJPA rolMenuAdmin3 = new RolMenuJPA();
			rolMenuAdmin3.setRol(administrador);
			rolMenuAdmin3.setMenu(menuAdministrador3);
			
			MenuJPA menuAdministrador4 = menuService.getMenuByCodigo("004");
			RolMenuJPA rolMenuAdmin4 = new RolMenuJPA();
			rolMenuAdmin4.setRol(administrador);
			rolMenuAdmin4.setMenu(menuAdministrador4);
			
			MenuJPA menuAdministrador5 = menuService.getMenuByCodigo("005");
			RolMenuJPA rolMenuAdmin5 = new RolMenuJPA();
			rolMenuAdmin5.setRol(administrador);
			rolMenuAdmin5.setMenu(menuAdministrador5);
			
			MenuJPA menuAdministrador6 = menuService.getMenuByCodigo("006");
			RolMenuJPA rolMenuAdmin6 = new RolMenuJPA();
			rolMenuAdmin6.setRol(administrador);
			rolMenuAdmin6.setMenu(menuAdministrador6);
			
			// trabajador 
			
			RolJPA trabajador = rolService.getRolByDescripcion("Trabajador");
			MenuJPA menuTrabajador1 = menuService.getMenuByCodigo("004");
			RolMenuJPA rolMenuTrab1 = new RolMenuJPA();
			rolMenuTrab1.setRol(trabajador);
			rolMenuTrab1.setMenu(menuTrabajador1);
			
			MenuJPA menuTrabajador2 = menuService.getMenuByCodigo("006");
			RolMenuJPA rolMenuTrab2 = new RolMenuJPA();
			rolMenuTrab2.setRol(trabajador);
			rolMenuTrab2.setMenu(menuTrabajador2);
			
			
			// Usuario 
			
			RolJPA usuario = rolService.getRolByDescripcion("Usuario");
			MenuJPA menuUsuario1 = menuService.getMenuByCodigo("004");
			RolMenuJPA rolMenuUsu1 = new RolMenuJPA();
			rolMenuUsu1.setRol(usuario);
			rolMenuUsu1.setMenu(menuUsuario1);
			
			MenuJPA menuUsuario2 = menuService.getMenuByCodigo("005");
			RolMenuJPA rolMenuUsu2 = new RolMenuJPA();
			rolMenuUsu2.setRol(usuario);
			rolMenuUsu2.setMenu(menuUsuario2);
			
			// invitado 
			
			RolJPA invitado = rolService.getRolByDescripcion("Invitado");
			MenuJPA menuInvitado1 = menuService.getMenuByCodigo("004");
			RolMenuJPA rolMenuInvi1 = new RolMenuJPA();
			rolMenuInvi1.setRol(invitado);
			rolMenuInvi1.setMenu(menuInvitado1);
			
			
			crudService.insertar(rolMenuAdmin1);
			crudService.insertar(rolMenuAdmin2);
			crudService.insertar(rolMenuAdmin3);
			crudService.insertar(rolMenuAdmin4);
			crudService.insertar(rolMenuAdmin5);
			crudService.insertar(rolMenuAdmin6);
			
			crudService.insertar(rolMenuTrab1);
			crudService.insertar(rolMenuTrab2);
			
			crudService.insertar(rolMenuUsu1);
			crudService.insertar(rolMenuUsu2);
			
			crudService.insertar(rolMenuInvi1);
		
			
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}
			
		log.info("fin : ju2crearRolMenu()");	
	}
	
	
	
	@Test
	
	public void ju3crearIncluye() {
		log.info("ini : ju3crearIncluye()");
		
		try {
			LugarTuristicoService lugaresTuristicoService = new LugarTuristicoServiceImpl();
			ServicioService servicioService = new ServicioServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			// tour Machu Picchu
			LugarTuristicoJPA tour1 = lugaresTuristicoService.getLugarTuristicoByNombre("Machu Picchu");
			ServicioJPA servicio1 = servicioService.getServicioByTipoServicio("Entradas turisticas");
			IncluyeJPA tourIncluye1 = new IncluyeJPA();
			tourIncluye1.setCosto(80.50);
			tourIncluye1.setLugarTuristico(tour1);
			tourIncluye1.setServicio(servicio1);
			
			ServicioJPA servicio2 = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA tourIncluye2 = new IncluyeJPA();
			tourIncluye2.setCosto(30.00);
			tourIncluye2.setLugarTuristico(tour1);
			tourIncluye2.setServicio(servicio2);
			
			ServicioJPA servicio3 = servicioService.getServicioByTipoServicio("Transporte");
			IncluyeJPA tourIncluye3 = new IncluyeJPA();
			tourIncluye3.setCosto(140.00);
			tourIncluye3.setLugarTuristico(tour1);
			tourIncluye3.setServicio(servicio3);
			
			// tour Nevado Huscaran
			
			LugarTuristicoJPA tour2 = lugaresTuristicoService.getLugarTuristicoByNombre("Nevado Huscaran");
			ServicioJPA servicio4 = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA tourIncluye4 = new IncluyeJPA();
			tourIncluye4.setCosto(100.00);
			tourIncluye4.setLugarTuristico(tour2);
			tourIncluye4.setServicio(servicio4);
			
			
			ServicioJPA servicio5 = servicioService.getServicioByTipoServicio("Desayuno");
			IncluyeJPA tourIncluye5 = new IncluyeJPA();
			tourIncluye5.setCosto(50.00);
			tourIncluye5.setLugarTuristico(tour2);
			tourIncluye5.setServicio(servicio5);
			
			
			// tour Paracas
			
			LugarTuristicoJPA tour3 = lugaresTuristicoService.getLugarTuristicoByNombre("Paracas");
			ServicioJPA servicio6 = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA tourIncluye6 = new IncluyeJPA();
			tourIncluye6.setCosto(50.00);
			tourIncluye6.setLugarTuristico(tour3);
			tourIncluye6.setServicio(servicio6);
			
			ServicioJPA servicio7 = servicioService.getServicioByTipoServicio("Transporte");
			IncluyeJPA tourIncluye7 = new IncluyeJPA();
			tourIncluye7.setCosto(60.00);
			tourIncluye7.setLugarTuristico(tour3);
			tourIncluye7.setServicio(servicio7);
			
			//tour Punta sal 
			LugarTuristicoJPA tour4 = lugaresTuristicoService.getLugarTuristicoByNombre("Punta sal");
			ServicioJPA servicio8 = servicioService.getServicioByTipoServicio("Desayuno");
			IncluyeJPA tourIncluye8 = new IncluyeJPA();
			tourIncluye8.setCosto(60.00);
			tourIncluye8.setLugarTuristico(tour4);
			tourIncluye8.setServicio(servicio8);
			
			ServicioJPA servicio9 = servicioService.getServicioByTipoServicio("Almuerzo");
			IncluyeJPA tourIncluye9 = new IncluyeJPA();
			tourIncluye9.setCosto(60.00);
			tourIncluye9.setLugarTuristico(tour4);
			tourIncluye9.setServicio(servicio9);
			
			ServicioJPA servicio10 = servicioService.getServicioByTipoServicio("Cena");
			IncluyeJPA tourIncluye10 = new IncluyeJPA();
			tourIncluye10.setCosto(60.00);
			tourIncluye10.setLugarTuristico(tour4);
			tourIncluye10.setServicio(servicio10);
			
			ServicioJPA servicio11 = servicioService.getServicioByTipoServicio("Transporte");
			IncluyeJPA tourIncluye11 = new IncluyeJPA();
			tourIncluye11.setCosto(20.50);
			tourIncluye11.setLugarTuristico(tour4);
			tourIncluye11.setServicio(servicio11);
			
			// tour Pozuzo
			LugarTuristicoJPA tour5 = lugaresTuristicoService.getLugarTuristicoByNombre("Pozuzo");
			ServicioJPA servicio12 = servicioService.getServicioByTipoServicio("Transporte");
			IncluyeJPA tourIncluye12 = new IncluyeJPA();
			tourIncluye12.setCosto(50.90);
			tourIncluye12.setLugarTuristico(tour5);
			tourIncluye12.setServicio(servicio12);
			
		
			ServicioJPA servicio13 = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA tourIncluye13 = new IncluyeJPA();
			tourIncluye13.setCosto(40.00);
			tourIncluye13.setLugarTuristico(tour5);
			tourIncluye13.setServicio(servicio13);
			
			
			// tour Kuelap
			
			LugarTuristicoJPA tour6 = lugaresTuristicoService.getLugarTuristicoByNombre("kuelap");
			ServicioJPA servicio14 = servicioService.getServicioByTipoServicio("Transporte");
			IncluyeJPA tourIncluye14 = new IncluyeJPA();
			tourIncluye14.setCosto(200.00);
			tourIncluye14.setLugarTuristico(tour6);
			tourIncluye14.setServicio(servicio14);
			
		
			ServicioJPA servicio15 = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA tourIncluye15 = new IncluyeJPA();
			tourIncluye15.setCosto(70.00);
			tourIncluye15.setLugarTuristico(tour6);
			tourIncluye15.setServicio(servicio15);
			
			crudService.insertar(tourIncluye1);
			crudService.insertar(tourIncluye2);
			crudService.insertar(tourIncluye3);
			crudService.insertar(tourIncluye4);
			crudService.insertar(tourIncluye5);
			crudService.insertar(tourIncluye6);
			crudService.insertar(tourIncluye7);
			crudService.insertar(tourIncluye8);
			crudService.insertar(tourIncluye9);
			crudService.insertar(tourIncluye10);
			crudService.insertar(tourIncluye11);
			crudService.insertar(tourIncluye12);
			crudService.insertar(tourIncluye13);
			crudService.insertar(tourIncluye14);
			crudService.insertar(tourIncluye15);
			
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}
		
		
		log.info("fin : ju3crearIncluye()");
		
	}
	
	@Test
	
	public void ju4crearUsuario() {
		log.info("ini : ju4crearUsuario()");
		
		try {
			
			RolService rolService = new RolServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			RolJPA rolAdministrador = rolService.getRolByDescripcion("Administrador");
			UsuarioJPA usuarioAdministrador = new UsuarioJPA();
			usuarioAdministrador.setNombreUsuario("Ricardo");
			usuarioAdministrador.setApellido("Rios");
			usuarioAdministrador.setUsuario("ricardo123");
			usuarioAdministrador.setClave("123");
			usuarioAdministrador.setRol(rolAdministrador);
			
			RolJPA rolTrabajador = rolService.getRolById(2);
			UsuarioJPA usuarioTrabajador = new UsuarioJPA();
			usuarioTrabajador.setNombreUsuario("Richard");
			usuarioTrabajador.setApellido("Swing");
			usuarioTrabajador.setUsuario("richar123");
			usuarioTrabajador.setClave("123");
			usuarioTrabajador.setRol(rolTrabajador);
			
			RolJPA rolUsuario = rolService.getRolById(3);
			UsuarioJPA usuario1 = new UsuarioJPA();
			usuario1.setNombreUsuario("Manuel");
			usuario1.setApellido("Burga");
			usuario1.setUsuario("manuel123");
			usuario1.setClave("123");
			usuario1.setRol(rolUsuario);
			
			
			crudService.insertar(usuarioAdministrador);
			crudService.insertar(usuarioTrabajador);
			crudService.insertar(usuario1);
			
			
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}
		
		
		log.info("fin : ju4crearUsuario()");
		
	}
	
	@Test
	
	public void ju5crearCompra() {
		log.info("ini : ju5crearCompra()");
		
		try {
			Date fechaCompra =  new Date();
			
			LugarTuristicoService lugaresTuristicoService = new LugarTuristicoServiceImpl();
			UsuarioService usuarioService = new UsuarioServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			LugarTuristicoJPA huascaran = lugaresTuristicoService.getLugarTuristicoByNombre("Nevado Huscaran");
			UsuarioJPA usuario1 = usuarioService.getUsuarioById(3);
			CompraJPA compra1 = new CompraJPA();
			compra1.setCantidadPersonas(1);
			compra1.setSubTotal(170.50);
			compra1.setFechaCompra(fechaCompra);
			compra1.setFechaViaje(fechaCompra);
			compra1.setUsuario(usuario1);
			compra1.setLugarTuristico(huascaran);
			
			crudService.insertar(compra1);
			
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
		}
		
		log.info("fin : ju5crearCompra()");
		
	}
}
