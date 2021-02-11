package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.ServicioService;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.ServicioServiceImpl;


/**
 * Servlet implementation class ServletListarServicosTour
 */
@WebServlet("/ServletInfoTour")
public class ServletInfoTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletInfoTour.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInfoTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(" ini : ServletInfoTour - doGe()");
		
		
		RequestDispatcher despachador = null;
		
		//obtener id
		String idLugarTuristico = (String) request.getParameter("idLugarTuristico");
		log.debug("idLugarTuristico :" , idLugarTuristico);
		
		
		LugarTuristicoService service = new LugarTuristicoServiceImpl();
		LugarTuristicoJPA lugarTuristico = service.obtenerLugaresTuristicosByid(Integer.valueOf(idLugarTuristico));
		request.setAttribute("objLugarTuristico", lugarTuristico);
		
		ServicioService service2 = new ServicioServiceImpl();
		List<ServicioJPA>lista = service2.listarServiciosTour(Integer.valueOf(idLugarTuristico));
		request.setAttribute("lstServiciosIncluidos", lista);
			
		request.setAttribute("idLugarTuristico", idLugarTuristico);
		
		despachador = request.getRequestDispatcher("/lugaresTuristicos/tourInfo.jsp");
		
		despachador.forward(request, response);
		
		log.info(" ini : ServletInfoTour - doGe()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
