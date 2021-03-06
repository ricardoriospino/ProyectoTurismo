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
import proyectoServicio.demo.jpa.entity.MenuJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.MenuService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.MenuServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class ServletListarLugaresTuristicos
 */
@WebServlet("/ServletListarLugaresTuristicos")
public class ServletListarLugaresTuristicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletListarLugaresTuristicos.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarLugaresTuristicos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletListarLugaresTuristicos - doGet ");
		
		LugarTuristicoService lugarTuristicoService = new LugarTuristicoServiceImpl();
		List<LugarTuristicoJPA>lista = lugarTuristicoService.listarLugaresTuristicos();
		
		request.setAttribute("lstLugaresTuristicos", lista);
		
		log.debug("lista lugares turisticos : " +  lista.size());
		
		RequestDispatcher despachador = null;
		
		

		despachador = request.getRequestDispatcher("index.jsp");
		
		despachador.forward(request, response);
		
		log.info("init: ServletListarLugaresTuristicos - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
