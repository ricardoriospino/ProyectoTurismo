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
@Table (name="tb_rol_permiso")
public class RolPermisoJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_rol_permiso")
	private int idRolPermiso;
	
	@JoinColumn(name="id_rol", referencedColumnName = "id_rol")
	@ManyToOne
	private RolJPA rol;
	
	@JoinColumn(name="id_permiso", referencedColumnName = "id_permiso")
	@ManyToOne
	private PermisoJPA permiso;

	public int getIdRolPermiso() {
		return idRolPermiso;
	}

	public void setIdRolPermiso(int idRolPermiso) {
		this.idRolPermiso = idRolPermiso;
	}

	public RolJPA getRol() {
		return rol;
	}

	public void setRol(RolJPA rol) {
		this.rol = rol;
	}

	public PermisoJPA getPermiso() {
		return permiso;
	}

	public void setPermiso(PermisoJPA permiso) {
		this.permiso = permiso;
	}


	
	public RolPermisoJPA() {
		
	}
	public RolPermisoJPA(int idRolPermiso, RolJPA rol, PermisoJPA permiso) {
		super();
		this.idRolPermiso = idRolPermiso;
		this.rol = rol;
		this.permiso = permiso;
	}

	@Override
	public String toString() {
		return "RolPermisoJPA [idRolPermiso=" + idRolPermiso + ", rol=" + rol + ", permiso=" + permiso + "]";
	}
	
	

}
