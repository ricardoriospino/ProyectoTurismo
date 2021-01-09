package demo.test.proyecto;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.dao.impl.CrudDAOImpl;
import proyectoServicio.demo.dao.impl.LugarTuristicoDAOImpl;
import proyectoServicio.demo.dao.impl.MenuDAOImpl;
import proyectoServicio.demo.dao.impl.PermisoDAOImpl;
import proyectoServicio.demo.dao.impl.RolDAOImpl;
import proyectoServicio.demo.dao.impl.ServicioDAOImpl;
import proyectoServicio.demo.dao.impl.UsuarioDAOImpl;
import proyectoServicio.demo.dao.turismo.CrudDAO;
import proyectoServicio.demo.dao.turismo.LugarTuristicoDAO;
import proyectoServicio.demo.dao.turismo.MenuDAO;
import proyectoServicio.demo.dao.turismo.PermisoDAO;
import proyectoServicio.demo.dao.turismo.RolDAO;
import proyectoServicio.demo.dao.turismo.ServicioDAO;
import proyectoServicio.demo.dao.turismo.UsuarioDAO;
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





public class TestUnitarioCreaciondeJpa {
	
	private static final Logger log= LogManager.getLogger(TestUnitarioCreaciondeJpa.class);
	
	public static void main(String[] args) {
		
		try {
			//crearLugarTuristico();
			//crearServicio();
			//crearPermiso();
			//crearMenu();
			//crearRol();
			//crearRolPermiso();
			//crearRolMenu();
			//crearIncluye();
			//crearUsuario();
			crearCompra();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crearLugarTuristico() {
		log.info("ini : crearLugarTuristico()");
		
		try {
			
			CrudDAO crudDAO = new CrudDAOImpl();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			LugarTuristicoJPA lugarTuristico1 = new LugarTuristicoJPA();
			lugarTuristico1.setNombre("Machu Picchu");
			lugarTuristico1.setDescripcion("Es una de las 7 nuevas maravillas del mundo localizada en Perú, en el Departamento del Cuzco");
			lugarTuristico1.setUrlImagen("https://cutt.ly/hjkeSwO");
			lugarTuristico1.setPrecioXpersona(250.50);
			lugarTuristico1.setInsertadoPor("Juan Perez");
			lugarTuristico1.setFechaInsert(sdf.parse("08/01/2021"));
			
			LugarTuristicoJPA lugarTuristico2 = new LugarTuristicoJPA();
			lugarTuristico2.setNombre("Nevado Huscaran");
			lugarTuristico2.setDescripcion("Nevado Huascarán es el nevado más alto del Perú con 6 768 msnm pico sur, y 6 655 msnm pico norte, ubicado en la Cordillera Blanca, en la Provincia de Yungay");
			lugarTuristico2.setUrlImagen("https://cutt.ly/MjkrzUq");
			lugarTuristico2.setPrecioXpersona(150.00);
			lugarTuristico2.setInsertadoPor("Juan Perez");
			lugarTuristico2.setFechaInsert(sdf.parse("08/01/2021"));
			
			LugarTuristicoJPA lugarTuristico3 = new LugarTuristicoJPA();
			lugarTuristico3.setNombre("Paracas");
			lugarTuristico3.setDescripcion("La reserva nacional de Paracas es una zona protegida del Perú ubicada en la provincia de Pisco, dentro del departamento de Ica");
			lugarTuristico3.setUrlImagen("https://cutt.ly/djkrXAc");
			lugarTuristico3.setPrecioXpersona(110.00);
			lugarTuristico3.setInsertadoPor("Juan Perez");
			lugarTuristico3.setFechaInsert(sdf.parse("03/01/2021"));
			
			
			LugarTuristicoJPA lugarTuristico4 = new LugarTuristicoJPA();
			lugarTuristico4.setNombre("Punta sal");
			lugarTuristico4.setDescripcion("Balneareo muy reconocido en el Norte del Peru, ubicado en el departamento de Tumbes , Peru");
			lugarTuristico4.setUrlImagen("https://cutt.ly/FjlvC4P");
			lugarTuristico4.setPrecioXpersona(200.50);
			lugarTuristico4.setInsertadoPor("Manuel Diaz");
			lugarTuristico4.setFechaInsert(sdf.parse("03/01/2021"));
			
			LugarTuristicoJPA lugarTuristico5 = new LugarTuristicoJPA();
			lugarTuristico5.setNombre("Pozuzo");
			lugarTuristico5.setDescripcion("Pozuzo fue la primera colonia de su tipo fundada en 1859, cuatro años después de que el gobierno peruano les concediera las tierras a los colonos austriacos");
			lugarTuristico5.setUrlImagen("https://cutt.ly/ijlv3OG");
			lugarTuristico5.setPrecioXpersona(95.90);
			lugarTuristico5.setInsertadoPor("Manuel Diaz");
			lugarTuristico5.setFechaInsert(sdf.parse("08/01/2021"));
			
			
			LugarTuristicoJPA lugarTuristico6 = new LugarTuristicoJPA();
			lugarTuristico6.setNombre("kuelap");
			lugarTuristico6.setDescripcion("Importante sitio arqueológico preinca ubicado en los Andes nororientales del Perú, en la Provincia de Luya, fue construido por la cultura Chachapoyas");
			lugarTuristico6.setUrlImagen("https://cutt.ly/7jlbw1c");
			lugarTuristico6.setPrecioXpersona(270.00);
			lugarTuristico6.setInsertadoPor("Juan Perez");
			lugarTuristico6.setFechaInsert(sdf.parse("08/01/2021"));
			
			crudDAO.insertar(lugarTuristico1);
			crudDAO.insertar(lugarTuristico2);
			crudDAO.insertar(lugarTuristico3);
			crudDAO.insertar(lugarTuristico4);
			crudDAO.insertar(lugarTuristico5);
			crudDAO.insertar(lugarTuristico6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("fin : crearLugarTuristico()");
		
		
	}

	private static void crearServicio() {
		log.info("ini : crearServicio()");
		
		try {
			
			CrudDAO crudDAO = new CrudDAOImpl();
			
			ServicioJPA servicio1 = new ServicioJPA();
			servicio1.setNombreServicio("Entradas turisticas");
			
			ServicioJPA servicio2 = new ServicioJPA();
			servicio2.setNombreServicio("Guia");
			
			ServicioJPA servicio3 = new ServicioJPA();
			servicio3.setNombreServicio("Desayuno");
			
			ServicioJPA servicio4 = new ServicioJPA();
			servicio4.setNombreServicio("Almuerzo");
			
			ServicioJPA servicio5 = new ServicioJPA();
			servicio5.setNombreServicio("Cena");
			
			crudDAO.insertar(servicio1);
			crudDAO.insertar(servicio2);
			crudDAO.insertar(servicio3);
			crudDAO.insertar(servicio4);
			crudDAO.insertar(servicio5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		log.info("fin : crearServicio()");	
		
	}

	private static void crearPermiso() {
		
		log.info("ini : crearPermiso()");
		
		try {
			
			CrudDAO crudDAO = new CrudDAOImpl();
			
			PermisoJPA permisoInsertar = new PermisoJPA();
			permisoInsertar.setCodigoPermiso("001");
			permisoInsertar.setDescripcionPermiso("Insertar");
			
			PermisoJPA permisoActualizar = new PermisoJPA();
			permisoActualizar.setCodigoPermiso("002");
			permisoActualizar.setDescripcionPermiso("Actualizar");
			
			PermisoJPA permisoConsultar = new PermisoJPA();
			permisoConsultar.setCodigoPermiso("003");
			permisoConsultar.setDescripcionPermiso("Consultar");
			
			PermisoJPA permisoEliminar = new PermisoJPA();
			permisoEliminar.setCodigoPermiso("004");
			permisoEliminar.setDescripcionPermiso("Eliminar");
			
			crudDAO.insertar(permisoInsertar);
			crudDAO.insertar(permisoActualizar);
			crudDAO.insertar(permisoConsultar);
			crudDAO.insertar(permisoEliminar);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("fin : crearPermiso()");
		
	}

	private static void crearMenu() {
		log.info("ini : crearMenu()");
		
		try {
				CrudDAO crudDAO = new CrudDAOImpl();
			
				MenuJPA menuAdministrador = new MenuJPA();
				menuAdministrador.setCodigoMenu("001");
				menuAdministrador.setMenu("Menu del administrador");
				
				MenuJPA menuTrabajador = new MenuJPA();
				menuTrabajador.setCodigoMenu("002");
				menuTrabajador.setMenu("Menu del Trabajador");
				
				MenuJPA menuUsuario = new MenuJPA();
				menuUsuario.setCodigoMenu("004");
				menuUsuario.setMenu("Menu del Usuario");
				
				crudDAO.insertar(menuAdministrador);
				crudDAO.insertar(menuTrabajador);
				crudDAO.insertar(menuUsuario);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		log.info("fin : crearMenu()");
		
	}

	private static void crearRol() {
		
		log.info("ini : crearRol()");
		
		try {
			
			CrudDAO crudDAO = new CrudDAOImpl();
			
			RolJPA Administrador = new RolJPA();
			Administrador.setDescripcion("Administrador");
			
			RolJPA trabajador = new RolJPA();
			trabajador.setDescripcion("Trabajador");
			
			RolJPA usuario = new RolJPA();
			usuario.setDescripcion("Usuario");
			
			crudDAO.insertar(Administrador);
			crudDAO.insertar(trabajador);
			crudDAO.insertar(usuario);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearRol()");
	}

	private static void crearRolPermiso() {
		
		log.info("ini : crearRolPermiso()");
		
		try {
			
			RolDAO rolDAO = new RolDAOImpl();
			PermisoDAO permisoDAO = new PermisoDAOImpl();
			CrudDAO crudDAO = new CrudDAOImpl();
			
			RolJPA trabajador = rolDAO.getRolById(2);
			PermisoJPA permisoInsertar= permisoDAO.getPermisoById(1);
			RolPermisoJPA rolPermiso1 = new RolPermisoJPA();
			rolPermiso1.setRol(trabajador);
			rolPermiso1.setPermiso(permisoInsertar);
			
			
			RolJPA ususario = rolDAO.getRolById(3);
			PermisoJPA permisoConsultar= permisoDAO.getPermisoById(3);
			RolPermisoJPA rolPermiso2 = new RolPermisoJPA();
			rolPermiso2.setRol(ususario);
			rolPermiso2.setPermiso(permisoConsultar);
			
			crudDAO.insertar(rolPermiso1);
			crudDAO.insertar(rolPermiso2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearRolPermiso()");
		
	}

	private static void crearRolMenu() {
		
		log.info("ini : crearRolMenu()");
		
		try {
			RolDAO rolDAO = new RolDAOImpl();
			MenuDAO menuDAO = new MenuDAOImpl();
			CrudDAO crudDAO = new CrudDAOImpl();
			
			RolJPA administrador = rolDAO.getRolById(1);
			MenuJPA menuAdministrador = menuDAO.getMenuById(1);
			RolMenuJPA rolMenu1 = new RolMenuJPA();
			rolMenu1.setRol(administrador);
			rolMenu1.setMenu(menuAdministrador);
			
			RolJPA trabajador = rolDAO.getRolById(2);
			MenuJPA menuTrabajador = menuDAO.getMenuById(2);
			RolMenuJPA rolMenu2 = new RolMenuJPA();
			rolMenu2.setRol(trabajador);
			rolMenu2.setMenu(menuTrabajador);
			
			RolJPA usuario = rolDAO.getRolById(3);
			MenuJPA menuUsuario = menuDAO.getMenuById(3);
			RolMenuJPA rolMenu3 = new RolMenuJPA();
			rolMenu3.setRol(usuario);
			rolMenu3.setMenu(menuUsuario);
			
			crudDAO.insertar(rolMenu1);
			crudDAO.insertar(rolMenu2);
			crudDAO.insertar(rolMenu3);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearRolMenu()");
		
	}

	private static void crearIncluye() {
		
		log.info("ini : crearIncluye()");
		
		try {
			LugarTuristicoDAO lugaresTuristicoDAO = new LugarTuristicoDAOImpl();
			ServicioDAO servicioDAO = new ServicioDAOImpl();
			CrudDAO crudDAO = new CrudDAOImpl();
			
			LugarTuristicoJPA tour1 = lugaresTuristicoDAO.getLugarTuristicoById(1);
			ServicioJPA Boleto = servicioDAO.getServicioById(1);
			IncluyeJPA incluyeBoleto = new IncluyeJPA();
			incluyeBoleto.setCosto(10.50);
			incluyeBoleto.setLugarTuristico(tour1);
			incluyeBoleto.setServicio(Boleto);
			
			LugarTuristicoJPA tour2 = lugaresTuristicoDAO.getLugarTuristicoById(2);
			ServicioJPA guia = servicioDAO.getServicioById(2);
			IncluyeJPA incluyeGuia = new IncluyeJPA();
			incluyeGuia.setCosto(15.30);
			incluyeGuia.setLugarTuristico(tour2);
			incluyeGuia.setServicio(guia);
			
			LugarTuristicoJPA tour3 = lugaresTuristicoDAO.getLugarTuristicoById(4);
			ServicioJPA desayuno = servicioDAO.getServicioById(3);
			IncluyeJPA incluyeDesayuno = new IncluyeJPA();
			incluyeDesayuno.setCosto(4.50);
			incluyeDesayuno.setLugarTuristico(tour3);
			incluyeDesayuno.setServicio(desayuno);
			
			crudDAO.insertar(incluyeBoleto);
			crudDAO.insertar(incluyeGuia);
			crudDAO.insertar(incluyeDesayuno);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearIncluye()");
		
	}

	private static void crearUsuario() {
		
		log.info("ini : crearUsuario()");
		
		try {
			
			RolDAO rolDAO = new RolDAOImpl();
			CrudDAO crudDAO = new CrudDAOImpl();
			
			RolJPA rolAdministrador = rolDAO.getRolById(1);
			UsuarioJPA usuarioAdministrador = new UsuarioJPA();
			usuarioAdministrador.setNombreUsuario("Ricardo");
			usuarioAdministrador.setApellido("Rios");
			usuarioAdministrador.setUsuario("ricardo123");
			usuarioAdministrador.setClave("123");
			usuarioAdministrador.setRol(rolAdministrador);
			
			RolJPA rolTrabajador = rolDAO.getRolById(2);
			UsuarioJPA usuarioTrabajador = new UsuarioJPA();
			usuarioTrabajador.setNombreUsuario("Richard");
			usuarioTrabajador.setApellido("Swing");
			usuarioTrabajador.setUsuario("richar123");
			usuarioTrabajador.setClave("123");
			usuarioTrabajador.setRol(rolTrabajador);
			
			RolJPA rolUsuario = rolDAO.getRolById(3);
			UsuarioJPA usuario1 = new UsuarioJPA();
			usuario1.setNombreUsuario("Manuel");
			usuario1.setApellido("Burga");
			usuario1.setUsuario("manuel123");
			usuario1.setClave("123");
			usuario1.setRol(rolUsuario);
			
			crudDAO.insertar(usuarioAdministrador);
			crudDAO.insertar(usuarioTrabajador);
			crudDAO.insertar(usuario1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		log.info("fin : crearUsuario()");
		
	}

	private static void crearCompra() {
		
		log.info("ini : crearCompra()");
		
		try {
			LugarTuristicoDAO lugaresTuristicoDAO = new LugarTuristicoDAOImpl();
			UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
			CrudDAO crudDAO = new CrudDAOImpl();
			
			LugarTuristicoJPA huascaran = lugaresTuristicoDAO.getLugarTuristicoById(2);
			UsuarioJPA usuario1 = usuarioDAO.getUsuarioById(3);
			CompraJPA compra1 = new CompraJPA();
			compra1.setCantidadPersonas(1);
			compra1.setMontoTotal(170.50);
			compra1.setUsuario(usuario1);
			compra1.setLugarTuristico(huascaran);
			
			crudDAO.insertar(compra1);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearCompra()");
	}

}
