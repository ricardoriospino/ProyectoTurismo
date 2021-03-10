package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="tb_compra")
public class CompraJPA implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_compra")
	private int idCompra;
	
	@Column (name="cantidad_personas" , nullable=false , length= 50 )
	private int cantidadPersonas;
	
	@Column (name="sub_total" , nullable=false , precision=10, scale=2)
	private double subTotal;
	
	@Column (name="fecha_compra" , nullable=true )
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCompra;
	
	@Column (name="fecha_viaje" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date fechaViaje;
	
	@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne
	private UsuarioJPA usuario;
	
	@JoinColumn(name="id_lugar_turistico", referencedColumnName = "id_lugar_turistico")
	@ManyToOne
	private LugarTuristicoJPA lugarTuristico;
	
	public CompraJPA() {
		
	}

	

	public CompraJPA(int idCompra, int cantidadPersonas, double subTotal, Date fechaCompra, Date fechaViaje,
			UsuarioJPA usuario, LugarTuristicoJPA lugarTuristico) {
		super();
		this.idCompra = idCompra;
		this.cantidadPersonas = cantidadPersonas;
		this.subTotal = subTotal;
		this.fechaCompra = fechaCompra;
		this.fechaViaje = fechaViaje;
		this.usuario = usuario;
		this.lugarTuristico = lugarTuristico;
	}

	

	public int getIdCompra() {
		return idCompra;
	}



	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}



	public int getCantidadPersonas() {
		return cantidadPersonas;
	}



	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}



	public double getSubTotal() {
		return subTotal;
	}



	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}



	public Date getFechaCompra() {
		return fechaCompra;
	}



	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}



	public Date getFechaViaje() {
		return fechaViaje;
	}



	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}



	public UsuarioJPA getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioJPA usuario) {
		this.usuario = usuario;
	}



	public LugarTuristicoJPA getLugarTuristico() {
		return lugarTuristico;
	}



	public void setLugarTuristico(LugarTuristicoJPA lugarTuristico) {
		this.lugarTuristico = lugarTuristico;
	}



	@Override
	public String toString() {
		return "CompraJPA [idCompra=" + idCompra + ", cantidadPersonas=" + cantidadPersonas + ", subTotal=" + subTotal
				+ ", fechaCompra=" + fechaCompra + ", fechaViaje=" + fechaViaje + ", usuario=" + usuario
				+ ", lugarTuristico=" + lugarTuristico + "]";
	}



}
	
