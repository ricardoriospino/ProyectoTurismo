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
	
	@Column (name="codigo_lugar_turistico" , nullable=false , length= 50 , unique= true)
	private String codigoLugarTuristico;
	
	
	@Column (name="nombre" , nullable=false , length= 200)
	private String nombre;
	
	@Column (name="descripcion" , nullable=false , length= 300)
	private String descripcion;
	
	@Column (name="url_imagen1" , nullable=false , length= 200)
	private String urlImagen1;
	
	@Column (name="url_imagen2" , nullable=false , length= 200)
	private String urlImagen2;
	
	@Column (name="url_imagen3" , nullable=false , length= 200)
	private String urlImagen3;
	
	@Column (name="precio_x_persona" , nullable=false , precision=10, scale=2)
	private double precioXpersona;
	
	@Column (name="insertado_por" , nullable=true , length= 50)
	private String insertadoPor;
	
	@Column (name="modificado_por" , nullable=true , length= 50)
	private String modificadoPor;

	@Column (name="fecha_insert" , nullable=true )
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInsert;
	
	@Column (name="fecha_update" , nullable=true )
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUpdate;
	

	@Column (name="calificacion_estrellas" , nullable = false , length= 10)
	private int calificacionEstrellas;
	
	@Column (name="habilitado_o_deshabilitado" , nullable = false , length = 100)
	private  String habilitadoODeshabilitado;
	
	@Column (name="clima_tour" , nullable =false , length = 100)
	private String climaTour;
	
	public LugarTuristicoJPA() {
		
	}

	

	public int getIdLugarTuristico() {
		return idLugarTuristico;
	}



	public void setIdLugarTuristico(int idLugarTuristico) {
		this.idLugarTuristico = idLugarTuristico;
	}



	public String getCodigoLugarTuristico() {
		return codigoLugarTuristico;
	}



	public void setCodigoLugarTuristico(String codigoLugarTuristico) {
		this.codigoLugarTuristico = codigoLugarTuristico;
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



	public String getUrlImagen1() {
		return urlImagen1;
	}



	public void setUrlImagen1(String urlImagen1) {
		this.urlImagen1 = urlImagen1;
	}



	public String getUrlImagen2() {
		return urlImagen2;
	}



	public void setUrlImagen2(String urlImagen2) {
		this.urlImagen2 = urlImagen2;
	}



	public String getUrlImagen3() {
		return urlImagen3;
	}



	public void setUrlImagen3(String urlImagen3) {
		this.urlImagen3 = urlImagen3;
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



	public int getCalificacionEstrellas() {
		return calificacionEstrellas;
	}



	public void setCalificacionEstrellas(int calificacionEstrellas) {
		this.calificacionEstrellas = calificacionEstrellas;
	}



	public String getHabilitadoODeshabilitado() {
		return habilitadoODeshabilitado;
	}



	public void setHabilitadoODeshabilitado(String habilitadoODeshabilitado) {
		this.habilitadoODeshabilitado = habilitadoODeshabilitado;
	}



	public String getClimaTour() {
		return climaTour;
	}



	public void setClimaTour(String climaTour) {
		this.climaTour = climaTour;
	}



	public LugarTuristicoJPA(int idLugarTuristico, String codigoLugarTuristico, String nombre, String descripcion,
			String urlImagen1, String urlImagen2, String urlImagen3, double precioXpersona, String insertadoPor,
			String modificadoPor, Date fechaInsert, Date fechaUpdate, int calificacionEstrellas,
			String habilitadoODeshabilitado, String climaTour) {
		super();
		this.idLugarTuristico = idLugarTuristico;
		this.codigoLugarTuristico = codigoLugarTuristico;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen1 = urlImagen1;
		this.urlImagen2 = urlImagen2;
		this.urlImagen3 = urlImagen3;
		this.precioXpersona = precioXpersona;
		this.insertadoPor = insertadoPor;
		this.modificadoPor = modificadoPor;
		this.fechaInsert = fechaInsert;
		this.fechaUpdate = fechaUpdate;
		this.calificacionEstrellas = calificacionEstrellas;
		this.habilitadoODeshabilitado = habilitadoODeshabilitado;
		this.climaTour = climaTour;
	}
	
	

	public LugarTuristicoJPA(String codigoLugarTuristico, String nombre, String descripcion, String urlImagen1,
			String urlImagen2, String urlImagen3, double precioXpersona, String insertadoPor, Date fechaInsert,
			int calificacionEstrellas, String habilitadoODeshabilitado, String climaTour) {
		super();
		this.codigoLugarTuristico = codigoLugarTuristico;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen1 = urlImagen1;
		this.urlImagen2 = urlImagen2;
		this.urlImagen3 = urlImagen3;
		this.precioXpersona = precioXpersona;
		this.insertadoPor = insertadoPor;
		this.fechaInsert = fechaInsert;
		this.calificacionEstrellas = calificacionEstrellas;
		this.habilitadoODeshabilitado = habilitadoODeshabilitado;
		this.climaTour = climaTour;
	}
	
	
	
	public LugarTuristicoJPA(String codigoLugarTuristico, String nombre, String descripcion, String urlImagen1,
			String urlImagen2, String urlImagen3, double precioXpersona, String insertadoPor, Date fechaInsert,
			Date fechaUpdate, int calificacionEstrellas, String habilitadoODeshabilitado, String climaTour) {
		super();
		this.codigoLugarTuristico = codigoLugarTuristico;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen1 = urlImagen1;
		this.urlImagen2 = urlImagen2;
		this.urlImagen3 = urlImagen3;
		this.precioXpersona = precioXpersona;
		this.insertadoPor = insertadoPor;
		this.fechaInsert = fechaInsert;
		this.fechaUpdate = fechaUpdate;
		this.calificacionEstrellas = calificacionEstrellas;
		this.habilitadoODeshabilitado = habilitadoODeshabilitado;
		this.climaTour = climaTour;
	}

	@Override
	public String toString() {
		return "LugarTuristicoJPA [idLugarTuristico=" + idLugarTuristico + ", codigoLugarTuristico="
				+ codigoLugarTuristico + ", nombre=" + nombre + ", descripcion=" + descripcion + ", urlImagen1="
				+ urlImagen1 + ", urlImagen2=" + urlImagen2 + ", urlImagen3=" + urlImagen3 + ", precioXpersona="
				+ precioXpersona + ", insertadoPor=" + insertadoPor + ", modificadoPor=" + modificadoPor
				+ ", fechaInsert=" + fechaInsert + ", fechaUpdate=" + fechaUpdate + ", calificacionEstrellas="
				+ calificacionEstrellas + ", habilitadoODeshabilitado=" + habilitadoODeshabilitado + ", climaTour="
				+ climaTour + "]";
	}
}
