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

import proyectoServicio.demo.bean.ListaComprasBean;
import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.service.CompraService;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.impl.CompraServiceImpl;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;

/**
 * Servlet implementation class ServletConsultaVenta
 */
@WebServlet("/ServletConsultarVentas")
public class ServletConsultarVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletConsultarVentas.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info(" ini : ServletConsultarVentas - doGe()");
		
		String pagina ="/consultar/consultarVenta.jsp";
		String accion = request.getParameter("p_accion");
		
		if("inicioConsulta".equals(accion)) {
			
			LugarTuristicoService serviceTour = new LugarTuristicoServiceImpl();
			List<LugarTuristicoJPA> lista = serviceTour.listarLugaresTuristicos();
			request.setAttribute("lstNombrePaquete", lista);	
		}else if ("consultar".equals(accion)) {
	
		}
		
		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher(pagina);
		despachador.forward(request, response);		
		
		
		log.info(" fin : ServletConsultarVentas - doGe()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		log.info(" ini : ServletConsultarVentas - doPost()");
		
		LugarTuristicoJPA codigoTour = new LugarTuristicoJPA();
		codigoTour.setCodigoLugarTuristico(request.getParameter("codigo_paquete"));
		String codigo = codigoTour.getCodigoLugarTuristico() ;
		ListaComprasBean listaBean = new ListaComprasBean();
		
		
		
		//flag
		int semaforo = 0;	
		if (codigo.equals("TDP")) {
			semaforo = 1;
		}else if(!codigo.equals("TDP")) {
			semaforo = 2;
		}
		String fechaIni = request.getParameter("fecha_inicio");
		String fechaFin = request.getParameter("fecha_fin");
		
		CompraJPA compra = new CompraJPA();
		CompraService compraService = new CompraServiceImpl();
		
		if (semaforo == 1  && fechaIni.equals("") && fechaFin.equals("")) {
			
			List<ListaComprasBean> lista1 =  compraService.listarCompra();
			log.debug(lista1);
			request.setAttribute("lstVentas", lista1);
				
			
		} else if (semaforo == 2 && fechaIni.equals("") && fechaFin.equals("") ) {
			
			List<ListaComprasBean> lista2 = compraService.listarCompraById(codigo);
			request.setAttribute("lstVentas", lista2);
			
			if (lista2.isEmpty()) {
				String mensaje = "<strong>Alerta!</strong> No se encuentra informacion";
				request.setAttribute("info", true);
				request.setAttribute("msg", mensaje);
			}
		
		}else if( semaforo== 1  && fechaIni!= null && fechaFin!= null) {
			
			List<ListaComprasBean> lista3 = compraService.listarCompraByFechas(fechaIni, fechaFin);
			request.setAttribute("lstVentas", lista3);
			
			if (lista3.isEmpty()) {
				String mensaje = " No se encuentra informacion";
				request.setAttribute("info", true);
				request.setAttribute("msg", mensaje);
			}
			
		}else if(semaforo == 2 && fechaIni!= null && fechaFin!= null ) {
			
			List<ListaComprasBean> lista4 = compraService.listarCompraByFechasAndCodigoTour(fechaIni, fechaFin, codigo);
			request.setAttribute("lstVentas", lista4);
			
			if (lista4.isEmpty()) {
				String mensaje = " No se encuentra informacion";
				request.setAttribute("info", true);
				request.setAttribute("msg", mensaje);
			}
		}
		
		
		
		
		LugarTuristicoService serviceTour = new LugarTuristicoServiceImpl();
		List<LugarTuristicoJPA> lista = serviceTour.listarLugaresTuristicos();
		request.setAttribute("lstNombrePaquete", lista);	
		
		
		RequestDispatcher despachador = null;
		despachador = request.getRequestDispatcher("/consultar/consultarVenta.jsp");
		despachador.forward(request, response);

		log.info(" fin : ServletConsultarVentas - doPost()");
	}

}
