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

import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class ServletListarUsuarioForGestion
 */
@WebServlet("/ServletListarUsuarioForGestion")
public class ServletListarUsuarioForGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletListarUsuarioForGestion.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarUsuarioForGestion() {
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
		
		UsuarioService usuarioService = new UsuarioServiceImpl();
		List<UsuarioJPA>listarUsuario = usuarioService.listarUsuarios();
		
		request.setAttribute("lstUsuarios", listarUsuario);
		
		RequestDispatcher despachador = null;
			
		despachador = request.getRequestDispatcher("/listados/listaUsuarios.jsp");
		
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
