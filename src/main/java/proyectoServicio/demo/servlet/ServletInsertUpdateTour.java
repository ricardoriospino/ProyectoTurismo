package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
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
		
		//LugarTuristicoJPA lugarTuristicoservice  = new LugarTuristicoJPA();
		HttpSession misession = request.getSession(true); 
		UsuarioJPA usuario = (UsuarioJPA) misession.getAttribute("usuarioSession");

		//Date date = new Date();
		//DateFormat  formato = new SimpleDateFormat("yyyy/MM/dd");
 
		String codigoForm = request.getParameter("codigo_lugar_turistico");
		String nombreForm = request.getParameter("nombre");
		String descripcionForm = request.getParameter("descripcion");
		String urlImagen1Form = request.getParameter("url_imagen1");
		String urlImagen2Form = request.getParameter("url_imagen2");
		String urlImagen3Form = request.getParameter("url_imagen3");
		double precioxPersonaForm = Double.parseDouble(request.getParameter("precio_x_persona"));
		String insertadoPorForm = usuario.getNombreUsuario();
		String modificadoPorForm = usuario.getNombreUsuario();
		
		Date fechaInsertForm =  new Date();
		Date fechaUpdateForm = new Date();
		
		int calificacionEstrellasForm = Integer.parseInt(request.getParameter("calificacion_estrellas"));
		
		
		//String habilitadoODeshabilitadoForm = request.getParameter("habilitado_o_deshabilitado");
		String habilitadoODeshabilitadoForm = "Habilitado";
		
		String climaTourForm = request.getParameter("clima_tour");
		
		log.debug("Datos ingresados : el codigo es: " + codigoForm + " el nombre es: " + nombreForm + " descripcion es : " + descripcionForm +
				  " url imagen 1 :" + urlImagen1Form + " url imagen 2 : " + urlImagen2Form +" urlimagen 3 " + urlImagen3Form +
				  " precio por persona es: " + precioxPersonaForm + " insertado por : " + insertadoPorForm + " modificado por : " + modificadoPorForm +
				  " fecha insert : " + fechaInsertForm + " fecha update: " + fechaUpdateForm + " calificacion " + calificacionEstrellasForm +
				  " habilitado O Deshabilitado :" + habilitadoODeshabilitadoForm + " clima :" + climaTourForm);
		
		
		CRUDService serviceCrud = new CRUDServiceImpl();
		
		
		LugarTuristicoJPA lugarTuristico = null;
		int estado = 0;
		String mensaje ="";
		
		// entra cuando es insert
		if("insert".equals(accion)) {
	
				lugarTuristico = new LugarTuristicoJPA(codigoForm, nombreForm, descripcionForm, urlImagen1Form, urlImagen2Form, 
														urlImagen3Form, precioxPersonaForm, insertadoPorForm, fechaInsertForm, 
														calificacionEstrellasForm, habilitadoODeshabilitadoForm, climaTourForm);
				
				serviceCrud.insertar(lugarTuristico);
				estado = 1;
				mensaje ="<strong>Ingresado!</strong> Datos Ingresado correctamente a la base de datos.";
				
		// entra cuando es update
		}else if ("update".equals(accion)) {
			
			String idLugarTuristico = request.getParameter("hdnIdLugarTuristico");
			lugarTuristico = new LugarTuristicoJPA(Integer.valueOf(idLugarTuristico), codigoForm, nombreForm, descripcionForm, urlImagen1Form , urlImagen2Form, 
													urlImagen3Form, precioxPersonaForm,  modificadoPorForm,  fechaUpdateForm, calificacionEstrellasForm, 
													habilitadoODeshabilitadoForm, climaTourForm);
			serviceCrud.actualizar(lugarTuristico);
			estado = 1;
			mensaje ="<strong>Actualizado!</strong> Datos Actualizados  la base de datos.";
		}
		
		PrintWriter salida = response.getWriter();
		RequestDispatcher disparador =null;
		
		if (estado == 1) {
			request.setAttribute("ingresado", true);
			request.setAttribute("msg", mensaje);
			disparador= request.getRequestDispatcher("/ServletTour");
			
		}else {
			salida.println("<html><body>");
			salida.println("<h3>Alerta</h3>");
			salida.println("Tour invalido!");
			salida.println("</html></body>");
		}
		
		disparador.forward(request, response);	
		
		log.info("fin: ServletInsertUpdateTour doPost");
	}

}
