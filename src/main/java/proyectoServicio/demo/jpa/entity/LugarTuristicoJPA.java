package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name="tb_lugar_turistico")
public class LugarTuristicoJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_lugar_turistico")
	private int idLugarTuristico;
	
	@Column (name="nombre" , nullable=false , length= 200)
	private String nombre;
	
	@Column (name="descripcion" , nullable=false , length= 300)
	private String descripcion;
	
	@Column (name="url_imagen" , nullable=false , length= 200)
	private String urlImagen;
	
	@Column (name="precio_x_persona" , nullable=false , precision=10, scale=2)
	private double precioXpersona;
	
	@Column (name="insertado_por" , nullable=true , length= 50)
	private String insertadoPor;
	
	@Column (name="modificado_por" , nullable=true , length= 50)
	private String modificadoPor;

	@Column (name="fecha_insert" , nullable=false )
	@Temporal(TemporalType.DATE)
	private Date fechaInsert;
	
	@Column (name="fecha_update" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date fechaUpdate;

	

	public int getIdLugarTuristico() {
		return idLugarTuristico;
	}

	public void setIdLugarTuristico(int idLugarTuristico) {
		this.idLugarTuristico = idLugarTuristico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public double getPrecioXpersona() {
		return precioXpersona;
	}

	public void setPrecioXpersona(double precioXpersona) {
		this.precioXpersona = precioXpersona;
	}

	public String getInsertadoPor() {
		return insertadoPor;
	}

	public void setInsertadoPor(String insertadoPor) {
		this.insertadoPor = insertadoPor;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Date getFechaInsert() {
		return fechaInsert;
	}

	public void setFechaInsert(Date fechaInsert) {
		this.fechaInsert = fechaInsert;
	}

	public Date getFechaUpdate() {
		return fechaUpdate;
	}

	public void setFechaUpdate(Date fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}
	
	public LugarTuristicoJPA() {
		
	}

	

	public LugarTuristicoJPA(int idLugarTuristico, String nombre, String descripcion, String urlImagen,
			double precioXpersona, String insertadoPor, String modificadoPor, Date fechaInsert, Date fechaUpdate) {
		super();
		this.idLugarTuristico = idLugarTuristico;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
		this.precioXpersona = precioXpersona;
		this.insertadoPor = insertadoPor;
		this.modificadoPor = modificadoPor;
		this.fechaInsert = fechaInsert;
		this.fechaUpdate = fechaUpdate;
	}

	@Override
	public String toString() {
		return "LugarTuristicoJPA [idLugarTuristico=" + idLugarTuristico + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", urlImagen=" + urlImagen + ", precioXpersona=" + precioXpersona + ", insertadoPor="
				+ insertadoPor + ", modificadoPor=" + modificadoPor + ", fechaInsert=" + fechaInsert + ", fechaUpdate="
				+ fechaUpdate + "]";
	}
	
	

}
