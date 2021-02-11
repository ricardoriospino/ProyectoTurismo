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

import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.service.RolService;
import proyectoServicio.demo.service.impl.RolServiceImpl;



/**
 * Servlet implementation class ServletRol
 */
@WebServlet("/ServletRol")
public class ServletRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletRol.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletRol - doGet ");
		
		RolService service = new RolServiceImpl();
		
		List<RolJPA> lista = service.listarRol();
		
		request.setAttribute("lstRoles", lista);
		request.setAttribute("btnAccion", "insert");
		
		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher("/formulario/formularioUsuario.jsp");
		despachador.forward(request, response);
		log.info("fin: ServletRol - doGet ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
