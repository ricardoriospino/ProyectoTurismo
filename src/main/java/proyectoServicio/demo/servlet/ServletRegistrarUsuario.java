package proyectoServicio.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;

/**
 * Servlet implementation class ServletRegistrarUsuario
 */
@WebServlet("/ServletRegistrarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletRegistrarUsuario.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarUsuario() {
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
		
		log.info("Ini: ServletRegistrarUsuario doPost");
		
		String nombreForm = request.getParameter("nombre_personal");
		String apellidoForm = request.getParameter("apellido");
		String usuarioForm = request.getParameter("usuario");
		String claveForm = request.getParameter("clave");
		RolJPA idRolForm = new RolJPA();
		
		idRolForm.setIdRol(3);
		
		log.debug("Datos ingresados , nombre: " + nombreForm + " , apellido : " + apellidoForm + " ,usuario : " + usuarioForm
				  + " clave : " + claveForm + " id Rol : " + idRolForm);
		
		CRUDService serviceCrud = new CRUDServiceImpl();
		UsuarioJPA usuario = null;
		String mensaje="";
		
		UsuarioService serviceUsuario = new UsuarioServiceImpl();
		Long validarUsuario = (Long) serviceUsuario.validarUsuario(usuarioForm);
		
		RequestDispatcher despachador =null;
		
		if(validarUsuario == 0L) {
			
			usuario = new UsuarioJPA(nombreForm, apellidoForm, usuarioForm, claveForm, idRolForm);
			serviceCrud.insertar(usuario);
			
			mensaje = "<strong>Registro Exitoso!</strong>";
			request.setAttribute("ingresado", true);
			request.setAttribute("msg", mensaje);
			despachador= request.getRequestDispatcher("/login.jsp");
			
		}else {
			request.setAttribute("error",true);
			log.debug("error true");
			despachador= request.getRequestDispatcher("/register.jsp");
		}
		despachador.forward(request, response);	
		
		log.info("fin: ServletRegistrarUsuario doPost");
	}

}
