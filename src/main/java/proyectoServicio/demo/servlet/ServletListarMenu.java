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

import proyectoServicio.demo.jpa.entity.MenuJPA;
import proyectoServicio.demo.service.MenuService;
import proyectoServicio.demo.service.impl.MenuServiceImpl;



/**
 * Servlet implementation class ServletListarMenu
 */
@WebServlet("/ServletListarMenu")
public class ServletListarMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletListarMenu.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletListarMenu - doGet ");
		
		MenuService MenuService = new MenuServiceImpl();
		List<MenuJPA>lista = MenuService.listarMenu();
		
		request.setAttribute("lstMenu", lista);
		
		log.debug("lista menu : " +  lista.size());
		
		RequestDispatcher despachador = null;
		
		despachador = request.getRequestDispatcher("index.jsp");
		
		despachador.forward(request, response);
		
		
		
		log.info("fin: ServletListarMenu - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
