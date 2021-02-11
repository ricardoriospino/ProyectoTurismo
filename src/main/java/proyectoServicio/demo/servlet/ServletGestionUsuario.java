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
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.RolService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;
import proyectoServicio.demo.service.impl.RolServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;



/**
 * Servlet implementation class ServletGestionUsuario
 */
@WebServlet("/ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletGestionUsuario.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletGestionUsuario - doGet ");
		
		String accion = request.getParameter("p_accion");
		
		RequestDispatcher despachador = null;
		log.debug( "Accion : " + accion);
		
		if("editar".equals(accion)){
			
			String idUsuario = (String) request.getParameter("idUsuario");
			log.debug("idUsuario: "+ idUsuario);
			
			UsuarioService service = new UsuarioServiceImpl();
			UsuarioJPA usuario = service.obtenerUsuarioById(Integer.valueOf(idUsuario));
			request.setAttribute("objUsuario", usuario  );
			
			RolService service2 = new RolServiceImpl();
			List<RolJPA> lista = service2.listarRol();
			request.setAttribute("lstRoles", lista);
			
			request.setAttribute("idUsuario", idUsuario);
			request.setAttribute("btnAccion", "update");
			
			despachador = request.getRequestDispatcher("/formulario/formularioUsuario.jsp");
		}else if ("eliminar".equals(accion)) {
			
			log.debug("accion:"+accion);
			
			UsuarioService service4 = new UsuarioServiceImpl();
			CRUDService service3 = new CRUDServiceImpl();
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			service3.eliminar(idUsuario);
			int bandera = 1;
			
			if (bandera == 0) {
				request.setAttribute("error",true);
				log.debug("error true");		
			}else if (bandera == 1) {
				request.setAttribute("eliminado", true);
				log.debug("eliminado correctamente");	
			}
			
			List<UsuarioJPA>lstUsuario = service4.listarUsuarios();
			request.setAttribute("lstUsuarios", lstUsuario);
			despachador = request.getRequestDispatcher("/listados/listaUsuarios.jsp");
		}
		despachador.forward(request, response);
		log.info("fin: ServletGestionUsuario - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
