package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_permiso")
public class PermisoJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_permiso")
	private int idPermiso;
	
	@Column (name="codigo_permiso" , nullable=false , length= 50 , unique= true)
	private String codigoPermiso;

	@Column (name="descripcion_permiso" , nullable=false , length= 200 )
	private String descripcionPermiso;

	public int getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getCodigoPermiso() {
		return codigoPermiso;
	}

	public void setCodigoPermiso(String codigoPermiso) {
		this.codigoPermiso = codigoPermiso;
	}

	public String getDescripcionPermiso() {
		return descripcionPermiso;
	}

	public void setDescripcionPermiso(String descripcionPermiso) {
		this.descripcionPermiso = descripcionPermiso;
	}
	
	public PermisoJPA() {
		
	}

	public PermisoJPA(int idPermiso, String codigoPermiso, String descripcionPermiso) {
		super();
		this.idPermiso = idPermiso;
		this.codigoPermiso = codigoPermiso;
		this.descripcionPermiso = descripcionPermiso;
	}

	@Override
	public String toString() {
		return "PermisoJPA [idPermiso=" + idPermiso + ", codigoPermiso=" + codigoPermiso + ", descripcionPermiso="
				+ descripcionPermiso + "]";
	}
	
	
}
