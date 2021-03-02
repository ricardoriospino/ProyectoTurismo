package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.ServicioService;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.ServicioServiceImpl;


/**
 * Servlet implementation class ServletListarServicosTour
 */
@WebServlet("/ServletInfoTour")
public class ServletInfoTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletInfoTour.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInfoTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(" ini : ServletInfoTour - doGe()");
		
		
		RequestDispatcher despachador = null;
		
		//obtener id
		String idLugarTuristico = (String) request.getParameter("idLugarTuristico");
		log.debug("idLugarTuristico :" , idLugarTuristico);
		
		
		LugarTuristicoService service = new LugarTuristicoServiceImpl();
		LugarTuristicoJPA lugarTuristico = service.getLugarTuristicoById(Integer.parseInt(idLugarTuristico));
		request.setAttribute("objLugarTuristico", lugarTuristico);
		
		ServicioService serviceServicio = new ServicioServiceImpl();
		List<ServicioJPA>lista = serviceServicio.listarServiciosTour(Integer.valueOf(idLugarTuristico));
		request.setAttribute("lstServiciosIncluidos", lista);
			
		request.setAttribute("idLugarTuristico", idLugarTuristico);
		
		despachador = request.getRequestDispatcher("/lugaresTuristicos/tourInfo.jsp");
		
		despachador.forward(request, response);
		
		log.info(" ini : ServletInfoTour - doGe()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		log.info(" ini : ServletInfoTour - doPost()");
		
		HttpSession misession = request.getSession(true);  

		int idTour = Integer.parseInt(request.getParameter("hdnLugaresTuristicos"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		log.debug("el idTour es : " + idTour + " la cantidad es : " + cantidad);
		
		LugarTuristicoService serviceTour = new LugarTuristicoServiceImpl();
		LugarTuristicoJPA tourAgregado = serviceTour.getLugarTuristicoById(idTour);
		double subTotal = cantidad * tourAgregado.getPrecioXpersona();
		
		//carrito de compras 	
		List<carritoCompraBean> lstCarrito = (List<carritoCompraBean>) misession.getAttribute("carritoCompras");
		
		if(lstCarrito == null)lstCarrito = new ArrayList<>();
		
		carritoCompraBean carritoCompra = new carritoCompraBean(idTour, tourAgregado.getNombre(), tourAgregado.getUrlImagen1(),tourAgregado.getPrecioXpersona(), 
																cantidad, subTotal);

		lstCarrito.add(carritoCompra);
		
		misession.setAttribute("carriCompras", lstCarrito);
		
		//suma total
		double totalLista =0;
		for (carritoCompraBean lista : lstCarrito)
			totalLista+=lista.getSubTotal();
			log.debug("total : " + totalLista);
			
		request.setAttribute("total", totalLista);
		 
		 log.debug("el carrito de compras id y cantidad : " + carritoCompra);
		
		String pagina = "carritoCompra.jsp";
		String mensaje = "<strong>Ingresado!</strong> Datos Ingresados al carrito compra.";
		request.setAttribute("ingresado", true);
		request.setAttribute("msg", mensaje);
		
		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher(pagina);
		despachador.forward(request, response);		
		
		log.info(" fin : ServletInfoTour - doPost()");
	}

}
