package demo.test.proyecto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

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

public class JunitCreacionJPA {
	
	private static final Logger log= LogManager.getLogger(JunitCreacionJPA.class);

	
	@Test
	public void ju7crearRolPermiso() {
		
		log.info("ini : ju7crearRolPermiso()");
		
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
		
		
		log.info("fin : ju7crearRolPermiso()");
		
	}
	
	
	@Test
	public void ju6crearRolMenu() {
		log.info("ini : ju6crearRolMenu()");
		
		try {
			RolService rolService = new RolServiceImpl();
			MenuService menuService = new MenuServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			RolJPA administrador = rolService.getRolByDescripcion("Administrador");
			MenuJPA menuAdministrador = menuService.getMenuById(1);
			RolMenuJPA rolMenu1 = new RolMenuJPA();
			rolMenu1.setRol(administrador);
			rolMenu1.setMenu(menuAdministrador);
			
			RolJPA trabajador = rolService.getRolByDescripcion("Trabajador");
			MenuJPA menuTrabajador = menuService.getMenuById(2);
			RolMenuJPA rolMenu2 = new RolMenuJPA();
			rolMenu2.setRol(trabajador);
			rolMenu2.setMenu(menuTrabajador);
			
			RolJPA usuario = rolService.getRolByDescripcion("Usuario");
			MenuJPA menuUsuario = menuService.getMenuById(3);
			RolMenuJPA rolMenu3 = new RolMenuJPA();
			rolMenu3.setRol(usuario);
			rolMenu3.setMenu(menuUsuario);
			
			crudService.insertar(rolMenu1);
			crudService.insertar(rolMenu2);
			crudService.insertar(rolMenu3);
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}
			
		log.info("fin : ju6crearRolMenu()");	
	}
	
	
	
	@Test
	public void ju8crearIncluye() {
		log.info("ini : ju8crearIncluye()");
		
		try {
			LugarTuristicoService lugaresTuristicoService = new LugarTuristicoServiceImpl();
			ServicioService servicioService = new ServicioServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			LugarTuristicoJPA tour1 = lugaresTuristicoService.getLugarTuristicoByNombre("Machu Picchu");
			ServicioJPA Boleto = servicioService.getServicioByTipoServicio("Entradas turisticas");
			IncluyeJPA incluyeBoleto = new IncluyeJPA();
			incluyeBoleto.setCosto(10.50);
			incluyeBoleto.setLugarTuristico(tour1);
			incluyeBoleto.setServicio(Boleto);
			
			LugarTuristicoJPA tour2 = lugaresTuristicoService.getLugarTuristicoByNombre("Nevado Huscaran");
			ServicioJPA guia = servicioService.getServicioByTipoServicio("Guia");
			IncluyeJPA incluyeGuia = new IncluyeJPA();
			incluyeGuia.setCosto(15.30);
			incluyeGuia.setLugarTuristico(tour2);
			incluyeGuia.setServicio(guia);
			
			LugarTuristicoJPA tour3 = lugaresTuristicoService.getLugarTuristicoByNombre("Punta sal");
			ServicioJPA desayuno = servicioService.getServicioByTipoServicio("Desayuno");
			IncluyeJPA incluyeDesayuno = new IncluyeJPA();
			incluyeDesayuno.setCosto(4.50);
			incluyeDesayuno.setLugarTuristico(tour3);
			incluyeDesayuno.setServicio(desayuno);
			
			crudService.insertar(incluyeBoleto);
			crudService.insertar(incluyeGuia);
			crudService.insertar(incluyeDesayuno);
			
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
			
		}
		
		
		log.info("fin : ju8crearIncluye()");
		
	}
	
	@Test
	public void ju9crearUsuario() {
		log.info("ini : ju9crearUsuario()");
		
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
		
		
		log.info("fin : ju9crearUsuario()");
		
	}
	
	@Test
	public void ju10crearCompra() {
		log.info("ini : ju10crearCompra()");
		
		try {
			
			LugarTuristicoService lugaresTuristicoService = new LugarTuristicoServiceImpl();
			UsuarioService usuarioService = new UsuarioServiceImpl();
			CRUDService crudService = new CRUDServiceImpl();
			
			LugarTuristicoJPA huascaran = lugaresTuristicoService.getLugarTuristicoByNombre("Nevado Huscaran");
			UsuarioJPA usuario1 = usuarioService.getUsuarioById(3);
			CompraJPA compra1 = new CompraJPA();
			compra1.setCantidadPersonas(1);
			compra1.setMontoTotal(170.50);
			compra1.setUsuario(usuario1);
			compra1.setLugarTuristico(huascaran);
			
			crudService.insertar(compra1);
			
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.printStackTrace();
		}
		
		log.info("fin : ju10crearCompra()");
		
	}
}
