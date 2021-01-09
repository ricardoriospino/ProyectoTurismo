package proyectoServicio.demo.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_menu")
public class MenuJPA implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_menu")
	private int idMenu;
	
	@Column (name="codigo_menu" , nullable=false , length= 50 , unique= true)
	private String codigoMenu;
	
	@Column (name="menu" , nullable=false , length= 50 )
	private String menu;

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getCodigoMenu() {
		return codigoMenu;
	}

	public void setCodigoMenu(String codigoMenu) {
		this.codigoMenu = codigoMenu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public MenuJPA() {
		
	}

	public MenuJPA(int idMenu, String codigoMenu, String menu) {
		super();
		this.idMenu = idMenu;
		this.codigoMenu = codigoMenu;
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "MenuJPA [idMenu=" + idMenu + ", codigoMenu=" + codigoMenu + ", menu=" + menu + "]";
	}
	
	
	

}
