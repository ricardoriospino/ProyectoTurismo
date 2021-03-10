package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.hibernate.tool.schema.extract.spi.ForeignKeyInformation;

import proyectoServicio.demo.bean.CarritoCompraBean;
import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.CRUDService;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.CRUDServiceImpl;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;

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

		List<CarritoCompraBean> lstCarrito = (List<CarritoCompraBean>) misession.getAttribute("carritoCompras");
		
		misession.getAttribute("totalSinIgv");
		misession.getAttribute("TotlIgv");
		misession.getAttribute("totalConIgv");
		misession.getAttribute("contadorCarrito");

		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher(pagina);
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
		List<CarritoCompraBean> lstCarrito = (List<CarritoCompraBean>) misession.getAttribute("carritoCompras");
		
//		DOUBLE TOTALSINIGV = (DOUBLE) MISESSION.GETATTRIBUTE("TOTALSINIGV");
//		DOUBLE IGVTOTAL = (DOUBLE) MISESSION.GETATTRIBUTE("TOTLIGV");
//		DOUBLE TOTALCONIGV = (DOUBLE) MISESSION.GETATTRIBUTE("TOTALCONIGV");
		
		CRUDService crudService = new CRUDServiceImpl();
		LugarTuristicoService lugaresTuristicoService = new LugarTuristicoServiceImpl();
		
		//fecha de compra
		Date fechaCompra =  new Date();
		
		// fecha de viajes 
		for(CarritoCompraBean carrito : lstCarrito) {
			CompraJPA compra = new CompraJPA();
			
			String fechaParse = carrito.getFechaDeViaje();
			
			Date fechaViaje = null;
			try {
				fechaViaje = new SimpleDateFormat("yyyy-MM-dd").parse(fechaParse);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// insertando a la bbdd
			LugarTuristicoJPA paquete = lugaresTuristicoService.getLugarTuristicoById(carrito.getIdTour());
			compra.setCantidadPersonas(carrito.getCantidad());
			compra.setSubTotal(carrito.getSubTotal());
			compra.setFechaViaje(fechaViaje);
			compra.setFechaCompra(fechaCompra);
			compra.setUsuario(usuario);
			compra.setLugarTuristico(paquete);
			
			crudService.insertar(compra);
			
		}
		
		misession.removeAttribute("carritoCompras");
		misession.removeAttribute("totalSinIgv");
		misession.removeAttribute("TotlIgv");
		misession.removeAttribute("totalConIgv");
		misession.removeAttribute("contadorCarrito");
		
		String mensaje= "<strong>Compra Exitosa!</strong> Gracias por realizar su compra.";
		request.setAttribute("Comprado", true);
		request.setAttribute("msg", mensaje);
		
		RequestDispatcher despachador =null;
		despachador= request.getRequestDispatcher("carritoCompra.jsp");
		despachador.forward(request, response);	

		log.info(" fin : ServletDatosVentaPaquete - doPost()");
	}

}
