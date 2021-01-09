package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_servicio")
public class ServicioJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_servicio")
	private int idServicio;
	
	@Column (name="nombre_servicio", nullable=false, length=50)
	private String nombreServicio;

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	
	public ServicioJPA() {
		
	}

	public ServicioJPA(int idServicio, String nombreServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
	}

	@Override
	public String toString() {
		return "ServicioJPA [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + "]";
	}
	
	

}
