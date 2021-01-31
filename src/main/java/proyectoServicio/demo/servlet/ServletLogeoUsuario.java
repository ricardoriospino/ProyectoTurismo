package proyectoServicio.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;



/**
 * Servlet implementation class ServletLogeoUsuario
 */
@WebServlet("/ServletLogeoUsuario")
public class ServletLogeoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletLogeoUsuario.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogeoUsuario() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		log.info("ini: ServletLogeo");
		
		String usuarioForm = request.getParameter("usuario");
		String claveForm = request.getParameter("clave");
		
		log.debug(" el usuario es " +  usuarioForm + " la clave es " + claveForm);
		
		// verificacion con la base de datos
		
		UsuarioService usuarioService = new UsuarioServiceImpl();
		
		UsuarioJPA usuario = usuarioService.validarUsuarioClave(usuarioForm, claveForm);
		
		RequestDispatcher despachador = null;
		
		if(usuario!= null) {
			
			HttpSession misession = request.getSession(true); 
			misession.setAttribute("usuarioSession", usuario);
			despachador = request.getRequestDispatcher("/index.jsp");
			
		}else {
			request.setAttribute("error", true);
			despachador = request.getRequestDispatcher("/login.jsp");
		}
		
		despachador.forward(request, response);
		
		log.info("fin: ServletLogeo");
	}

}
