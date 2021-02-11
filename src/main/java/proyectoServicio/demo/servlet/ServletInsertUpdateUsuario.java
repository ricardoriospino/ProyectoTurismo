package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import proyectoServicio.demo.service.impl.CRUDServiceImpl;


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
		
		CRUDService service = new CRUDServiceImpl();
		int estado = 0;
		UsuarioJPA usuario = null;
		String mensaje="";
		
		if("insert".equals(accion)) {
			
			usuario = new UsuarioJPA(nombreForm, apellidoForm, usuarioForm, claveForm,  idRolForm);
			service.insertar(usuario);
			estado = 1;
			mensaje = "<strong>Ingresado!</strong> Datos Ingresado correctamente a la base de datos.";
			
		}else if("update".equals(accion)) {
			
			String idUsuario = request.getParameter("hdnIdUsuario");
			usuario = new UsuarioJPA(Integer.valueOf(idUsuario), nombreForm, apellidoForm, usuarioForm, claveForm, idRolForm);
			service.actualizar(usuario);
			estado = 1;
			mensaje ="<strong>Actualizado!</strong> Datos Actualizados  la base de datos.";
		}
		
		PrintWriter salida = response.getWriter();
		RequestDispatcher disparador =null;
		
		if (estado == 1) {
			request.setAttribute("ingresado", true);
			request.setAttribute("msg", mensaje);
			disparador= request.getRequestDispatcher("/ServletRol");
			
		}else {
			salida.println("<html><body>");
			salida.println("<h3>Alerta</h3>");
			salida.println("producto invalido!");
			salida.println("</html></body>");
			
		}
		
		disparador.forward(request, response);	
		log.info("Fin: ServletInsertUpdateUsuario doPost");
	}

}
