package proyectoServicio.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import proyectoServicio.demo.bean.ListaComprasBean;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.CompraService;
import proyectoServicio.demo.service.LugarTuristicoService;
import proyectoServicio.demo.service.UsuarioService;
import proyectoServicio.demo.service.impl.CompraServiceImpl;
import proyectoServicio.demo.service.impl.LugarTuristicoServiceImpl;
import proyectoServicio.demo.service.impl.UsuarioServiceImpl;


/**
 * Servlet implementation class ServletListaExportarExcel
 */
@WebServlet("/ServletListaExportarExcel")
public class ServletListaExportarExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log= LogManager.getLogger(ServletListaExportarExcel.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaExportarExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		log.info("ini: get ServletListaExportarExcel()");
		
		String p_reporte = (String) request.getParameter("p_reporte");
		
		response.setContentType("application/vnd.ms-excel");
		
		if("REPLISTATOUR0001".equals(p_reporte)) {
			
			response.setHeader("Content-Disposition", "attachment; filename=ListaPaquetesTouristicos.xls");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Cache-control", "no-store");
			
			PrintWriter out = response.getWriter();
			LugarTuristicoService service = new LugarTuristicoServiceImpl();
			List<LugarTuristicoJPA> lstTours = service.listarLugaresTuristicos(); 
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
				out.println("<body>");
					out.println("<table>");
					 out.println("<tr><th>Orden </th><th>ID </th><th>Codigo</th><th>nombre</th><th>descripcion</th>"
							 	+ "<th>foto 1</th><th>foto 2</th><th>foto 3</th><th>Precio por Persona</th>"
							 	+ "<th>Insertado Por </th><th>Modificado Por</th><th>fecha Ingresada</th>"
							 	+ "<th>Fecha Actualizada</th><th>Calificacion Estrellas</th>"
						 		+ "<th>Hanilitado/Deshabilitado</th><th>Clima</th></tr>");
					 for (int i = 0; i <lstTours.size() ; i++) {
						 LugarTuristicoJPA paqueteTour = lstTours.get(i);
						 
						 out.println("<tr><td>" + (i+1) + "</td><td>" + paqueteTour.getIdLugarTuristico() +"</td><td>" + paqueteTour.getCodigoLugarTuristico() + "</td><td>" + paqueteTour.getNombre()  + "</td><td>"  
								 	+ paqueteTour.getDescripcion() + "</td><td>" + paqueteTour.getUrlImagen1()  + "</td><td>"+ paqueteTour.getUrlImagen2() + "</td><td>"+ paqueteTour.getUrlImagen3()+ "</td><td>" 
								 	+ paqueteTour.getPrecioXpersona() + "</td><td>"+ paqueteTour.getInsertadoPor() + "</td><td>"+  paqueteTour.getModificadoPor() + "</td><td>"+ paqueteTour.getFechaInsert() + "</td><td>"
								 	+ paqueteTour.getFechaUpdate() + "</td><td>"+ paqueteTour.getCalificacionEstrellas() + "</td><td>"+ paqueteTour.getHabilitadoODeshabilitado() + "</td><td>"+ paqueteTour.getClimaTour() +"</td></tr>");
						
					}
			
					out.println("</table>");
				out.println("</body>");
			out.println("</html>");
			
			
		}else if("REPLISTAUSU0002".equals(p_reporte)) {
			
			response.setHeader("Content-Disposition", "attachment; filename=ListaUsuarios.xls");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Cache-control", "no-store");
			
			PrintWriter out = response.getWriter();
			UsuarioService serviceUsuario = new UsuarioServiceImpl();
			List<UsuarioJPA> lstUsuario = serviceUsuario.listarUsuarios();

			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
				out.println("<body>");
					out.println("<table>");
					 out.println("<tr><th>Orden </th><th>ID </th><th>nombre</th><th>apellido</th><th>usuario</th><th> Rol</th></tr>");
					 for(int i=0;i<lstUsuario.size();i++) {
						 UsuarioJPA usuario = lstUsuario.get(i);
						 out.println("<tr><td>"+(i+1)+"</td><td>" + usuario.getIdUsuario() + "</td><td>"+ usuario.getNombreUsuario() + "</td><td>"
								 	+ usuario.getApellido() + "</td><td>" + usuario.getUsuario() + "</td><td>" + usuario.getIdUsuario() +"</td></tr>");
					 }
					
					out.println("</table>");
				out.println("</body>");
			out.println("</html>");
			
		}else if ("REPLISTAUSU0003".equals(p_reporte)) {
			
			response.setHeader("Content-Disposition", "attachment; filename=ListaVenta.xls");
			response.setHeader("Pragma", "no-cache"); 
			response.setHeader("Cache-control", "no-store");
			
			PrintWriter out = response.getWriter();
			CompraService compraService = new CompraServiceImpl();
			List<ListaComprasBean> lista =  compraService.listarCompra();
			
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
				out.println("<body>");
					out.println("<table>");
					 out.println("<tr><th>Orden </th><th>Codigo Paquete </th><th>Nombre Paquete</th><th>Usuario</th><th>Nombre Cliente</th><th> Fecha Salida</th><th>Sub Total</th></tr>");
					 for(int i=0;i<lista.size();i++) {
						 ListaComprasBean listaCompras = lista.get(i);
						 out.println("<tr><td>"+(i+1)+"</td><td>" + listaCompras.getCodigoTour() + "</td><td>"+ listaCompras.getNombreTour() + "</td><td>"
								 	+ listaCompras.getUsuario() + "</td><td>" + listaCompras.getNombreUsuario() + "</td><td>" + listaCompras.getFechaSalida() +"</td><td>"
								 	+ listaCompras.getSubTotal() +"</td></tr>");
					 }
					out.println("</table>");
				out.println("</body>");
			out.println("</html>");
	
		}
		
		log.info("FIN: get ServletListaExportarExcel()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
