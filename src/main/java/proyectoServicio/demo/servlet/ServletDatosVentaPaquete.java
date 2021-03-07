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

import proyectoServicio.demo.Bean.carritoCompraBean;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

/**
 * Servlet implementation class ServletDatosVentaPaquete
 */
@WebServlet("/ServletDatosVentaPaquete")
public class ServletDatosVentaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletDatosVentaPaquete.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDatosVentaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(" ini : ServletDatosVentaPaquete - doGe()");
		
		String pagina ="/carritoCompra.jsp";
		String accion = request.getParameter("p_accion");
		
		HttpSession misession = request.getSession(true);  
		
		List<carritoCompraBean> lstCarrito = (List<carritoCompraBean>) misession.getAttribute("carritoCompras");
		misession.getAttribute("totalSinIgv");
		misession.getAttribute("TotlIgv");
		misession.getAttribute("totalConIgv");

		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher("/carritoCompra.jsp");
		despachador.forward(request, response);		
		
		log.info(" fin : ServletDatosVentaPaquete - doGe()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		log.info(" ini : ServletDatosVentaPaquete - doPost()");
		
		HttpSession misession = request.getSession(true); 
		
		// usuario
		UsuarioJPA usuario = (UsuarioJPA) misession.getAttribute("usuarioSession");
		log.debug("Usuario "+ usuario.getNombreUsuario());
		
		//detalle venta
		List<carritoCompraBean> lstCarrito = (List<carritoCompraBean>) misession.getAttribute("carritoCompras");
		
		double totalSinIgv = (double) misession.getAttribute("totalSinIgv");
		double igvTotal = (double) misession.getAttribute("TotlIgv");
		double totalConIgv = (double) misession.getAttribute("totalConIgv");
		
		
		
		
		
		log.info(" fin : ServletDatosVentaPaquete - doPost()");
	}

}
