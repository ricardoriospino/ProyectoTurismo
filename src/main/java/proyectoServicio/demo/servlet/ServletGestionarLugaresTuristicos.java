package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
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
 * Servlet implementation class ServletGestionarLugaresTuristicos
 */
@WebServlet("/ServletGestionarLugaresTuristicos")
public class ServletGestionarLugaresTuristicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletGestionarLugaresTuristicos.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionarLugaresTuristicos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletGestionarLugaresTuristicos - doGet ");
		
		String accion = request.getParameter("p_accion");
		
		RequestDispatcher despachador = null;
		log.debug( "Accion : " + accion);
		
		LugarTuristicoService serviceTour = new LugarTuristicoServiceImpl();
		
		if("editar".equals(accion)) {
			
			String idTour = (String) request.getParameter("idTour");
			log.debug("idUsuario es: " + idTour);
				
			LugarTuristicoJPA tour = serviceTour.obtenerLugaresTuristicosByid(Integer.valueOf(idTour));
			request.setAttribute("objTour", tour);
			
			request.setAttribute("idTour", idTour);
			request.setAttribute("btnAccion","update" );
			
			despachador = request.getRequestDispatcher("/formulario/formularioTour.jsp");
			
		}else if ("eliminar".equals(accion)) {
			
			log.debug("accion:"+accion);
			
			CRUDService serviceCrud = new CRUDServiceImpl();
			int idTour = Integer.parseInt(request.getParameter("idTour"));
			
			LugarTuristicoJPA tourJPA = new LugarTuristicoJPA();
			tourJPA.setIdLugarTuristico(idTour);
			
			int bandera = serviceCrud.eliminar(tourJPA);
			
			if(bandera == 0) {
				
				log.debug("no se logro eliminar " + bandera);
				
			}else if(bandera == 1) {
				
				request.setAttribute("eliminado", true);
				log.debug("eliminado correctamente");
			}
			
			List<LugarTuristicoJPA>lstTour = serviceTour.listarLugaresTuristicos();
			request.setAttribute("lstLugaresTuristicos", lstTour);
			despachador = request.getRequestDispatcher("/listados/listaLugaresTuristicos.jsp");
		}
		despachador.forward(request, response);
		log.info("fin: ServletGestionarLugaresTuristicos - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
