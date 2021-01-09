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
@Table (name="tb_compra")
public class CompraJPA implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_compra")
	private int idCompra;
	
	@Column (name="cantidad_personas" , nullable=false , length= 50 )
	private int cantidadPersonas;
	
	@Column (name="monto_total" , nullable=false , precision=10, scale=2)
	private double montoTotal;
	
	@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne
	private UsuarioJPA usuario;
	
	@JoinColumn(name="id_lugar_turistico", referencedColumnName = "id_lugar_turistico")
	@ManyToOne
	private LugarTuristicoJPA lugarTuristico;

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

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
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
	
	public CompraJPA() {
		
	}

	public CompraJPA(int idCompra, int cantidadPersonas, double montoTotal, UsuarioJPA usuario,
			LugarTuristicoJPA lugarTuristico) {
		super();
		this.idCompra = idCompra;
		this.cantidadPersonas = cantidadPersonas;
		this.montoTotal = montoTotal;
		this.usuario = usuario;
		this.lugarTuristico = lugarTuristico;
	}

	@Override
	public String toString() {
		return "CompraJPA [idCompra=" + idCompra + ", cantidadPersonas=" + cantidadPersonas + ", montoTotal="
				+ montoTotal + ", usuario=" + usuario + ", lugarTuristico=" + lugarTuristico + "]";
	}
	
	
}
