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
		
		UsuarioService serviceUsuario = new UsuarioServiceImpl();
		
		if("editar".equals(accion)){
			
			String idUsuario = (String) request.getParameter("idUsuario");
			log.debug("idUsuario: "+ idUsuario);
			
			
			UsuarioJPA usuario = serviceUsuario.obtenerUsuarioById(Integer.valueOf(idUsuario));
			request.setAttribute("objUsuario", usuario  );
			
			RolService serviceRol = new RolServiceImpl();
			List<RolJPA> lista = serviceRol.listarRol();
			request.setAttribute("lstRoles", lista);
			
			request.setAttribute("idUsuario", idUsuario);
			request.setAttribute("btnAccion", "update");
			
			despachador = request.getRequestDispatcher("/formulario/formularioUsuario.jsp");
		}else if ("eliminar".equals(accion)) {
			
			log.debug("accion:"+accion);
			
			
			CRUDService serviceCrud = new CRUDServiceImpl();
			
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
			// si el usuario tiene compra			
			UsuarioJPA usuarioJPA = new UsuarioJPA();		
			usuarioJPA.setIdUsuario(idUsuario);
			
			Long usuarioCompra = (Long) serviceUsuario.obtenerUsuarioCompra(idUsuario);
			
			if (usuarioCompra >=1L) {
				request.setAttribute("error",true);
				log.debug("error true");	
			}else if(usuarioCompra == 0L) {
				
				int bandera = serviceCrud.eliminar(usuarioJPA);
				
				if(bandera == 0) {
					
					log.debug("no se logro eliminar " + bandera);
					
				}else if(bandera == 1) {
					
					request.setAttribute("eliminado", true);
					log.debug("eliminado correctamente");
					
				}
			}
			
			List<UsuarioJPA>lstUsuario = serviceUsuario.listarUsuarios();
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
