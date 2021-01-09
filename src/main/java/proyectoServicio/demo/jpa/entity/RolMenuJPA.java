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
@Table (name="tb_rol_menu")
public class RolMenuJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_rol_menu")
	private int idRolMenu;
	
	@JoinColumn(name="id_rol", referencedColumnName = "id_rol")
	@ManyToOne
	private RolJPA rol;
	
	@JoinColumn(name="id_menu", referencedColumnName = "id_menu")
	@ManyToOne
	private MenuJPA menu;

	public int getIdRolMenu() {
		return idRolMenu;
	}

	public void setIdRolMenu(int idRolMenu) {
		this.idRolMenu = idRolMenu;
	}

	public RolJPA getRol() {
		return rol;
	}

	public void setRol(RolJPA rol) {
		this.rol = rol;
	}

	public MenuJPA getMenu() {
		return menu;
	}

	public void setMenu(MenuJPA menu) {
		this.menu = menu;
	}
	
	public RolMenuJPA() {
		
	}

	public RolMenuJPA(int idRolMenu, RolJPA rol, MenuJPA menu) {
		super();
		this.idRolMenu = idRolMenu;
		this.rol = rol;
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "RolMenuJPA [idRolMenu=" + idRolMenu + ", rol=" + rol + ", menu=" + menu + "]";
	}
	
	

}
