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

import proyectoServicio.demo.bean.CarritoCompraBean;

/**
 * Servlet implementation class ServletEliminarItem
 */
@WebServlet("/ServletEliminarItem")
public class ServletEliminarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletEliminarItem.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("init: ServletGestionarLugaresTuristicos - doGet ");
		
		HttpSession misession = request.getSession(true);  
		
		int idTour = Integer.parseInt(request.getParameter("idTour"));
		
		List<CarritoCompraBean> lstCarrito = (List<CarritoCompraBean>) misession.getAttribute("carritoCompras");
		
		double totalSinIgv =0;
		double totalConIgv =0;
		double PorcentajeIgv = 0.18;
		double totalIgvPaquete = 0;
		int contador = 0;
		
		for (CarritoCompraBean lista : lstCarrito) {
			totalSinIgv+=Math.round(lista.getSubTotal()*100)/100.0;
			log.debug("total : " + totalSinIgv);		
		}
		
		// contador
		for (CarritoCompraBean compras : lstCarrito) {
			 contador++;	
		}
		
		totalIgvPaquete = Math.round((totalSinIgv * PorcentajeIgv)*100)/100.0;
		totalConIgv = Math.round( (totalSinIgv + totalIgvPaquete)*100)/100.0;
		
		misession.setAttribute("totalSinIgv", totalSinIgv);
		misession.setAttribute("TotlIgv", totalIgvPaquete);
		misession.setAttribute("totalConIgv", totalConIgv);
		misession.setAttribute("contadorCarrito", contador);
		
		if(lstCarrito != null) {
			for (CarritoCompraBean carrito : lstCarrito) {
					if(carrito.getIdTour() == idTour) {
						lstCarrito.remove(carrito);				
						break;
					}
			}		
		}
			
		String pagina = "carritoCompra.jsp";
		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher(pagina);
		despachador.forward(request, response);	
		
		
		log.info("fin: ServletGestionarLugaresTuristicos - doGet ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
