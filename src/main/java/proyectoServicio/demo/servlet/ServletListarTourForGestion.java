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
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;



/**
 * Servlet implementation class ServletListarTourForGestion
 */
@WebServlet("/ServletListarTourForGestion")
public class ServletListarTourForGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletListarTourForGestion.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarTourForGestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletListarTourForGestion - doGet ");
		
		LugarTuristicoService lugarTuristicoService = new LugarTuristicoServiceImpl();
		List<LugarTuristicoJPA>listaTour = lugarTuristicoService.listarLugaresTuristicos();
		
		request.setAttribute("lstLugaresTuristicos", listaTour);
		
		log.debug("lista lugares turisticos : " +  listaTour.size());
		
		RequestDispatcher despachador = null;
		
		despachador = request.getRequestDispatcher("/listados/listaLugaresTuristicos.jsp");
		
		despachador.forward(request, response);
		
		log.info("init: ServletListarTourForGestion - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
