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
@Table (name="tb_usuario")
public class UsuarioJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_usuario")
	private int idUsuario;
	
	@Column (name="nombre_usuario" , nullable=false , length= 50 )
	private String nombreUsuario;
	
	@Column (name="apellido" , nullable=false , length= 50 )
	private String apellido;
	
	@Column (name="usuario" , nullable=false , length= 50 , unique= true)
	private String usuario;
	
	@Column (name="clave" , nullable=false , length= 50 )
	private String clave;
	
	@JoinColumn(name="id_rol", referencedColumnName = "id_rol")
	@ManyToOne
	private RolJPA rol;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public RolJPA getRol() {
		return rol;
	}

	public void setRol(RolJPA rol) {
		this.rol = rol;
	}
	
	public UsuarioJPA() {
		
	}

	public UsuarioJPA(int idUsuario, String nombreUsuario, String apellido, String usuario, String clave, RolJPA rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}
	
	

	public UsuarioJPA(String nombreUsuario, String apellido, String usuario, String clave, RolJPA rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioJPA [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", clave=" + clave + ", rol=" + rol + "]";
	}
	
	

}
