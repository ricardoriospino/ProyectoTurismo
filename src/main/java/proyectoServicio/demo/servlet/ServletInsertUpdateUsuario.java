package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ServletInsertUpdateUsuario
 */
@WebServlet("/ServletInsertUpdateUsuario")
public class ServletInsertUpdateUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletInsertUpdateUsuario.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertUpdateUsuario() {
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
		
		log.info("Ini: ServletInsertUpdateUsuario doPost");
		
		String accion = request.getParameter("hdnAccion");
		
		log.debug("accion" + accion );
		
		String nombreForm = request.getParameter("nombre_usuario");
		String apellidoForm = request.getParameter("apellido");
		String usuarioForm = request.getParameter("usuario");
		String claveForm = request.getParameter("clave");
		
		RolJPA idRolForm = new RolJPA();
		
		idRolForm.setIdRol(Integer.valueOf(request.getParameter("id_rol")));
	
		log.debug("Datos ingresados , nombre: " + nombreForm + " , apellido : " + apellidoForm + " ,usuario : " + usuarioForm
				  + " clave : " + claveForm + " id Rol : " + idRolForm);
		
		CRUDService serviceCrud = new CRUDServiceImpl();
		int estado = 0;
		UsuarioJPA usuario = null;
		String mensaje="";
		
		UsuarioService serviceUsuario = new UsuarioServiceImpl();
		
		Long validarUsuario = (Long) serviceUsuario.validarUsuario(usuarioForm);
		
		RequestDispatcher despachador =null;
		
		if("insert".equals(accion)) {
			
			estado = 1;
			if(validarUsuario == 0L && estado == 1) {
				
				usuario = new UsuarioJPA(nombreForm, apellidoForm, usuarioForm, claveForm,  idRolForm);
				serviceCrud.insertar(usuario);
				
				mensaje = "<strong>Ingresado!</strong> Datos Ingresado correctamente a la base de datos.";
					
				request.setAttribute("ingresado", true);
				request.setAttribute("msg", mensaje);
				despachador= request.getRequestDispatcher("/ServletRol");
						
				
			}else if(validarUsuario == 1L ) {
				
				request.setAttribute("error",true);
				log.debug("error true");
				despachador= request.getRequestDispatcher("/ServletRol");
				
			}
			
		}else if("update".equals(accion)) {
			
			estado = 1;
			
			if( estado == 1) {
	
				String idUsuario = request.getParameter("hdnIdUsuario");
				usuario = new UsuarioJPA(Integer.valueOf(idUsuario), nombreForm, apellidoForm, usuarioForm, claveForm, idRolForm);
				serviceCrud.actualizar(usuario);
				
				mensaje ="<strong>Actualizado!</strong> Datos Actualizados  la base de datos.";
				request.setAttribute("actualizado", true);
				request.setAttribute("msg", mensaje);
				despachador= request.getRequestDispatcher("/ServletRol");
				
			}else if(validarUsuario == 0L  ) {
				
				request.setAttribute("error",true);
				log.debug("error true");
				
				String idUsuario = request.getParameter("hdnIdUsuario");	
				UsuarioService service = new UsuarioServiceImpl();
				UsuarioJPA usuarioById = service.obtenerUsuarioById(Integer.valueOf(idUsuario));
				request.setAttribute("objUsuario", usuarioById  );
				
				RolService service2 = new RolServiceImpl();
				List<RolJPA> lista = service2.listarRol();	
				request.setAttribute("lstRoles", lista);
				
				despachador= request.getRequestDispatcher("/ServletRol");
			}
		}

		despachador.forward(request, response);	
		log.info("Fin: ServletInsertUpdateUsuario doPost");
	}

}
