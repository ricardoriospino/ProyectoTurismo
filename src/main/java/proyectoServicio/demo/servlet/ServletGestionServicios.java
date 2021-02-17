package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.util.List;

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
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.ServicioService;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.ServicioServiceImpl;



/**
 * Servlet implementation class ServletGestionServicios
 */
@WebServlet("/ServletGestionServicios")
public class ServletGestionServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletGestionServicios.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionServicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(" ini : ServletGestionServicios - doGe()");
		
		String pagina ="/gestion/gestionServicios.jsp";
		String accion = request.getParameter("p_accion");
		LugarTuristicoService serviceTour = new LugarTuristicoServiceImpl();
		HttpSession misession = request.getSession(true);  
		
		if("inicioGestionServicios".equals(accion)) {
			
			misession.removeAttribute("tourSeleccionado");
			List<LugarTuristicoJPA>lstTour = serviceTour.listarLugaresTuristicos();
			request.setAttribute("lstLugaresTuristicos", lstTour );
			
			ServicioService serviceServicio = new ServicioServiceImpl();
			List<ServicioJPA>lista = serviceServicio.listarServicios();
			request.setAttribute("lstServicios", lista);
			
		}else if("seleccionar".equals(accion)) {
			
			String idTour = request.getParameter("idTour");
			
			LugarTuristicoJPA tour = serviceTour.getLugarTuristicoById(Integer.parseInt(idTour));
			misession.setAttribute("tourSeleccionado", tour);
			
			ServicioService serviceServicio = new ServicioServiceImpl();
			List<ServicioJPA>lista = serviceServicio.listarServicios();
			request.setAttribute("lstServicios", lista);

			List<LugarTuristicoJPA>lstTour = serviceTour.listarLugaresTuristicos();
			request.setAttribute("lstLugaresTuristicos", lstTour );
			
		}
		
		RequestDispatcher despachador = null;
		
		despachador = request.getRequestDispatcher(pagina);
		despachador.forward(request, response);		
		
		log.info(" fin : ServletGestionServicios - doGe()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
