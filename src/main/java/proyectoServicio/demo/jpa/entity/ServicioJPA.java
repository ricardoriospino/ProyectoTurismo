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
	
	@Column (name="codigo_servicio" , nullable=false , length= 50 , unique= true)
	private String codigo_servicio;
	
	@Column (name="nombre_servicio", nullable=false, length= 50)
	private String nombreServicio;
	
	// extra 
	
	
	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	// comodin 
	

	public String getCodigo_servicio() {
		return codigo_servicio;
	}

	

	public void setCodigo_servicio(String codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public ServicioJPA() {
		
	}

	public ServicioJPA(int idServicio, String codigo_servicio, String nombreServicio) {
		super();
		this.idServicio = idServicio;
		this.codigo_servicio = codigo_servicio;
		this.nombreServicio = nombreServicio;
	}

	@Override
	public String toString() {
		return "ServicioJPA [idServicio=" + idServicio + ", codigo_servicio=" + codigo_servicio + ", nombreServicio="
				+ nombreServicio + "]";
	}	

}
