package proyectoServicio.demo.service.impl;

import java.util.List;

import proyectoServicio.demo.dao.CompraDAO;
import proyectoServicio.demo.dao.impl.CompraDAOImpl;
import proyectoServicio.demo.service.CompraService;

public class CompraServiceImpl implements CompraService {

	private CompraDAO compraDAO;
	
	public CompraServiceImpl() {
		compraDAO = new CompraDAOImpl();
	}

	@Override
	public List<Object[]> listarCompra() {
		
		return compraDAO.listarCompra();
	}
}
