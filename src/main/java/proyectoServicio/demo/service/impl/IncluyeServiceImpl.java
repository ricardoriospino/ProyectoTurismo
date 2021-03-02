package proyectoServicio.demo.service.impl;

import java.util.List;

import proyectoServicio.demo.dao.IncluyeDAO;
import proyectoServicio.demo.dao.impl.IncluyeDAOImpl;
import proyectoServicio.demo.jpa.entity.IncluyeJPA;
import proyectoServicio.demo.service.IncluyeService;

public class IncluyeServiceImpl implements IncluyeService {
	
	private IncluyeDAO incluyeDAO;
	
	public  IncluyeServiceImpl() {
		
		incluyeDAO =  new IncluyeDAOImpl();
	}

	@Override
	public List<IncluyeJPA> listaCostoServicios() {
		
		return incluyeDAO.listaCostoServicios();
	}

	@Override
	public int eliminarServicios(int idTour) {
		
		return incluyeDAO.eliminarServicios(idTour);
	}
	
	

}
