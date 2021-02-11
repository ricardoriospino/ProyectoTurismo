package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;


/**
 * Servlet implementation class ServletInsertUpdateTour
 */
@WebServlet("/ServletInsertUpdateTour")
public class ServletInsertUpdateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletInsertUpdateTour.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertUpdateTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		log.info("Inicia: ServletInsertUpdateTour doPost");
		
		String accion = request.getParameter("hdnAccion");
		log.debug("accion " + accion );
		
		DateFormat formato ;
		
		formato = new SimpleDateFormat("yyyy/MM/dd");
 
		String codigoForm = request.getParameter("codigo_lugar_turistico");
		String nombreForm = request.getParameter("nombre");
		String descripcionForm = request.getParameter("descripcion");
		String urlImagen1Form = request.getParameter("url_imagen1");
		String urlImagen2Form = request.getParameter("url_imagen2");
		String urlImagen3Form = request.getParameter("url_imagen3");
		double precioxPersonaForm = Double.parseDouble(request.getParameter("precio_x_persona"));
		String insertadoPorForm = request.getParameter("insertado_por");
		String modificadoPorForm = request.getParameter("modificado_por");
		
		Date fechaInsertForm = null;
		try {
			fechaInsertForm = formato.parse(request.getParameter("fecha_insert"));
		} catch (ParseException e) {
			e.printStackTrace();
			log.error("error al capturar dato fechaInsertForm " + e);
		}
		
		Date fechaUpdateForm = null;
		try {
			fechaUpdateForm = formato.parse(request.getParameter("fecha_update"));
		} catch (ParseException e) {
			e.printStackTrace();
			log.error("error al capturar dato fechaUpdateForm " + e);
		}
		
		int calificacionEstrellasForm = Integer.parseInt(request.getParameter("calificacion_estrellas"));
		String habilitadoODeshabilitadoForm = request.getParameter("habilitado_o_deshabilitado");
		String climaTourForm = request.getParameter("clima_tour");
		
		log.debug("Datos ingresados : el codigo es: " + codigoForm + " el nombre es: " + nombreForm + " descripcion es : " + descripcionForm +
				  " url imagen 1 :" + urlImagen1Form + " url imagen 2 : " + urlImagen2Form +" urlimagen 3 " + urlImagen3Form +
				  " precio por persona es: " + precioxPersonaForm + " insertado por : " + insertadoPorForm + " modificado por : " + modificadoPorForm +
				  " fecha insert : " + fechaInsertForm + " fecha update: " + fechaUpdateForm + " calificacion " + calificacionEstrellasForm +
				  " habilitado O Deshabilitado :" + habilitadoODeshabilitadoForm + " clima :" + climaTourForm);
		
		
		CRUDService service1 = new CRUDServiceImpl();
		
		LugarTuristicoJPA lugarTuristico = null;
		//int estado = 0;
		String mensaje ="";
		
		// entra cuando es insert
		if("insert".equals(accion)) {
		
				lugarTuristico = new LugarTuristicoJPA(codigoForm, nombreForm, descripcionForm, urlImagen1Form, urlImagen2Form, 
														urlImagen3Form, precioxPersonaForm, insertadoPorForm, fechaInsertForm, 
														calificacionEstrellasForm, habilitadoODeshabilitadoForm, climaTourForm);
				
				service1.insertar(lugarTuristico);
				mensaje ="<strong>Ingresado!</strong> Datos Ingresado correctamente a la base de datos.";
				
		// entra cuando es update
		}
		
		log.info("fin: ServletInsertUpdateTour doPost");
	}

}
