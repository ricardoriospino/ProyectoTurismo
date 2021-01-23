package demo.test.proyecto;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.MenuJPA;
import proyectoServicio.demo.jpa.entity.PermisoJPA;
import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;


public class TestUnitarioCreaciondeJpa {
	
	private static final Logger log= LogManager.getLogger(TestUnitarioCreaciondeJpa.class);
	
	public static void main(String[] args) {
		
		try {
			crearLugarTuristico();
			crearServicio();
			crearPermiso();
			crearMenu();
			crearRol();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crearLugarTuristico() {
		log.info("ini : crearLugarTuristico()");
		
		try {
			
			CRUDService crudService = new CRUDServiceImpl();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			LugarTuristicoJPA lugarTuristico1 = new LugarTuristicoJPA();
			lugarTuristico1.setCodigoLugarTuristico("001MP");
			lugarTuristico1.setNombre("Machu Picchu");
			lugarTuristico1.setDescripcion("Es una de las 7 nuevas maravillas del mundo localizada en Perú, en el Departamento del Cuzco");
			lugarTuristico1.setUrlImagen("https://cutt.ly/hjkeSwO");
			lugarTuristico1.setPrecioXpersona(250.50);
			lugarTuristico1.setInsertadoPor("Juan Perez");
			lugarTuristico1.setFechaInsert(sdf.parse("08/01/2021"));
			
			LugarTuristicoJPA lugarTuristico2 = new LugarTuristicoJPA();
			lugarTuristico2.setCodigoLugarTuristico("002NH");
			lugarTuristico2.setNombre("Nevado Huscaran");
			lugarTuristico2.setDescripcion("Nevado Huascarán es el nevado más alto del Perú con 6 768 msnm pico sur, y 6 655 msnm pico norte, ubicado en la Cordillera Blanca, en la Provincia de Yungay");
			lugarTuristico2.setUrlImagen("https://cutt.ly/MjkrzUq");
			lugarTuristico2.setPrecioXpersona(150.00);
			lugarTuristico2.setInsertadoPor("Juan Perez");
			lugarTuristico2.setFechaInsert(sdf.parse("08/01/2021"));
			
			LugarTuristicoJPA lugarTuristico3 = new LugarTuristicoJPA();
			lugarTuristico3.setCodigoLugarTuristico("003P");
			lugarTuristico3.setNombre("Paracas");
			lugarTuristico3.setDescripcion("La reserva nacional de Paracas es una zona protegida del Perú ubicada en la provincia de Pisco, dentro del departamento de Ica");
			lugarTuristico3.setUrlImagen("https://cutt.ly/djkrXAc");
			lugarTuristico3.setPrecioXpersona(110.00);
			lugarTuristico3.setInsertadoPor("Juan Perez");
			lugarTuristico3.setFechaInsert(sdf.parse("03/01/2021"));
			
			
			LugarTuristicoJPA lugarTuristico4 = new LugarTuristicoJPA();
			lugarTuristico4.setCodigoLugarTuristico("004PS");
			lugarTuristico4.setNombre("Punta sal");
			lugarTuristico4.setDescripcion("Balneareo muy reconocido en el Norte del Peru, ubicado en el departamento de Tumbes , Peru");
			lugarTuristico4.setUrlImagen("https://cutt.ly/FjlvC4P");
			lugarTuristico4.setPrecioXpersona(200.50);
			lugarTuristico4.setInsertadoPor("Manuel Diaz");
			lugarTuristico4.setFechaInsert(sdf.parse("03/01/2021"));
			
			LugarTuristicoJPA lugarTuristico5 = new LugarTuristicoJPA();
			lugarTuristico5.setCodigoLugarTuristico("005P");
			lugarTuristico5.setNombre("Pozuzo");
			lugarTuristico5.setDescripcion("Pozuzo fue la primera colonia de su tipo fundada en 1859, cuatro años después de que el gobierno peruano les concediera las tierras a los colonos austriacos");
			lugarTuristico5.setUrlImagen("https://cutt.ly/ijlv3OG");
			lugarTuristico5.setPrecioXpersona(95.90);
			lugarTuristico5.setInsertadoPor("Manuel Diaz");
			lugarTuristico5.setFechaInsert(sdf.parse("08/01/2021"));
			
			
			LugarTuristicoJPA lugarTuristico6 = new LugarTuristicoJPA();
			lugarTuristico6.setCodigoLugarTuristico("006K");
			lugarTuristico6.setNombre("kuelap");
			lugarTuristico6.setDescripcion("Importante sitio arqueológico preinca ubicado en los Andes nororientales del Perú, en la Provincia de Luya, fue construido por la cultura Chachapoyas");
			lugarTuristico6.setUrlImagen("https://cutt.ly/7jlbw1c");
			lugarTuristico6.setPrecioXpersona(270.00);
			lugarTuristico6.setInsertadoPor("Juan Perez");
			lugarTuristico6.setFechaInsert(sdf.parse("08/01/2021"));
			
			crudService.insertar(lugarTuristico1);
			crudService.insertar(lugarTuristico2);
			crudService.insertar(lugarTuristico3);
			crudService.insertar(lugarTuristico4);
			crudService.insertar(lugarTuristico5);
			crudService.insertar(lugarTuristico6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("fin : crearLugarTuristico()");
		
		
	}

	private static void crearServicio() {
		log.info("ini : crearServicio()");
		
		try {
			
			CRUDService crudService = new CRUDServiceImpl();
			
			ServicioJPA servicio1 = new ServicioJPA();
			servicio1.setCodigo_servicio("001");
			servicio1.setNombreServicio("Entradas turisticas");
			
			ServicioJPA servicio2 = new ServicioJPA();
			servicio2.setCodigo_servicio("002");
			servicio2.setNombreServicio("Guia");
			
			ServicioJPA servicio3 = new ServicioJPA();
			servicio3.setCodigo_servicio("003");
			servicio3.setNombreServicio("Desayuno");
			
			ServicioJPA servicio4 = new ServicioJPA();
			servicio4.setCodigo_servicio("004");
			servicio4.setNombreServicio("Almuerzo");
			
			ServicioJPA servicio5 = new ServicioJPA();
			servicio5.setCodigo_servicio("005");
			servicio5.setNombreServicio("Cena");
			
			ServicioJPA servicio6 = new ServicioJPA();
			servicio6.setCodigo_servicio("006");
			servicio6.setNombreServicio("Transporte");
			
			crudService.insertar(servicio1);
			crudService.insertar(servicio2);
			crudService.insertar(servicio3);
			crudService.insertar(servicio4);
			crudService.insertar(servicio5);
			crudService.insertar(servicio6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		log.info("fin : crearServicio()");	
		
	}

	private static void crearPermiso() {
		
		log.info("ini : crearPermiso()");
		
		try {
			
			CRUDService crudService = new CRUDServiceImpl();
			
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
			
			PermisoJPA permisoAdmin = new PermisoJPA();
			permisoAdmin.setCodigoPermiso("005");
			permisoAdmin.setDescripcionPermiso("fullaccess");
			
			crudService.insertar(permisoInsertar);
			crudService.insertar(permisoActualizar);
			crudService.insertar(permisoConsultar);
			crudService.insertar(permisoEliminar);
			crudService.insertar(permisoAdmin);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		log.info("fin : crearPermiso()");
		
	}

	private static void crearMenu() {
		log.info("ini : crearMenu()");
		
		try {
			CRUDService crudService = new CRUDServiceImpl();
			
			MenuJPA menu1 = new MenuJPA();
			menu1.setCodigoMenu("001");
			menu1.setMenu("Menu del administrador");
			
			MenuJPA menu2 = new MenuJPA();
			menu2.setCodigoMenu("002");
			menu2.setMenu("Menu del Trabajador");
			
			MenuJPA menu3 = new MenuJPA();
			menu3.setCodigoMenu("003");
			menu3.setMenu("Menu del Usuario");
			
			MenuJPA menu4 = new MenuJPA();
			menu4.setCodigoMenu("004");
			menu4.setMenu("Ver Lugares Turisticos");
			
			MenuJPA menu5 = new MenuJPA();
			menu5.setCodigoMenu("005");
			menu5.setMenu("Comprar Boletos Turisticos");
			
			crudService.insertar(menu1);
			crudService.insertar(menu2);
			crudService.insertar(menu3);
			crudService.insertar(menu4);
			crudService.insertar(menu5);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		log.info("fin : crearMenu()");
		
	}

	private static void crearRol() {
		
		log.info("ini : crearRol()");
		
		try {
			
			CRUDService crudService = new CRUDServiceImpl();
			
			RolJPA Administrador = new RolJPA();
			Administrador.setCodigoRol("01");
			Administrador.setDescripcion("Administrador");
			
			RolJPA trabajador = new RolJPA();
			trabajador.setCodigoRol("02");
			trabajador.setDescripcion("Trabajador");
			
			RolJPA usuario = new RolJPA();
			usuario.setCodigoRol("03");
			usuario.setDescripcion("Usuario");
			
			RolJPA invitado = new RolJPA();
			invitado.setCodigoRol("04");
			invitado.setDescripcion("Invitado");
			
			crudService.insertar(Administrador);
			crudService.insertar(trabajador);
			crudService.insertar(usuario);
			crudService.insertar(invitado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		log.info("fin : crearRol()");
	}

}
