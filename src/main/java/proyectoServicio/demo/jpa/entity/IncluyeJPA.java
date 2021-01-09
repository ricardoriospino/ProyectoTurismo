package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="tb_incluye")
public class IncluyeJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_incluye")
	private int idIncluye;
	
	@Column (name="costo" , nullable=false , precision=10, scale=2)
	private double costo;
	
	@JoinColumn(name="id_lugar_turistico", referencedColumnName = "id_lugar_turistico")
	@ManyToOne
	private LugarTuristicoJPA lugarTuristico;
	
	@JoinColumn(name="id_servicio", referencedColumnName = "id_servicio")
	@ManyToOne
	private ServicioJPA servicio;

	public int getIdIncluye() {
		return idIncluye;
	}

	public void setIdIncluye(int idIncluye) {
		this.idIncluye = idIncluye;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public LugarTuristicoJPA getLugarTuristico() {
		return lugarTuristico;
	}

	public void setLugarTuristico(LugarTuristicoJPA lugarTuristico) {
		this.lugarTuristico = lugarTuristico;
	}

	public ServicioJPA getServicio() {
		return servicio;
	}

	public void setServicio(ServicioJPA servicio) {
		this.servicio = servicio;
	}
	
	public IncluyeJPA() {
		
	}

	public IncluyeJPA(int idIncluye, double costo, LugarTuristicoJPA lugarTuristico, ServicioJPA servicio) {
		super();
		this.idIncluye = idIncluye;
		this.costo = costo;
		this.lugarTuristico = lugarTuristico;
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "IncluyeJPA [idIncluye=" + idIncluye + ", costo=" + costo + ", lugarTuristico=" + lugarTuristico
				+ ", servicio=" + servicio + "]";
	}
	

}
