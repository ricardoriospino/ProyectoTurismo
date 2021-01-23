package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_rol")
public class RolJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_rol")
	private int idRol;
	
	@Column (name="codigo_rol" , nullable=false , length= 50 , unique= true)
	private String codigoRol;
	
	@Column (name="descripcion" , nullable=false , length= 100)
	private String descripcion;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RolJPA() {
		
	}

	
	public RolJPA(int idRol, String codigoRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.codigoRol = codigoRol;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "RolJPA [idRol=" + idRol + ", codigoRol=" + codigoRol + ", descripcion=" + descripcion + "]";
	}

	
	

}
