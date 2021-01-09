package proyectoServicio.demo.cnx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory FACTORY = 
			Persistence.createEntityManagerFactory("dataSourceJPA"); // dataSourceJPA sale de persistence.xml
	
	
	//Obtiene la conexion a la base de datos bdjpa
	public static EntityManager getEntityManager(){
		return FACTORY.createEntityManager();
	}
	
}